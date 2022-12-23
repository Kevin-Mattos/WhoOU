package com.example.datasource.local.repository

import com.example.datasource.local.dao.PersonDao
import com.example.datasource.local.entities.PersonEntity

class PersonRepository(private val personDao: PersonDao) {

	fun getAll() = personDao.getAll()

	suspend fun insertPerson(personEntity: PersonEntity) = personDao.insertPerson(personEntity)

	fun getAllWithUser() = personDao.peopleWithOwned()
}