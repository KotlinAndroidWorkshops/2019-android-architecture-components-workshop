package fr.ekito.myweatherapp.di

import fr.ekito.myweatherapp.domain.repository.DailyForecastRepository
import fr.ekito.myweatherapp.domain.repository.DailyForecastRepositoryImpl
import fr.ekito.myweatherapp.util.rx.ApplicationSchedulerProvider
import fr.ekito.myweatherapp.util.rx.SchedulerProvider
import fr.ekito.myweatherapp.view.detail.DetailViewModel
import fr.ekito.myweatherapp.view.splash.SplashViewModel
import fr.ekito.myweatherapp.view.weather.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * App Components
 */
val weatherAppModule = module {
    // ViewModel for Search View
    viewModel { SplashViewModel(get(), get()) }

    // ViewModel for Weather view
    viewModel { WeatherViewModel(get(),get()) }

    // ViewModel for Detail View
    viewModel { DetailViewModel(get(), get()) }

    // Weather Data Repository
    single<DailyForecastRepository> { DailyForecastRepositoryImpl(get()) }

    // Rx Schedulers
    single<SchedulerProvider> { ApplicationSchedulerProvider() }
}

// Gather all app modules
val onlineWeatherApp = listOf(weatherAppModule, remoteDataSourceModule)
val offlineWeatherApp = listOf(weatherAppModule, localAndroidDataSourceModule)