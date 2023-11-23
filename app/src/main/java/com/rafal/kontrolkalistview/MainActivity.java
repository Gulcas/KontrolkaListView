package com.rafal.kontrolkalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (TextView) findViewById(R.id.textView);

        // deklaracja wartości listy ListView
        String[] values = new String[]{"Opcja wejściowa", "Opcja wyjściowa", "Opcja specjalna",
                "Opcja na obejście", "Opcja ekstremalna", "Opcja standardowa", "Opcja wielozadaniowa"};

        // przypisanie wartości listy do adaptera
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);

        // przypisanie adaptera do listy ListView
        ListView list = (ListView) findViewById(R.id.lista);
        list.setAdapter(adapter);

        // przypisanie słuchacza do listy ListView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemPosition = i + 1;
                String itemValue = (String) adapterView.getItemAtPosition(i);
                content.setText("Klinkęło: \npozycja: " + itemPosition + "\nwartość opcji: " + itemValue);
            }
        });

    }
}