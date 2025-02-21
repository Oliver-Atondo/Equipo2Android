package com.desswapp.module4eqp2.finalExercise.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.FragmentSignUpBinding
import com.desswapp.module4eqp2.finalExercise.FragmentControllerActivity
import com.desswapp.module4eqp2.finalExercise.UserAccountActivity
import com.desswapp.module4eqp2.finalExercise.UserInformation

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        (activity as FragmentControllerActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as FragmentControllerActivity).supportActionBar?.title = getString(R.string.createAccount)

        val btnSignUp = binding.btnSignUp
        val etName = binding.etName
        val etLastName = binding.etLastName
        val etEmail = binding.etEmail
        val etPassword = binding.etPassword
        val etRePassword = binding.etRePassword
        val rbtngGenero = binding.rbtngGenero
        var genero : String = ""


        btnSignUp.setOnClickListener{
            if(verifyData(etName, etLastName, etEmail, etPassword, etRePassword,genero)){
                val userInfo = UserInformation(etName.text.toString(), etLastName.text.toString(),
                    etEmail.text.toString(), genero, etPassword.text.toString())
                val intent = Intent(requireContext(), UserAccountActivity::class.java).apply {
                    putExtra("EXTRA_USRINFO", userInfo)
                    putExtra("EXTRA_ISLOGIN", false)
                }
                startActivity(intent)
            }else{
                Toast.makeText(requireContext(), getString(R.string.errGeneralHW), Toast.LENGTH_SHORT).show()
            }
        }
        rbtngGenero.setOnCheckedChangeListener { group, checkedId ->
            genero = getGender(checkedId, true)
        }
    }

    override fun onPause() {
        super.onPause()
        (activity as FragmentControllerActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        parentFragmentManager.popBackStack()
    }

    override fun onOptionsItemSelected (item: MenuItem): Boolean{
        when(item.itemId){
            android.R.id.home -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }

    private fun verifyData(name: EditText, lastName: EditText, email: EditText, password: EditText, rePassword: EditText, genero: String): Boolean {
        val valide = isNotEmptyData(name) && isNotEmptyData(lastName) && isEmailValid(email)
                && verifyGender(genero) && verifyPassword(password, rePassword)
        return valide
    }

    private fun isEmailValid(email: EditText): Boolean {
        if(!isNotEmptyData(email) ||
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            Toast.makeText(requireContext(), getString(R.string.errEmailHW), Toast.LENGTH_SHORT).show()
            return false
        }
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
    }

    private fun isNotEmptyData(campo : EditText): Boolean {
        if(campo.text.toString().isEmpty() || campo.text.toString().isBlank()){
            campo.error = getString(R.string.errEmptyHW)
            campo.requestFocus()
            Toast.makeText(requireContext(), getString(R.string.errEmptyHW), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun verifyGender(genero: String): Boolean {
        if(genero.isEmpty() || genero == "-1"){
            Toast.makeText(requireContext(), getString(R.string.errGenderHW), Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(requireContext(),getString(R.string.errPasswordSecurityHW), Toast.LENGTH_SHORT).show()
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