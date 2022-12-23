package com.example.datasource

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.datasource.adapter.CallAdapterFactory
import com.example.datasource.environment.Environment
import com.example.datasource.local.AppDatabase
import com.example.datasource.local.dao.PersonDao
import com.example.datasource.local.repository.MoneyLentRepository
import com.example.datasource.local.repository.PersonRepository
import com.example.datasource.services.SampleCepService
import com.google.gson.Gson
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataSourceModule = module {
	single { defaultRetrofit() }

	single { roomDatabase(androidContext()) }
	single {
		val database = get<AppDatabase>()
		database.personDao()
	}
	single {
		val database = get<AppDatabase>()
		database.moneyDao()
	}

	factory<SampleCepService> { createService(get()) }
	factory { PersonRepository(get()) }
	factory { MoneyLentRepository(get()) }
}

fun defaultRetrofit(): Retrofit {
	val url = Environment.Env.url
	val client = createClient {
		writeTimeout = 30L
		readTimeout = 30L
		interceptors = defaultInterceptors(HttpLoggingInterceptor.Level.BODY)
	}

	return Retrofit.Builder().apply {
		addConverterFactory(GsonConverterFactory.create(Gson()))
		addCallAdapterFactory(CallAdapterFactory())
		client(client)
		baseUrl(url)
	}.build()
}

inline fun <reified T> createService(retrofit: Retrofit): T {
	return retrofit.create(T::class.java)
}

fun roomDatabase(context: Context) =
	Room.databaseBuilder(
		context,
		AppDatabase::class.java,
		"app_database"
	).build()