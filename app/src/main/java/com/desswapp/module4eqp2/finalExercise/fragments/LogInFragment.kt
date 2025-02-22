package com.desswapp.module4eqp2.finalExercise.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.FragmentLogInBinding
import com.desswapp.module4eqp2.finalExercise.FragmentControllerActivity
import com.desswapp.module4eqp2.finalExercise.UserAccountActivity
import com.desswapp.module4eqp2.finalExercise.UserInformation

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnLogIn = binding.btnLogin
        val etUser = binding.etUser
        val etPassword = binding.etPassword
        val tvRegister = binding.tvRegister

        (activity as FragmentControllerActivity).supportActionBar?.title = getString(R.string.btnFinalExercise)

        btnLogIn.setOnClickListener{
            if (verifyData(etUser, etPassword)) {
                val userInfo = UserInformation("", "",etUser.text.toString(),"", "", etPassword.text.toString())
                val intent = Intent(requireContext(), UserAccountActivity::class.java).apply {
                    putExtra("EXTRA_USRINFO", userInfo)
                    putExtra("EXTRA_ISLOGIN", true)
                }
                startActivity(intent)
            }else{
                Toast.makeText(requireContext(), getString(R.string.errGeneralHW), Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SignUpFragment.newInstance())
                .addToBackStack("REGISTER")
                .commit()
        }

    }

    private fun verifyData(user: EditText, password: EditText): Boolean {
        val valide = isUserValid(user) && isNotEmptyData(password)
        return valide
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
    private fun isUserValid(user: EditText): Boolean {
        if(!isNotEmptyData(user)){
            Toast.makeText(requireContext(), getString(R.string.errEmailHW), Toast.LENGTH_SHORT).show()
            return false
        }
        if(user.text.toString().contains("@")){
            return android.util.Patterns.EMAIL_ADDRESS.matcher(user.text.toString()).matches()
        }
        return true
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}