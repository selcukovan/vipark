package com.example.loginv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class PayActivity extends AppCompatActivity {
    TextView price;
    String parkName;
    String park_price;
    String total_saat;
    int total_price;
    FirebaseFirestore db = FirebaseFirestore.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Intent intent = getIntent();


        parkName = intent.getStringExtra("park_name2");
        total_saat = intent.getStringExtra("total_saat");




        price = (TextView) findViewById(R.id.price);

        CollectionReference collectionReference = db.collection("parks");

        collectionReference.whereEqualTo("name",parkName)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot document: task.getResult()){
                                park_price = document.getData().get("price").toString();


                            }
                        }else{




                        }
                    }
                });



        total_price = Integer.parseInt(park_price)*Integer.parseInt(total_saat);
        price.setText(total_price);



    }
}
