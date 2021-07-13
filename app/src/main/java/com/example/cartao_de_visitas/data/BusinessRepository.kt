package com.example.cartao_de_visitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessRepository(private val dao : BusinessCardDao) {

    fun insert(businessCard: DataBusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insertBusiness(businessCard)
        }
    }

    fun getAll() = dao.getAll()
}