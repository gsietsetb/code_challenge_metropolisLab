package com.metropolislab.gsierra.rovercontroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    val POSSIBLE_MOVEMENTS = "RLM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val metropolisLab = LatLng(41.3811107,2.1855025)
        mMap.addMarker(MarkerOptions()
                .position(metropolisLab)
                .title("Robers")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rovers_s))
        )
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(metropolisLab, 19.0f))
    }

    fun nextDir(): Char{
        return when(Random().nextInt(4)) {
            1 -> 'N'
            2 -> 'W'
            3 -> 'E'
            4 -> 'S'
            else -> 'N'
        }
    }

    fun nextMov(): Char{
        return when(Random().nextInt(3)) {
            1 -> 'R'
            2 -> 'L'
            3 -> 'M'
            else -> 'M'
        }
    }

    private fun generateFakeData(): RoversJSONInput{
        val rand = Random()
        var moves = ""
        for (i in 0..5){
            moves += nextMov()
        }
        return RoversJSONInput(rand.nextInt(10),
                rand.nextInt(),
                rand.nextInt(),
                rand.nextInt(),
                nextDir(),
                moves)
    }

    fun moveinDir(dir: Char, current: RoverPosition): RoverPosition {
        when (dir) {
            'N' -> current.x ++
            2 -> 'W'
            3 -> 'E'
            4 -> 'S'
            else -> 'N'
        }
    }

    fun moveToNewPos(): String{
        val newMove = generateFakeData()
        var currentPosition: RoverPosition = newMove.roverPosition
        for(i in newMove.()) {
            when (i) {
                'M' -> {
                    when (newMove.) {
                        'N' -> current.x ++
                        2 -> 'W'
                        3 -> 'E'
                        4 -> 'S'
                        else -> 'N'
                    }

                2 -> 'L'
                3 -> 'M'
                else -> 'M'
            }
        }
        }

        return "SSS"
    }
}
