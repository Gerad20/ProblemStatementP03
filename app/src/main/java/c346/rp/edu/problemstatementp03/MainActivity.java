package c346.rp.edu.problemstatementp03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView Modules;

    ArrayList<String> modules = new ArrayList<>();


    //request codes;


    //for the modules array
    ArrayList<String> modules1Weeks = new ArrayList<>();
    ArrayList<String> modules1grades= new ArrayList<>();
    ArrayList<String> modules3Weeks = new ArrayList<>();
    ArrayList<String> modules2Weeks = new ArrayList<>();
    ArrayList<String> modules2grades= new ArrayList<>();



    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Modules = findViewById(R.id.modules);

        modules.add("C347");
        modules.add("C302");

        //add into the array
        modules1Weeks.add("Week 1");
        modules2Weeks.add("Week 1");

        modules1Weeks.add("A");
        modules2grades.add("B");



        aa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,modules);
        Modules.setAdapter(aa);

       Modules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<ModulesClass> mod1 = new ArrayList<ModulesClass>(Arrays.asList(new ModulesClass("week 1","DG","A"), new ModulesClass("week 2","DG","B"),new ModulesClass("week 3","DG","F")));
               ArrayList<ModulesClass> mod2 = new ArrayList<ModulesClass>(Arrays.asList(new ModulesClass("week 1","DG","A"), new ModulesClass("week 2","DG","C"),new ModulesClass("week 3","DG","C")));

               String selectedFromList = (Modules.getItemAtPosition(i).toString());

               if(selectedFromList == "C347"){
                    Intent intents = new Intent(getApplicationContext(),DiplayGradeClass.class);
                    intents.putExtra("modules", mod1);
                   intents.putExtra("moduleNumber",selectedFromList );
                    startActivity(intents);
               }else if(selectedFromList == "C302"){
                   Intent intents = new Intent(getApplicationContext(),DiplayGradeClass.class);
                   intents.putExtra("modules", mod2);
                   intents.putExtra("moduleNumber",selectedFromList );
                   startActivity(intents);
               }

           }
       });

}}
