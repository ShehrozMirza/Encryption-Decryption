package com.example.encryption_decryption

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encryption_decryption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEncrypt.setOnClickListener {
            if (binding.edEncryptionText.text.toString().isNotEmpty()) {
                performEncryption(binding.edEncryptionText.text.toString())
            } else {
                Toast.makeText(this, "Please enter value for encryption", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnDecrypt.setOnClickListener {
            if (binding.txtEncryption.text.toString().isNotEmpty()) {
                performDecryption(binding.txtEncryption.text.toString())
            } else {
                Toast.makeText(this, "Encrypted text is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performEncryption(sourceStr: String) {
        try {
            val encrypted = AESUtils.encrypt(sourceStr)
            binding.txtEncryption.text = encrypted
            Log.d("TEST", "encrypted:$encrypted")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun performDecryption(sourceStr: String) {
        val decrypted: String
        try {
            decrypted = AESUtils.decrypt(sourceStr)
            Log.d("TEST", "decrypted:$decrypted")
            binding.txtDecryption.text = decrypted
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}