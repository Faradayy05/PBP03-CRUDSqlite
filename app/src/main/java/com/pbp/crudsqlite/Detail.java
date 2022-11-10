package com.pbp.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    TextView nama, kapasitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        nama = findViewById(R.id.namaruang);
        kapasitas = findViewById(R.id.kapasitas);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM ruangan WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            kapasitas.setText(cursor.getString(1).toString());
        }
    }
}