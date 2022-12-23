package com.example.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datasource.local.entities.MoneyLentWithPerson
import com.example.datasource.local.entities.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
	@Insert
	suspend fun insertPerson(person: PersonEntity)

	@Query("SELECT * FROM PERSON")
	fun getAll(): Flow<List<PersonEntity>>

	@Query("SELECT * from person")
	fun peopleWithOwned(): Flow<List<MoneyLentWithPerson>>
}