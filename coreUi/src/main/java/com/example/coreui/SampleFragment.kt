package com.example.coreui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.coreui.base.ComposeFragment
import com.example.coreui.base.viewmodel.BaseViewModel
import com.example.datasource.local.entities.MoneyLentEntity
import com.example.datasource.local.repository.MoneyLentRepository
import org.koin.androidx.viewmodel.ext.android.viewModel

class SampleFragment : ComposeFragment() {
	private val viewModel: SampleStateViewModel by viewModel()

	@Composable
	override fun ToContent() {
		val state by viewModel.items.collectAsState(initial = emptyList())

		LazyColumn {
			items(state.size) {
				val person = state[it]
				Row {
					Text(modifier = Modifier.clickable {
						viewModel.insert()

					}, text = person.toString())
				}
			}
		}
	}
}

class SampleStateViewModel(private val service: MoneyLentRepository) :
	BaseViewModel() {

	val items = service.getAll()

	fun insert() {
		launchComputing {
			service.insertMoneyLent(MoneyLentEntity(value = 33.31, personId = 3))
		}
	}
}