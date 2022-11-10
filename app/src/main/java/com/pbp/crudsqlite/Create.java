package com.pbp.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btnSimpan;
    EditText nama, kapasitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database(this);
        nama = findViewById(R.id.namaruang);
        kapasitas = findViewById(R.id.kapasitas);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO ruangan(nama, kapasitas) values('" +
                        nama.getText().toString() + "','" +
                        kapasitas.getText().toString() + "')");
                Toast.makeText(Create.this, "Data sukses disimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}