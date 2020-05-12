package c346.rp.edu.problemstatementp03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class DiplayGradeClass extends AppCompatActivity {

    ListView GradeDisplays;

    DailyGradeArrayAdapter aa2;

    Button add;
    Button info;
    Button Email;


    ArrayList<ModulesClass> array;

    int RequestCodeAdd = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaygrade);
        add = findViewById(R.id.addBtn);
        info = findViewById(R.id.infoBtn);
        Email = findViewById(R.id.emailBtn);

        final Intent i = getIntent();
        array = (ArrayList<ModulesClass>) i.getSerializableExtra("modules");




        //ArrayList<ModulesClass> array = new ArrayList<>();


        GradeDisplays = findViewById(R.id.gradeList);

        ArrayAdapter aa2 = new DailyGradeArrayAdapter(this, R.layout.row,array);
        GradeDisplays.setAdapter(aa2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), addtionCode.class);
                i.putExtra("NextWeek", "Week " + (array.size() + 1));
                i.putExtra("moduleList",array);
                startActivityForResult(i, RequestCodeAdd);




            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ChosenModules = i.getStringExtra("moduleNumber");

                if(ChosenModules.equals("C347") ) {

                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                    startActivity(rpIntent);
                }else if(ChosenModules.equals("C302")){
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C203"));
                    startActivity(rpIntent);

                }

            }
        });

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent email = new Intent(Intent.ACTION_SEND);

                String message  = ("Hi feci \n I am gerad  \n Please see my remarks, thank you!\n");


                for(int i = 0; i < array.size(); i++){
                    message = message + (array.get(i).getWeekNum() + ":" +  array.get(i).getDG() + ":" + array.get(i).getGrade() + "\n");
                }
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));


            }
        });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == RESULT_OK){
            if (requestCode == 1) {
                GradeDisplays = findViewById(R.id.gradeList);
                ArrayList<ModulesClass> array2 = (ArrayList<ModulesClass>) data.getSerializableExtra("moduleNew");
                ArrayAdapter aa2 = new DailyGradeArrayAdapter(this, R.layout.row,array2);
                array = array2;
                GradeDisplays.setAdapter(aa2);

            }

        }
    }

}
