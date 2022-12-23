package com.example.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datasource.local.entities.MoneyLentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoneyDao {

	@Insert
	suspend fun insertMoneyLent(person: MoneyLentEntity)

	@Query("SELECT * FROM money_lent")
	fun getAll(): Flow<List<MoneyLentEntity>>

}