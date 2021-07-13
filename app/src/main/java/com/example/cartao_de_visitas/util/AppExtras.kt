package com.example.cartao_de_visitas.util

import android.content.Context
import android.widget.Toast

class AppExtras {
    companion object{

        fun toast(text : String, context: Context){
            Toast.makeText(context, "$text", Toast.LENGTH_LONG).show()
        }
    }

}