package java_study.chapter6.ch04;

public class StringConcatImple implements StringConcat{
    @Override
    public void makeString(String str1, String str2) {
        System.out.println(str1 +','+ str2);
    }
}
