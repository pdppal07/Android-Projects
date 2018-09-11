package com.example.android.sqlitedatabase;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText idName,idEmail,idPhone;
    Button idSave,goDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);

        idName = findViewById(R.id.idName);
        idPhone = findViewById(R.id.idPhone);
        idEmail = findViewById(R.id.idEmail);
        idSave = findViewById(R.id.idSave);
        goDatabase=findViewById(R.id.goDatabase);

        idSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });
        goDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ReadDatabase.class);
                startActivity(i);
            }
        });
    }
    //
    //submit function is used to  insert data......
    //
    public void insert(){
        String name = idName.getText().toString();
        String phone = idName.getText().toString();
        String email = idName.getText().toString();
        Boolean result = myDb.insertData(name,phone,email);
        if(result == true){
            Toast.makeText(this,"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Data Insertion Failed",Toast.LENGTH_SHORT).show();
        }
    }


}
