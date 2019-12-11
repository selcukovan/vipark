package com.example.loginv1;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private GoogleMap mMap;
    ArrayList<Integer> ids;

    BitmapDescriptorFactory bitmapDescriptorFactory;
    private StorageReference mStorageRef;
    ConstraintLayout info_window_park_markers;
    TextView info_of_park_name;
    Button check_rezervation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        info_window_park_markers = (ConstraintLayout) findViewById(R.id.info_window_park_markers);
        info_of_park_name = (TextView) findViewById(R.id.info_of_park_name);
        check_rezervation = (Button) findViewById(R.id.check_rezervation);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        info_window_park_markers.setVisibility(View.INVISIBLE);


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Log.d("test", "asdasd");
        //(document.getData().get("logo_icon_id").toString())

        db.collection("parks")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (final QueryDocumentSnapshot document : task.getResult()) {
                                mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(document.getData().get("x")
                                        .toString()), Double.parseDouble(document.getData().get("y")
                                        .toString()))).title(document.getData().get("name").toString())
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bjk)));





                                /*info_of_park_name.setText(document.get("name").toString());
                                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                                    @Override
                                    public boolean onMarkerClick(Marker marker) {
                                        Toast.makeText(MapsActivity.this,"hellö",Toast.LENGTH_SHORT).show();
                                        if(document.getData().get("rezervation_able").equals(true)){
                                            check_rezervation.setClickable(true);
                                        }else{
                                            check_rezervation.setClickable(false);
                                        }
                                        info_window_park_markers.setVisibility(View.VISIBLE);
                                        return true;
                                    }
                                });*/
                                mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                                    @Override
                                    public void onMapClick(LatLng latLng) {
                                        info_window_park_markers.setVisibility(View.INVISIBLE);
                                    }
                                });

                                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                    @Override
                                    public void onInfoWindowClick(Marker marker) {

                                        Toast.makeText(MapsActivity.this,"hellö",Toast.LENGTH_SHORT).show();
                                        if(document.get("rezervation_able").equals(true)){
                                            Toast.makeText(MapsActivity.this,"button enable",Toast.LENGTH_SHORT).show();
                                            check_rezervation.setEnabled(true);
                                        }else{
                                            Toast.makeText(MapsActivity.this,"button enable false",Toast.LENGTH_SHORT).show();
                                            check_rezervation.setEnabled(false);
                                        }

                                        info_window_park_markers.setVisibility(View.VISIBLE);

                                    }
                                });
                            }

                        } else {
                            Log.w("test", "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    /*ublic void download_file() throws IOException {
        final File localFile = File.createTempFile("images", "jpg");
        mStorageRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                        localFile.getAbsoluteFile();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });
    }*/

}
