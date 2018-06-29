package com.fadila.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AppInfoActivity extends AppCompatActivity {

    DatabaseReference db;

    //objects
    EditText edName, edAddress, edMoreInfo;
    Spinner spcat;
    Button btnsub;

    List<dbfirebase> ldb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info); //Memilih konten pada app info

        //getID
        edName = (EditText) findViewById(R.id.Name);
        edAddress = (EditText) findViewById(R.id.Address);
        spcat = (Spinner) findViewById(R.id.Category);
        edMoreInfo = (EditText) findViewById(R.id.MoreInfo);
        btnsub = (Button) findViewById(R.id.submit);

        db = FirebaseDatabase.getInstance().getReference("list_tempat");

        ldb = new ArrayList<>();

        btnsub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AddItem();
            }
        });

    }

    private void AddItem(){
        String Name = edName.getText().toString().trim();
        String Address = edAddress.getText().toString().trim();
        String Category = spcat.getSelectedItem().toString();
        String MoreInfo = edMoreInfo.getText().toString().trim();

                if(!TextUtils.isEmpty(Name)){
                    String nm = db.push().getKey();
                    dbfirebase dbs = new dbfirebase(Name, Address, Category, MoreInfo);
                    db.child(nm).setValue(dbs);
                    Toast.makeText(this,"Succesfully Submit!",Toast. LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this,"Failed!", Toast.LENGTH_LONG).show();
                }
    }

}