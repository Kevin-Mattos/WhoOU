package com.example.datasource.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(
	tableName = "money_lent",
	foreignKeys = [ForeignKey(
		entity = PersonEntity::class,
		parentColumns = ["id"],
		childColumns = ["personId"],
		onDelete = CASCADE
	)]
)
data class MoneyLentEntity(
	@PrimaryKey(autoGenerate = true) val id: Long = 0,
	val value: Double,
	val personId: Long
)