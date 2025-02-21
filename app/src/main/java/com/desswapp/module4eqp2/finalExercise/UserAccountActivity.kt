package com.desswapp.module4eqp2.finalExercise

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.ActivityUserAccountBinding

class UserAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserAccountBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.account)

        val lyLogin = binding.lyLogin
        val lySignUp = binding.lySignUp
        val btnExit = binding.btnExit


        val origin = intent.getBooleanExtra("EXTRA_ISLOGIN", true)
        val userInfo = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_USRINFO", UserInformation::class.java)
        }else{
            intent.getSerializableExtra("EXTRA_USRINFO") as UserInformation
        }

        if(userInfo == null || userInfo.email.isEmpty()){
            Toast.makeText(this, getString(R.string.ErrorInfo), Toast.LENGTH_SHORT).show()
        }else if(!origin){
            lySignUp.visibility = View.VISIBLE
            val tvFullNameSignUp = binding.tvFullNameSignUp
            val tvEmailSignUp = binding.tvEmailSignUp
            val tvGenderSignUp = binding.tvGenderSignUp
            val tvPasswordSignUp = binding.tvPasswordSignUp

            tvFullNameSignUp.text = userInfo.name + " " + userInfo.lastName
            tvEmailSignUp.text = userInfo.email
            tvGenderSignUp.text = userInfo.gender
            tvPasswordSignUp.text = userInfo.password
        }else{
            lyLogin.visibility = View.VISIBLE
            val tvEmailLogin = binding.tvEmailLogin
            val tvPasswordLogin = binding.tvPasswordLogin

            tvEmailLogin.text = userInfo.email
            tvPasswordLogin.text = userInfo.password
        }

        btnExit.setOnClickListener{
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}