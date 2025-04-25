package com.example.appxin.listviewKt

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appxin.R
import com.example.appxin.listviewcontact.ContactAdapter

class ListViewKt : AppCompatActivity() {
    private lateinit var adapter : LVAdapter
    private val contacts = mutableListOf<Contact>(
        Contact("Nguyễn Văn A", "0123456789", R.drawable.ic_launcher_foreground),
        Contact("Trần Thị B", "0987654321", R.drawable.ic_launcher_background)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_kt)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView : ListView = findViewById(R.id.lv_kt)



        adapter = LVAdapter(this, contacts)

        listView.adapter = adapter


        listView.setOnItemClickListener { _, _, position, _ ->
//            val name = contacts[position].name
//            Toast.makeText(this, "Bạn chọn: $name", Toast.LENGTH_SHORT).show()

            showOptionsDialog(position)
            true
        }
    }


    private fun showOptionsDialog(position: Int) {
        val options = arrayOf("Sửa", "Xoá")
        AlertDialog.Builder(this)
            .setTitle("Tuỳ chọn")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> showContactDialog(contacts[position], position)
                    1 -> {
                        contacts.removeAt(position)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
            .show()
    }

    private fun showContactDialog(contact: Contact?, position: Int) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_contact, null)
        val edtName = dialogView.findViewById<EditText>(R.id.edtName)
        val edtPhone = dialogView.findViewById<EditText>(R.id.edtPhone)

        if (contact != null) {
            edtName.setText(contact.name)
            edtPhone.setText(contact.phone)
        }

        AlertDialog.Builder(this)
            .setTitle(if (contact == null) "Thêm liên hệ" else "Cập nhật")
            .setView(dialogView)
            .setPositiveButton("Lưu") { _, _ ->
                val name = edtName.text.toString()
                val phone = edtPhone.text.toString()
                if (contact == null) {
                    contacts.add(Contact(name, phone, R.drawable.ic_launcher_foreground))
                } else {
                    contacts[position] = Contact(name, phone, contact.img)
                }
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Huỷ", null)
            .show()
    }
}