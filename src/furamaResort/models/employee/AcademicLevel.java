package furamaResort.models.employee;

import java.io.Serializable;

public class AcademicLevel implements Serializable {
    private String levelName;

    public AcademicLevel(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return  levelName ;
    }
}
