package com.example.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rg;
    TextView tvAddWeek;
    int week = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        tvAddWeek = (TextView) findViewById(R.id.textViewAddWeek);

        Intent addIntent = getIntent();
        week = addIntent.getIntExtra("week",0);
        week += 1;
        tvAddWeek.setText("Week " + week);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = "";
                int selectedButtonID = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) rg.getChildAt(rg.indexOfChild(rg.findViewById(rg.getCheckedRadioButtonId())));

                Grade newMG = new Grade("C347", week, rb.getText().toString());
                Intent i = new Intent();
                i.putExtra("MG", newMG);
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }
}
