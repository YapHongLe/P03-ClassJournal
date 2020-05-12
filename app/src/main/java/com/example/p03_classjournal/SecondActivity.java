package com.example.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    int requestCodeForGrades = 1;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Grade> grade;
    Button btnEmail;
    Button btnInfo;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvGrades);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnInfo = (Button) findViewById(R.id.ButtonInfo);

        grade = new ArrayList<Grade>();

        aa = new GradesAdapter(this, R.layout.row, grade);
        lv.setAdapter(aa);

        grade.add(new Grade("C347", 1, "B"));
        grade.add(new Grade("C347", 2, "C"));
        grade.add(new Grade("C347", 3, "A"));

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                String message = "";
                for (int i = 0; i < grade.size(); i++) {
                    message += "Week " + grade.get(i).getWeek() + ": DG: " + grade.get(i).getGrade() + "\n";
                    email.putExtra(Intent.EXTRA_TEXT,
                            "Hi faci, \n\n I am...\n Please see my remarks so far. thank you!\n\n" + message);
                };
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(SecondActivity.this,
                        AddActivity.class);
                // Start the activity
                addIntent.putExtra("week", grade.size());
                startActivityForResult(addIntent, requestCodeForGrades);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                Grade newCA = (Grade) data.getSerializableExtra("MG");
                grade.add(newCA);
                aa.notifyDataSetChanged();
            }
        }
    }

}
