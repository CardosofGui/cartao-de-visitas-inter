package com.example.cartao_de_visitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.cartao_de_visitas.R
import com.example.cartao_de_visitas.data.DataBusinessCard
import com.example.cartao_de_visitas.databinding.ActivityAddBusinessCardBinding
import com.example.cartao_de_visitas.util.AppExtras.Companion.toast
import com.example.cartao_de_visitas.util.BaseApplication

class AddBusinessCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as BaseApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
            toast("Fechando...", this)
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = DataBusinessCard(
                nome = binding.edtNome.text.toString(),
                empresa = binding.edtEmpresa.text.toString(),
                telefone = binding.edtTelefone.text.toString(),
                email = binding.edtEmail.text.toString(),
                fundoPersonalizado = binding.edtCor.text.toString()
            )

            mainViewModel.insertCard(businessCard)
            finish()
        }
    }
}