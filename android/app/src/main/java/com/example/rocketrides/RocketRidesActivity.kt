package com.example.rocketrides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class RocketRidesActivity : AppCompatActivity(), OnFragmentInteractionListener, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()    // Hide the action bar
        setContentView(R.layout.activity_rocket_rides)

        Log.d("$TAG.activity.rr", "onCreate is called on RocketRidesActivity")

        val fGoogleMap = SupportMapFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fGoogleMap)
            .commit()

        fGoogleMap.getMapAsync(this)
    }

    override fun onFragmentInteraction(message: String?) {
        Log.d("$TAG.activity.rr", "onFragmentInteraction is called $message")
        Toast.makeText(this@RocketRidesActivity, message ?: "Unknown Message", Toast.LENGTH_SHORT)
            .show()
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.let {
            mMap = googleMap

            // Add a marker in Sydney and move the camera
            val sydney = LatLng(-34.0, 151.0)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            Toast.makeText(this@RocketRidesActivity, "Google Map is ready", Toast.LENGTH_SHORT)
                .show()
        } ?: run {
            Toast.makeText(this@RocketRidesActivity, "Google Map is not ready", Toast.LENGTH_SHORT)
                .show()
        }
    }

}
