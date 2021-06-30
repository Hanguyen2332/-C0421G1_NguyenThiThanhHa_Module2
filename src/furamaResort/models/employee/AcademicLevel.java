package furamaResort.models.employee;

public class AcademicLevel {
    private String levelName;

    public AcademicLevel(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return  levelName ;
    }
}
