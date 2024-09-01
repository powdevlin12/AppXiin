package com.example.appxin.sqlite2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

import java.util.ArrayList;

public class Sqlite2 extends AppCompatActivity {
    final static String DB_NAME = "myproduct.db";
    final static int REQUEST_CODE_ADD_PRODUCT = 1203;

    ArrayList<Product> listProduct;
    TextView txtInfomation;
    Button btnAddTable,btnAddProduct, btnDeleteTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite2);

        txtInfomation = this.findViewById(R.id.txt_infomation);
        btnAddTable = this.findViewById(R.id.btn_add_table);
        btnAddProduct = this.findViewById(R.id.btn_add_product);
        btnDeleteTable = this.findViewById(R.id.btn_delete_table);

        listProduct = new ArrayList<>();

        btnAddTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableProduct();
                loadDbProduct();
            }
        });

        btnDeleteTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTableProduct();
                loadDbProduct();
            }
        });

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AddProductSQLite.class);
                startActivityForResult(i, REQUEST_CODE_ADD_PRODUCT);
            }
        });

        loadDbProduct();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_PRODUCT) {
            loadDbProduct();
        }
    }

    boolean isTableExist(SQLiteDatabase db, String table) {
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{table});
        boolean tableExist = (cursor.getCount() != 0);
        cursor.close();
        return tableExist;
    }

    private void loadDbProduct() {
        listProduct.clear();

        SQLiteDatabase db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

        if (!isTableExist(db, "product")) {
            Toast.makeText(this, "Bảng product không tồn tại, cần tạo bảng trước", Toast.LENGTH_LONG).show();
            txtInfomation.setText("Bảng dữ liệu không có, phải tạo bảng");
            btnAddProduct.setVisibility(View.GONE);
            return;
        }

        txtInfomation.setText("PRODUCT");
        btnAddProduct.setVisibility(View.VISIBLE);

        Cursor cursor = db.rawQuery("SELECT id, name, price from product", null);

        //Đến dòng đầu của tập dữ liệu
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int productID = cursor.getInt(0);
            String productName = cursor.getString(1);
            int productPrice = cursor.getInt(2);

            listProduct.add(new Product(productID, productName, productPrice));

            // Đến dòng tiếp theo
            cursor.moveToNext();
        }

        Log.i("AppXiinLog", listProduct.toString());

        cursor.close();
    }

    void createTableProduct() {
        SQLiteDatabase db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        if (!(isTableExist(db, "product"))) {
            String queryCreateTable = "CREATE TABLE product ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name VARCHAR (255) NOT NULL, " +
                    "price DECIMAL DEFAULT (0)" +
                    ")";

            db.execSQL(queryCreateTable);

            Toast.makeText(this, "Đã tạo bảng thành công", Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(this, "Bảng đang tồn tại, không cần tạo mới", Toast.LENGTH_LONG).show();

        db.close();
    }

    private void deleteTableProduct() {
        SQLiteDatabase db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        if (!(isTableExist(db, "product"))) {
            Toast.makeText(this, "Đã không có, không xoá được", Toast.LENGTH_LONG).show();
        } else {
            db.execSQL("DROP TABLE product");
            Toast.makeText(this, "Vùa xoá bảng", Toast.LENGTH_LONG).show();
        }

        db.close();
    }

}