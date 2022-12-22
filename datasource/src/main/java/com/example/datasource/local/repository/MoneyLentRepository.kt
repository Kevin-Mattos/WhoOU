package com.example.datasource.local.repository

import com.example.datasource.local.dao.MoneyDao
import com.example.datasource.local.entities.MoneyLentEntity

class MoneyLentRepository(private val moneyDao: MoneyDao) {

	fun getAll() = moneyDao.getAll()

	fun getAllWithUser() = moneyDao.getAllWithUser()

	suspend fun insertMoneyLent(moneyLent: MoneyLentEntity) = moneyDao.insertMoneyLent(moneyLent)
}