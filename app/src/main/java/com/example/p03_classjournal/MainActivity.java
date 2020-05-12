package com.example.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvC347;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvC347 = (TextView) findViewById(R.id.textViewC347);

        tvC347.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grade grade1 = new Grade("C347", 1, "A");
                Intent i = new Intent(MainActivity.this,
                        SecondActivity.class);
                // Put hero object in intent
                i.putExtra("C347Week1", grade1);
                startActivity(i);

            }
        });

    }
}
