package com.example.android.sqlitedatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReadDatabase extends AppCompatActivity {
    DataBaseHelper myDb;
    Button back,showDatabase,delete;
    TextView databaseResult;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_database);

        myDb = new DataBaseHelper(this);

        back=findViewById(R.id.back);
        showDatabase=findViewById(R.id.showDatabase);
        delete=findViewById(R.id.delete);
        databaseResult = findViewById(R.id.databaseResult);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ReadDatabase.this,MainActivity.class);
                startActivity(in);
            }
        });

        showDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Onclick","aaaaaa");
                    getData();
            }
        });

    }
    public void getData(){
        Cursor res = myDb.read();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0){
            while(res.moveToNext()){
                stringBuffer.append("Id: "+res.getString(0)+"\n");
                stringBuffer.append("Name: "+res.getString(1)+"\n");
                stringBuffer.append("Phone: "+res.getString(2)+"\n");
                stringBuffer.append("Email: "+res.getString(3)+"\n"+"\n");
            }
            databaseResult.setText(stringBuffer.toString());

            Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"NO Data  Retrieve",Toast.LENGTH_SHORT).show();
        }

    }
}
