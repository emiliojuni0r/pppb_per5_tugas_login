package com.example.per5_tugas_login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.per5_tugas_login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_USERNAME ="extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRegister.setOnClickListener{
                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                intentToSecondActivity.putExtra(EXTRA_USERNAME, editUsername.text.toString())
                intentToSecondActivity.putExtra(EXTRA_EMAIL, editEmail.text.toString())
                intentToSecondActivity.putExtra(EXTRA_PHONE, editPhone.text.toString())
                intentToSecondActivity.putExtra(EXTRA_PASSWORD, editPassword.text.toString())
                startActivity(intentToSecondActivity)
            }
        }
    }
}