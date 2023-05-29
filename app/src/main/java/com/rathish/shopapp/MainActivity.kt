package com.rathish.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rathish.shopapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var prefHelper: PrefHelper
    private lateinit var binding: ActivityMainBinding  //defining the binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root)
        //to hide toolbar
        supportActionBar?.hide()
        prefHelper = PrefHelper(this)

        binding.buttonLogin.setOnClickListener {
            if (binding.editUsername.text.isNotEmpty() && binding.editPassword.text.isNotEmpty()) {
                saveSession( binding.editUsername.text.toString(), binding.editPassword.text.toString() )
                showMessage( "logged in successfully" )
                moveIntent()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        if (prefHelper.getBoolean( Constants.PREF_IS_LOGIN )) {
            moveIntent()
        }
    }

    private fun saveSession(username: String, password: String){
        prefHelper.put( Constants.PREF_USERNAME, username )
        prefHelper.put( Constants.PREF_PASSWORD, password )
        prefHelper.put( Constants.PREF_IS_LOGIN, true)
    }

    private fun moveIntent(){
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}