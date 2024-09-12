package com.example.per5_tugas_login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.per5_tugas_login.MainActivity.Companion.EXTRA_PASSWORD
import com.example.per5_tugas_login.MainActivity.Companion.EXTRA_PHONE
import com.example.per5_tugas_login.MainActivity.Companion.EXTRA_USERNAME
import com.example.per5_tugas_login.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
//    private val launcher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//        { result ->
//            // Memeriksa result code
//            if (result.resultCode == Activity.RESULT_OK) {
//                // Mengambil data Intent
//                val data = result.data
//                // Mendapatkan alamat dari data Intent
//                val username = data?.getStringExtra(EXTRA_USERNAME)
//                val email = data?.getStringExtra(EXTRA_PASSWORD)
//                val phone = data?.getStringExtra(EXTRA_PHONE)
//                // Menetapkan teks di TextView
////                binding.txtName.text = "$name beralamat di $address"
//            }
//        }

    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameReg = intent.getStringExtra(EXTRA_USERNAME)
        val passwordReg = intent.getStringExtra(EXTRA_PASSWORD)
        val emailReg = intent.getStringExtra(EXTRA_EMAIL)
        val phoneReg = intent.getStringExtra((EXTRA_PHONE))

        with(binding) {
            btnLogin.setOnClickListener{
                val usernameLogin = editUsernameLogin.text.toString()
                val passwordLogin = editPasswordLogin.text.toString()

                if (usernameReg == usernameLogin && passwordReg == passwordLogin) {
                    val intentToThirdActivity = Intent(this@SecondActivity,ThirdActivity::class.java)
                    intentToThirdActivity.putExtra(EXTRA_USERNAME,usernameReg.toString())
                    intentToThirdActivity.putExtra(EXTRA_EMAIL,emailReg.toString())
                    intentToThirdActivity.putExtra(EXTRA_PHONE,phoneReg.toString())

                    startActivity((intentToThirdActivity))
                } else {
                    txtWarning.text = "wrong password or username !"
                }
            }
        }
    }
}