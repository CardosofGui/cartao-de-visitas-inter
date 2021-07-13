package com.example.cartao_de_visitas.ui

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.cartao_de_visitas.databinding.ActivityMainBinding
import com.example.cartao_de_visitas.util.BaseApplication
import com.example.cartao_de_visitas.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as BaseApplication).repository)
    }
    private val adapter by lazy { BusinessAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerBusiness.adapter = adapter
        insertListeners()
    }

    private fun insertListeners() {
        adapter.listenerShare = { view ->
            Image.share(this, view)
        }

        mainViewModel.getAll().observe(this, {
            adapter.submitList(it)
        })

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddBusinessCard::class.java))
        }
    }
}