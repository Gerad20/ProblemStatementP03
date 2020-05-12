package c346.rp.edu.problemstatementp03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class addtionCode extends AppCompatActivity {

    TextView weekNumber;
    Button submit;
    RadioGroup DailyGradeToday;
    RadioButton chosenGrade;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        weekNumber = findViewById(R.id.weekDisplay);
        submit = findViewById(R.id.submitBtn);
        DailyGradeToday = findViewById(R.id.radioChoice);
        final Intent i = getIntent();
        final String week = i.getStringExtra("NextWeek");
        weekNumber.setText(i.getStringExtra("NextWeek"));
        Intent intents = new Intent();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedChoice = DailyGradeToday.getCheckedRadioButtonId();
                chosenGrade = (RadioButton)findViewById(selectedChoice);
                String grades= chosenGrade.getText().toString();
                ModulesClass newGrade = new ModulesClass(week,"DG",grades);

                Intent intents = new Intent();
                ArrayList<ModulesClass> array = (ArrayList<ModulesClass>) i.getSerializableExtra("moduleList");
                Toast.makeText(getApplicationContext(), array.toString(), Toast.LENGTH_SHORT).show();
                array.add(newGrade);
                intents.putExtra("moduleNew",array);

                setResult(RESULT_OK,intents);
                finish();


            }
        });


    }
}
