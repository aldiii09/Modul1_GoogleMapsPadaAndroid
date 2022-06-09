package com.aermb.modul1_googlemapsapi;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.aermb.modul1_googlemapsapi.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng untad = new LatLng(-0.83643, 119.89369);
        LatLng vatulemo = new LatLng(-0.90019, 119.88957);
        LatLng sma5 = new LatLng(-0.84181, 119.88399);

        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.marker_black);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.marker_red);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s,lebar,tinggi,false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d,lebar,tinggi,false);

        mMap.addMarker(new MarkerOptions().position(untad).title("Universitas Tadulako")
            .snippet("ini adalah kampus kami")
            .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(vatulemo).title("Lapangan Vatulemo")
                .snippet("ini adalah lapangan vatulemo")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker(new MarkerOptions().position(sma5).title("SMA Negeri 5 Palu")
                .snippet("Ini adalah SMA Negeri 5 Palu")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                new LatLng(-0.836341,119.892311),
                new LatLng(-0.836545,119.892279),
                new LatLng(-0.836384,119.889565),
                new LatLng(-0.836363,119.889340),
                new LatLng(-0.836282,119.889233),
                new LatLng(-0.836282,119.889233),
                new LatLng(-0.836204,119.883431),
                new LatLng(-0.836743,119.883487),
                new LatLng(-0.839093,119.883360),
                new LatLng(-0.841530,119.883290),
                new LatLng(-0.841571,119.884040),
                sma5
                ).width(10)
                        .color(Color.BLUE)
        );

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                new LatLng(-0.836341,119.892311),
                new LatLng(-0.836545,119.892279),
                new LatLng(-0.836384,119.889565),
                new LatLng(-0.836383,119.88948),
                new LatLng(-0.843353, 119.89095),
                new LatLng(-0.846832, 119.89166),
                new LatLng(-0.850261, 119.89206),
                new LatLng(-0.851226, 119.89212),
                new LatLng(-0.864293, 119.88938),
                new LatLng(-0.870374, 119.88723),
                new LatLng(-0.870940, 119.88728),
                new LatLng(-0.871153, 119.88711),
                new LatLng(-0.873840, 119.88716),
                new LatLng(-0.875699, 119.88747),
                new LatLng(-0.878514, 119.88765),
                new LatLng(-0.880322, 119.88747),
                new LatLng(-0.881467, 119.88727),
                new LatLng(-0.885776, 119.88657),
                new LatLng(-0.887999, 119.88547),
                new LatLng(-0.888234, 119.88537),
                new LatLng(-0.897655, 119.88735),
                new LatLng(-0.900825, 119.88817),
                new LatLng(-0.900789, 119.88916),
                vatulemo
                ).width(10)
                        .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(untad, 11.5f));
    }
}

