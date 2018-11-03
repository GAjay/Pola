package com.example.dev.pola.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.dev.pola.R
import com.example.dev.pola.adapter.PlaceMArkerAdapter
import com.example.dev.pola.viewmodel.PlacemarkListViewModel
import kotlinx.android.synthetic.main.activity_car_list.*


class CarListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)

        val placeMarkerAdapter = PlaceMArkerAdapter()
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewPlaceMarker.setLayoutManager(mLayoutManager);
        recyclerViewPlaceMarker.setItemAnimator(DefaultItemAnimator());
        recyclerViewPlaceMarker.setAdapter(placeMarkerAdapter)

        //initialize viewModel
        val placemarkListViewModel = ViewModelProviders.of(
            this@CarListActivity
        )
            .get(PlacemarkListViewModel::class.java)

        placemarkListViewModel.fetchPlaceMarkList()

        placemarkListViewModel.placemarkList.observe(this@CarListActivity,
            Observer { placeMarkLIst->placeMarkerAdapter.setPlaceMarksList(placeMarkLIst!!)
        })

        placemarkListViewModel.getProgressBar().observe(this, Observer { value ->
            progressBar.visibility = value!!

        })
    }
}
