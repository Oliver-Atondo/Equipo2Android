package com.desswapp.module4eqp2.homework.fernando_hernandez

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<EditText>(R.id.etName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etRePassword = findViewById<EditText>(R.id.etRePassword)
        val rbtngGenero = findViewById<RadioGroup>(R.id.rbtngGenero)
        var genero : String = ""


        btnSignUp.setOnClickListener{
            if(verifyData(etName, etLastName, etEmail, etPassword, etRePassword,genero)){
                val intent = Intent(this, AccountInfoActivity::class.java).apply {
                    putExtra("name", etName.text.toString())
                    putExtra("lastName", etLastName.text.toString())
                    putExtra("email", etEmail.text.toString())
                    putExtra("gender", genero)
                    putExtra("password", etPassword.text.toString())
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, getString(R.string.errGeneralHW), Toast.LENGTH_SHORT).show()
            }
        }

        rbtngGenero.setOnCheckedChangeListener { group, checkedId ->
            genero = getGender(checkedId, true)
        }

    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }

    private fun verifyData(name: EditText, lastName: EditText, email: EditText, password: EditText, rePassword: EditText, genero: String): Boolean {
        val valide = isNotEmptyData(name) && isNotEmptyData(lastName) && isEmailValid(email)
                && verifyGender(genero) && verifyPassword(password, rePassword)
        return valide
    }

    private fun isEmailValid(email: EditText): Boolean {
        if(!isNotEmptyData(email)){
            Toast.makeText(this, getString(R.string.errEmailHW), Toast.LENGTH_SHORT).show()
            return false
        }
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
    }

    private fun isNotEmptyData(campo : EditText): Boolean {
        if(campo.text.toString().isEmpty() || campo.text.toString().isBlank()){
            campo.error = getString(R.string.errEmptyHW)
            campo.requestFocus()
            Toast.makeText(this, getString(R.string.errEmptyHW), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun verifyGender(genero: String): Boolean {
        if(genero.isEmpty() || genero == "-1"){
            Toast.makeText(this, getString(R.string.errGenderHW), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun verifyPassword(password: EditText, rePassword: EditText): Boolean {
        var valide = false
        val passwordPattern = "^(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
        if(password.text.toString().length >= 8){
            if(isNotEmptyData(password)){
                if(isNotEmptyData(rePassword)){
                    if(!passwordPattern.matches(password.text.toString())){
                        Toast.makeText(this,getString(R.string.errPasswordSecurityHW), Toast.LENGTH_SHORT).show()
                    }
                    if(password.text.toString().equals(rePassword.text.toString())){
                        valide = true
                    }else{
                        rePassword.error = getString(R.string.errPasswordDifferentHW)
                    }
                }else{
                    rePassword.error = getString(R.string.errPasswordHW)
                }
            }else{
                password.error =getString( R.string.errPasswordHW)
            }
        }else{
            password.error =getString( R.string.errPasswordLengthHW)
        }
        return valide
    }

    private fun getGender(checkedId: Int, isFromButton: Boolean): String {
        return when (checkedId){
            R.id.rbtnMen -> getString(R.string.genderHHW)
            R.id.radioButton2 -> getString(R.string.genderWHW)
            R.id.radioButton3 -> getString(R.string.genderOHW)
            else -> "-1"
        }
    }

}