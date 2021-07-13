package com.example.cartao_de_visitas.util

import android.app.Application
import com.example.cartao_de_visitas.data.AppDatabase
import com.example.cartao_de_visitas.data.BusinessRepository

class BaseApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessRepository(database.businessDao()) }

}