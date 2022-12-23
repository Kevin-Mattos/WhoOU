package com.example.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class PersonEntity(
	@PrimaryKey(autoGenerate = true) val id: Long = 0, val name: String
)