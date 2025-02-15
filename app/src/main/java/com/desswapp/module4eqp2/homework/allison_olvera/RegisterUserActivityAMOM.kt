package com.desswapp.module4eqp2.homework.allison_olvera

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.oliver_atondo.tarea.ResultActivityOliver

class RegisterUserActivityAMOM : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var tvNameConfirm : TextView
    private lateinit var etLastName : EditText
    private lateinit var tvLastNameConfirm : TextView
    private lateinit var etEmail : EditText
    private lateinit var tvEmailConfirm : TextView
    private lateinit var rgGender : RadioGroup
    private lateinit var rbMan : RadioButton
    private lateinit var rbWoman : RadioButton
    private lateinit var tvGenderConfirm : TextView
    private lateinit var etPassword : EditText
    private lateinit var tvPasswordConfirm : TextView
    private lateinit var btnRegister : Button
    private lateinit var btnExit : Button
    private lateinit var cbShowPassword : CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_user_amom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        setupFocusValidation(etName, tvNameConfirm, "Ingresa tu nombre, por favor.")
        setupFocusValidation(etLastName, tvLastNameConfirm, "Ingresa tu apellido, por favor.")
        setupFocusValidation(etEmail, tvEmailConfirm, "Ingresa tu email, por favor.")
        setupFocusValidation(etPassword, tvPasswordConfirm, "Crea una contraseña, por favor.")

        //RADIOGROUP
        rgGender.setOnCheckedChangeListener { group, checkedId ->
            val gender = getRgLabel(checkedId, false)
            Toast.makeText(this, "$gender", Toast.LENGTH_SHORT).show()
        }

        cbShowPassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etPassword.setSelection(etPassword.text.length)
        }

        btnRegister.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            val name = etName.text.toString().trim()
            val lastname = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Obtener el género seleccionado en texto
            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                ""  // Se deja vacío para que active la validación
            }

            // Validar si algún campo está vacío y mostrar un Toast
            if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty() || gender.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, UserDetailsActivityAMOM::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                    putExtra("EXTRA_LASTNAME", lastname)
                    putExtra("EXTRA_EMAIL", email)
                    putExtra("EXTRA_GENDER", gender)
                    putExtra("EXTRA_PASSWORD", password) // Ahora el password se envía correctamente como texto
                }
                startActivity(intent)
            }
        }

        btnExit.setOnClickListener {    //Sale de la app/Regresa al menú inicial
            finish()
        }

    }


    private fun initViews() {
        etName = findViewById(R.id.etName)
        tvNameConfirm = findViewById(R.id.tvNameConfirm)
        etLastName = findViewById(R.id.etLastName)
        tvLastNameConfirm = findViewById(R.id.tvLastNameConfirm)
        etEmail = findViewById(R.id.etEmail)
        tvEmailConfirm = findViewById(R.id.tvEmailConfirm)
        rgGender = findViewById(R.id.rgGender)
        rbMan = findViewById(R.id.rbMan)
        rbWoman = findViewById(R.id.rbWoman)
        tvGenderConfirm = findViewById(R.id.tvGenderConfirm)
        etPassword = findViewById(R.id.etPassword)
        tvPasswordConfirm = findViewById(R.id.tvPasswordConfirm)
        btnRegister = findViewById(R.id.btnRegister)
        btnExit = findViewById(R.id.btnExit)
        cbShowPassword = findViewById(R.id.cbShowPassword)
    }


    private fun getRgLabel(checkedId: Int, isFromButton: Boolean): Any {
        return when (checkedId){
            R.id.rbWoman ->{
                if (isFromButton) "M" else "Mujer"
            }
            R.id.rbMan ->{
                if (isFromButton) "H" else "Hombre"
            }
            else -> "No seleccionado"
        }
    }

    fun setupFocusValidation(editText: EditText, textView: TextView, errorMessage: String) {
        editText.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, Confirm: Boolean) {
                if (!Confirm) {
                    val inputText = editText.text.toString().trim()
                    textView.text = if (inputText.isEmpty()) errorMessage else ""
                }
            }
        }
    }

}