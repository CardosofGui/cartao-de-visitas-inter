package com.example.cartao_de_visitas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartao_de_visitas.data.AppDatabase
import com.example.cartao_de_visitas.data.BusinessCardDao
import com.example.cartao_de_visitas.data.BusinessRepository
import com.example.cartao_de_visitas.data.DataBusinessCard
import java.lang.IllegalArgumentException

class MainViewModel(private val repository : BusinessRepository) : ViewModel() {

    fun insertCard(businessCard: DataBusinessCard){
        repository.insert(businessCard)
    }

    fun getAll() = repository.getAll()
}

class MainViewModelFactory(private val repository: BusinessRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}