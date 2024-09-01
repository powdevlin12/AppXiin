package com.example.appxin.sqlite2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appxin.R;

public class AddProductSQLite extends AppCompatActivity {
    boolean isupdate;
    int idproduct;
    EditText editName;
    EditText editPrice;
    Button btnAddProduct;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_sqlite);

        editName = this.findViewById(R.id.edt_name_product);
        editPrice = this.findViewById(R.id.edt_price_product);
        btnAddProduct = this.findViewById(R.id.btn_add_item_product);

        product = new Product(0, "", 0);

        editName.setText(product.getProductName());
        editPrice.setText(product.getProductPrice() + "");


        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = openOrCreateDatabase(Sqlite2.DB_NAME, Context.MODE_PRIVATE, null);
                product.setProductName(editName.getText().toString());
                product.setProductPrice(Integer.parseInt(editPrice.getText().toString()));
                    db.execSQL("INSERT INTO product (name, price ) VALUES (?,?)",
                            new String[]{product.getProductName(), product.getProductPrice() + ""});
                db.close();
                setResult(Sqlite2.REQUEST_CODE_ADD_PRODUCT);
                finish();
            }
        });

    }
}