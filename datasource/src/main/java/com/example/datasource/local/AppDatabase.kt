package com.example.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datasource.local.dao.MoneyDao
import com.example.datasource.local.dao.PersonDao
import com.example.datasource.local.entities.MoneyLentEntity
import com.example.datasource.local.entities.PersonEntity

@Database(entities = [PersonEntity::class, MoneyLentEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
	abstract fun personDao(): PersonDao
	abstract fun moneyDao(): MoneyDao
}