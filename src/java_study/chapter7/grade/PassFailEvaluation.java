package java_study.chapter7.grade;

public class PassFailEvaluation implements GradeEvaluation{

    @Override
    public String getGrade(int point) {
        String grade;
        if (point >= 70 && point<=100){
            grade = "P";
        }
        else if(point>=0 && point<70){
            grade = "F";
        }
        else grade = null;
        return grade;
    }
}
