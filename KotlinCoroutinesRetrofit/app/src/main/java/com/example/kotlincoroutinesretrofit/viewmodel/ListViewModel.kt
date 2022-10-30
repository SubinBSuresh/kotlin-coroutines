package com.example.kotlincoroutinesretrofit.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.kotlincoroutinesretrofit.model.CountriesService
import com.example.kotlincoroutinesretrofit.model.Country
import kotlinx.coroutines.*

class ListViewModel: ViewModel() {

    val countriesService = CountriesService.getCountriesService()
    var job: Job?=null
    val exceptionHandler = CoroutineExceptionHandler{
        coroutineContext, throwable ->  onError("Exception: ${throwable.localizedMessage}")
    }

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true

//        val dummyData = generateDummyCountries()

//        countries.value = dummyData
        countryLoadError.value = ""
        loading.value = false
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = countriesService.getCountries()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    countries.value = response.body()
                    countryLoadError.value = null
                    loading.value = false
                } else{
                    onError("Error ${response.message()}")
                }
            }
        }
    }

/*    private fun generateDummyCountries(): List<Country> {
        val countries = arrayListOf<Country>()
        countries.add(Country("dummyCountry1",  "dummyCapital1",""))
        countries.add(Country("dummyCountry2",  "dummyCapital2",""))
        countries.add(Country("dummyCountry3",  "dummyCapital3",""))
        countries.add(Country("dummyCountry4",  "dummyCapital4",""))
        countries.add(Country("dummyCountry5",  "dummyCapital5",""))
        return countries
    }*/

    private fun onError(message: String) {
        countryLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}