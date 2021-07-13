package com.example.cartao_de_visitas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinessCardDao {

    @Query("SELECT * FROM DataBusinessCard")
    fun getAll() : LiveData<List<DataBusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBusiness(businessCard: DataBusinessCard)
}