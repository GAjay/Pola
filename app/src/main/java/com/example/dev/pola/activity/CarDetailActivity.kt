package com.example.dev.pola.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dev.pola.R
import com.example.dev.pola.model.Placemark
import com.example.dev.pola.utils.AppConstants
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng


class CarDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)
        val placeMarksList: ArrayList<Placemark> =
            intent.getParcelableArrayListExtra<Placemark>(AppConstants.PLACEMARKER_LIST)
        val clickPosition = intent.getIntExtra(AppConstants.currenPosition,0)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync { googleMap: GoogleMap? ->
          for (placemarker in placeMarksList) {
                val latLng = LatLng(
                    placemarker.coordinates!!.get(1),
                    placemarker.coordinates.get(0)
                )
                googleMap!!.addMarker(
                    MarkerOptions().position(latLng)
                        .title(placemarker.name)
                )

            }
            val latLng = LatLng(
                placeMarksList.get(clickPosition).coordinates!!.get(1),
                placeMarksList.get(clickPosition).coordinates!!.get(0)
            )
            googleMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 100F));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(100F), 2000, null);
            googleMap.getUiSettings().setZoomControlsEnabled(true);

        }


        println("placemarker list is ${placeMarksList.get(0).coordinates!!.get(0)}")
    }
}
