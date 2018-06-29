package com.fadila.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     *  kode program di bawah memungkinkan beberapa icon lokasi yang terdapat pada list tempat sesuai kategori
     *  aplikasi ini menyarankan diinstal nya apk google maps terlebih dahulu sebelum masuk ke apikasi lebih lanjut
     *  kode program di bawah menginisialisasi beberapa lokasi tempat sesuait longitude dan latitude tempat yang ingin dituju
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng balam = new LatLng(-5.4170716, 105.211115);
        LatLng waykambas = new LatLng(-4.9275758, 105.7769283);
        LatLng mbk = new LatLng(-5.3821866, 105.2595404);
        LatLng transmart = new LatLng(-5.3828388, 105.2832154);
        LatLng terminal = new LatLng(-5.3672566, 105.2358504);
        LatLng bukitrandu = new LatLng(-5.4110554, 105.2614246);
        LatLng pizzahut = new LatLng(-5.4191646, 105.2558238);
        LatLng museumlampung = new LatLng( -5.3900291, 105.2588905);
        LatLng bumbudesa = new LatLng(-5.3828946, 105.2577144);
        LatLng nasiuduktoha = new LatLng(-5.4118392, 105.2541649);
        LatLng aromaseafood = new LatLng(-5.4059696, 105.273681);
        LatLng candrakarang = new LatLng(-5.4111494, 105.2607735);
        LatLng stasiun = new LatLng(-5.4088815, 105.2577017);
        LatLng bandara = new LatLng(-5.2427785, 105.1741558);
        LatLng baksosonny8 = new LatLng(-5.3786417, 105.2497191);

        mMap.addMarker(new MarkerOptions().position(waykambas).title("Way Kambas").snippet("Taman Gajah"));
        mMap.addMarker(new MarkerOptions().position(mbk).title("Mall Bumi Kedaton").snippet("Mall Bumi Kedaton"));
        mMap.addMarker(new MarkerOptions().position(transmart).title("Transmart Lampung").snippet("Mall dan Wahana Trans Studio Mini"));
        mMap.addMarker(new MarkerOptions().position(terminal).title("Terminal Rajabasah").snippet("Terminal Induk Rajabasah"));
        mMap.addMarker(new MarkerOptions().position(bukitrandu).title("Bukit Randu").snippet("Hotel dan Resto Bukit Randu"));
        mMap.addMarker(new MarkerOptions().position(pizzahut).title("Pizza Hut").snippet("Pizza Hut Raden Intan"));
        mMap.addMarker(new MarkerOptions().position(museumlampung).title("Museum Lampung").snippet("Museum Lampung"));
        mMap.addMarker(new MarkerOptions().position(bumbudesa).title("Bumbu Desa").snippet("Bumbu Desa Resto"));
        mMap.addMarker(new MarkerOptions().position(nasiuduktoha).title("Nasi Uduk Toha").snippet("Bumbu Desa Resto"));
        mMap.addMarker(new MarkerOptions().position(aromaseafood).title("Aroma Seafood Resto").snippet("Aroma Seafood Market and Resto"));
        mMap.addMarker(new MarkerOptions().position(candrakarang).title("Candra Dept. Store").snippet("Candra Dept. Store"));
        mMap.addMarker(new MarkerOptions().position(stasiun).title("Stasiun Kereta").snippet("Stasiun Kereta"));
        mMap.addMarker(new MarkerOptions().position(bandara).title("Bandara Raden Intan II").snippet("Bandara Raden Intan II"));
        mMap.addMarker(new MarkerOptions().position(baksosonny8).title("Bakso Sonny VIII").snippet("Bakso Sonny VIII"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(balam, 12)); //set lokasi default map
    }
}
