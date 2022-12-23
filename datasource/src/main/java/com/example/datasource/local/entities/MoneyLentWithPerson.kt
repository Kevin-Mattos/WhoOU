package com.example.datasource.local.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.math.BigDecimal

data class MoneyLentWithPerson(
	@Embedded val personEntity: PersonEntity,

	@Relation(
		parentColumn = "id",
		entityColumn = "personId"
	) val owned: List<MoneyLentEntity>
)