package com.example.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datasource.local.entities.MoneyLentEntity
import com.example.datasource.local.entities.MoneyLentWithPerson
import com.example.datasource.local.entities.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoneyDao {

	@Insert
	suspend fun insertMoneyLent(person: MoneyLentEntity)

	@Query("SELECT * FROM money_lent")
	fun getAll(): Flow<List<MoneyLentEntity>>

	@Query("SELECT * FROM Person " +
			"JOIN money_lent ON person.id = money_lent.personId"
	)
	fun getAllWithUser(): Flow<Map<PersonEntity, List<MoneyLentEntity>>>
}