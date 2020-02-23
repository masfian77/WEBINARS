package com.alfian.webinarsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateDeleteActivity : AppCompatActivity() {

    private var userModel: UserModel? = null
    private var edtName: EditText? = null
    private var edtHobby: EditText? = null
    private var btnupdate: Button? = null
    private var btndelete: Button? = null
    private var databaseHelper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        val intent = intent
        userModel = intent.getSerializableExtra("user") as UserModel

        databaseHelper = DatabaseHelper(this)

        edtName = findViewById(R.id.edt_name) as EditText
        edtHobby = findViewById(R.id.edt_hobby) as EditText
        btndelete = findViewById(R.id.btndelete) as Button
        btnupdate = findViewById(R.id.btnupdate) as Button

        edtName!!.setText(userModel!!.getNames())
        edtHobby!!.setText(userModel!!.getHobbys())

        btnupdate!!.setOnClickListener {
            databaseHelper!!.updateUser(userModel!!.getIds(), edtName!!.text.toString(), edtHobby!!.text.toString())
            Toast.makeText(this@UpdateDeleteActivity, "Updated Successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UpdateDeleteActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        btndelete!!.setOnClickListener {
            databaseHelper!!.deleteUSer(userModel!!.getIds())
            Toast.makeText(this@UpdateDeleteActivity, "Deleted Successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UpdateDeleteActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}