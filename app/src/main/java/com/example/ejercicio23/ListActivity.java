package com.example.ejercicio23;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView simpleGridView = (ListView) findViewById(R.id.listContent);
        SQLiteConexion conection = new SQLiteConexion(this, Config.NameDataBase, null, 1);
        ArrayList<photoModel> cardsList = new ArrayList<>();
        Cursor cursor= conection.getAll();
        int x=0;
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while(cursor.isAfterLast()==false)
            {
                byte[] bytes=cursor.getBlob(cursor.getColumnIndexOrThrow(Config.image));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(Config.description));

                photoModel photography = new photoModel(BitmapFactory.decodeByteArray(bytes, 0, bytes.length), description);
                cardsList.add(photography);
                cursor.moveToNext();
                x++;
            }

            Adapter myAdapter=new Adapter(this,R.layout.data_grid,cardsList);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}