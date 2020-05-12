package c346.rp.edu.problemstatementp03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DailyGradeArrayAdapter extends ArrayAdapter<ModulesClass> {
        private ArrayList<ModulesClass> dailyGradeArray;
        private Context context;
        private TextView tvDG;
        private TextView tvDGDisplay;
        private TextView Week;
        private ImageView ImMod;

        public DailyGradeArrayAdapter(Context context, int resource, ArrayList<ModulesClass> objects) {
            super(context, resource, objects);
            dailyGradeArray = objects;
            this.context = context;

        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvDG = (TextView)rowView.findViewById(R.id.gradeText);
        tvDGDisplay = (TextView)rowView.findViewById(R.id.tvDisplay);
        ImMod = (ImageView)rowView.findViewById(R.id.imageView) ;
        Week = (TextView)rowView.findViewById(R.id.dateWeek) ;


        ModulesClass Grades = dailyGradeArray.get(position);
        tvDGDisplay.setText("DG");
        tvDG.setText(Grades.getGrade());
        Week.setText(Grades.getWeekNum());
        ImMod.setImageResource(R.drawable.dg);

        return rowView;

    }
}
