package com.example.rocketrides

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map_operation.*


// TODO:
// Google Map Fragment contains maps/mark

class MapOperationFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_operation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("$TAG.fragment.map", "onViewCreated Calling getMapAsync")
        val map = main_map_fragment as MapFragment
        if (main_map_fragment is MapFragment) {
//            main_map_fragment.getMapAsync(this@MapOperationFragment)
        }
//        map.getMapAsync(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("$TAG.fragment.map", "MapOperationFragment onAttach is called")

        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            Log.e("$TAG.fragment.map", "$context must implement OnFragmentInteractionListener to use MapOperationFragment")
        }
    }


    companion object {
        fun newInstance(lat: Double, lng: Double, title: String ) : MapOperationFragment {
            val args = Bundle().apply {
                putSerializable("lat", lat)
                putSerializable("lng", lng)
                putSerializable("title", title)
            }
            return MapOperationFragment().apply {
                arguments = args
            }
        }
    }
}
