package com.angelblanco.database_angelblanco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.angelblanco.database_angelblanco.databinding.ActivityMainBinding
import com.angelblanco.database_angelblanco.db.User
import com.angelblanco.database_angelblanco.db.UserDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  db: UserDatabase
    private val adapter = UserAdapter({
        Toast.makeText(this, "User: $it", Toast.LENGTH_SHORT).show()
        }, {
            db.userDao().delete(it)
            refreshUsers()
    })

    private fun refreshUsers() {
        val users = db.userDao().findAllUser()
        adapter.submitList(users)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter

        binding.btnAddUser.setOnClickListener{
            addUser()
        }


        db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "database-agenda")
            .allowMainThreadQueries()
            .build()


        refreshUsers()
    }

    private fun addUser() {
        val username: String = binding.etName.text.toString()
        val lastname: String = binding.etLastName.text.toString()
        val numberPhone: String = binding.etNumber.text.toString()
        val birthday: String = binding.etBirthday.text.toString()


        val newUser = User(username,lastname,numberPhone, birthday)

        db.userDao().save(newUser)

        binding.etName.setText("")
        binding.etLastName.setText("")
        binding.etNumber.setText("")
        binding.etBirthday.setText("")


        refreshUsers()
    }


}