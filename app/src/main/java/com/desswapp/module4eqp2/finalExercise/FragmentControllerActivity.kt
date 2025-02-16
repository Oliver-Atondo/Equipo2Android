package com.desswapp.module4eqp2.finalExercise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.ActivityFragmentControllerBinding
import com.desswapp.module4eqp2.finalExercise.fragments.LogInFragment

class FragmentControllerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentControllerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentControllerBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LogInFragment.newInstance())
            .commit()
    }
}