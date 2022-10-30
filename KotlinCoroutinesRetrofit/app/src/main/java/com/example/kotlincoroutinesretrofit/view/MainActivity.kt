package com.example.kotlincoroutinesretrofit.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincoroutinesretrofit.R
import com.example.kotlincoroutinesretrofit.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it)
            }
        })

        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if (it == null) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    list_error.visibility = View.GONE
                    countriesList.visibility = View.GONE
                }
            }
        })
    }
}