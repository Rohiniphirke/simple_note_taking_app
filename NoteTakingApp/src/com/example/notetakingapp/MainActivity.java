package com.example.notetakingapp;

import java.util.List;

import com.example.notetakingapp.data.NoteItem;
import com.example.notetakingapp.data.NotesDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private NotesDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datasource = new NotesDataSource(MainActivity.this);
        List<NoteItem> notes = datasource.findAll();
        
        
        NoteItem note = notes.get(0);
        note.setText("Updated");
        datasource.update(note);
       
        notes = datasource.findAll();
        note = notes.get(0);
        
        Log.d("Notes",note.getKey()+ " : "+note.getText());
        
       // Toast.makeText(MainActivity.this, note.getKey(), Toast.LENGTH_LONG).show();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
