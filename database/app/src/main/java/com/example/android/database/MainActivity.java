package com.example.android.database;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name ;
    EditText age ;
    EditText bg ;
    EditText healths ;
    Button button ;
    ListView lv;
    DatabaseReference myRef;

    List<second> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         name = findViewById(R.id.name);
         age = findViewById(R.id.age);
         bg = findViewById(R.id.bg);
         healths = findViewById(R.id.healths);
         button = findViewById(R.id.button);

         lv = findViewById(R.id.lv);

        data=new ArrayList<second>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("user");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uidf = myRef.push().getKey();

                myRef.child(uidf).setValue(new second(uidf, name.getText().toString(), age.getText().toString(),
                        bg.getText().toString(),healths.getText().toString()));


                name.setText(null);
                age.setText(null);
                bg.setText(null);
                healths.setText(null);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot df :dataSnapshot.getChildren()){
                    data.add(df.getValue(second.class));
                }
                List<String> f = new ArrayList<>();

                for (second a : data){
                    f.add(a.name + " | " + a.age + " | " + a.bg + " | " + a.healths);
                }

                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.select_dialog_item,f);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
