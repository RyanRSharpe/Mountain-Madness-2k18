package com.example.mountainmadness.mountainmadness;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class historyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        ArrayList strArr = new ArrayList<String>(0);
//        //Arrays.asList("a", "b", "c", "d", "e")
//        for(int i=0;i<200;i++){
//            strArr.add(Integer.toString(i));
//        }
//        if(StrArr.strArr.size() <200)
//        for(int i=0;i<200;i++){
//            StrArr.strArr.add(Integer.toString(i));
//        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.stock_textview, StrArr.strArr);

        ListView listView = (ListView) findViewById(R.id.historyList);
        listView.setNestedScrollingEnabled(true);
        listView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
