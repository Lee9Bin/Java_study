package java_study.chapter7.school.report;

import java_study.chapter7.grade.BasicEvaluation;
import java_study.chapter7.grade.GradeEvaluation;
import java_study.chapter7.grade.MajorEvaluation;
import java_study.chapter7.school.School;
import java_study.chapter7.school.Score;
import java_study.chapter7.school.Student;
import java_study.chapter7.school.Subject;
import java_study.chapter7.utils.Define;

import java.util.ArrayList;

public class GenerateGradeReport {
    School school = School.getInstance();
    public static final String TITLE = " 수강생 학점 \t\t\n";
    public static final String HEADER = " 이름  |  학번  |중점과목| 점수   \n";
    public static final String LINE = "-------------------------------------\n";
    private StringBuffer buffer = new StringBuffer();

    public String getReport(){
        ArrayList<Subject> subjectList = school.getSubjectsList();
        for(Subject s: subjectList){
            makeHeader(s);
            makeBody(s);
            makeFooter();
        }
        return buffer.toString();
    }

    public void makeHeader(Subject subject){
        buffer.append(GenerateGradeReport.LINE);
        buffer.append("\n"+subject.getSubjectName());
        buffer.append(GenerateGradeReport.TITLE);
        buffer.append(GenerateGradeReport.HEADER);
        buffer.append(GenerateGradeReport.LINE);
    }
    public void makeBody(Subject subject){
        ArrayList<Student> studentList = subject.getStudentList();
        for (Student s: studentList){
            buffer.append(s.getName());
            buffer.append(" | ");
            buffer.append(s.getStudentId());
            buffer.append(" | ");
            buffer.append((s.getMajorSubject().getSubjectName()));
            buffer.append(" | ");
            getScoregrade(s, subject.getSubjectId());
            buffer.append("\n");
            buffer.append(LINE);
        }
    }

    public void getScoregrade(Student s, int subjectId){
        ArrayList<Score> scoreList = s.getScoreList();
        GradeEvaluation[] gradeEvaluations = {new BasicEvaluation(), new MajorEvaluation()};
        for (Score score : scoreList){
                buffer.append(" | ");
                buffer.append(score.getPoint()+":");
                if(s.getMajorSubject().getSubjectId() == subjectId){
                    buffer.append(gradeEvaluations[Define.SAB_TYPE].getGrade(score.getPoint()));
                }
                else {
                    buffer.append(gradeEvaluations[Define.AB_TYPE].getGrade(score.getPoint()));
                }
                buffer.append(" | ");

        }
    }
    public void makeFooter(){
        buffer.append("\n");
    }

}
