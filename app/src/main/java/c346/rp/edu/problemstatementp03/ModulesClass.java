package c346.rp.edu.problemstatementp03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModulesClass implements Serializable {
    private String WeekNum;
    private String DG;
    private String grade;

    public ModulesClass(String WeekNum,String DG, String grade){
        this.WeekNum = WeekNum;
        this.DG = DG;
        this.grade = grade;


    }


    public String getWeekNum() {
        return WeekNum;
    }

    public void setWeekNum(String weekNum) {
        WeekNum = weekNum;
    }

    public String getDG() {
        return DG;
    }

    public void setDG(String DG) {
        this.DG = DG;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
