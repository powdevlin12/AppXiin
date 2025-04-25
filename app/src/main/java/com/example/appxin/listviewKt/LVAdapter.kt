package com.example.appxin.listviewKt

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.appxin.R

class LVAdapter(
    private val context : Context,
    private val contactList : List<Contact>
) : BaseAdapter() {
    override fun getCount(): Int {
        return contactList.size
    }

    override fun getItem(p0: Int): Any {
        return contactList[p0];
    }

    override fun getItemId(p0: Int): Long {
        return contactList[p0].phone.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val view = LayoutInflater.from(context).inflate(R.layout.item_lv_kt, parent, false)

        val contact = contactList[position]

        val img = view.findViewById<ImageView>(R.id.img_lv_kt)
        val txtName = view.findViewById<TextView>(R.id.lv_kt_name)
        val txtPhone = view.findViewById<TextView>(R.id.lv_kt_phone)

        img.setImageResource(contact.img)
        txtName.text = contact.name
        txtPhone.text = contact.phone

        return view
    }

}