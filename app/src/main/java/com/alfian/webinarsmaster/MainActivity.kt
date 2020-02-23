package com.alfian.webinarsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var btnStore: Button? = null
    private var btnGetAll: Button? = null
    private var edtName: EditText? = null
    private var edtHobby: EditText? = null
    private var databaseHelper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = DatabaseHelper(this)

        btnStore = findViewById(R.id.btn_save) as Button
        btnGetAll = findViewById(R.id.btn_get) as Button
        edtName = findViewById(R.id.edt_name) as EditText
        edtHobby = findViewById(R.id.edt_hobby) as EditText

        btnStore!!.setOnClickListener {
            databaseHelper!!.addUserDetail(edtName!!.text.toString(), edtHobby!!.text.toString())
            edtName!!.setText("")
            edtHobby!!.setText("")
            Toast.makeText(this@MainActivity, "Stored Successfully!", Toast.LENGTH_SHORT).show()
        }
        btnGetAll!!.setOnClickListener {
            val intent = Intent(this@MainActivity, GetAllUsersActivity::class.java)
            startActivity(intent)
        }
    }
}