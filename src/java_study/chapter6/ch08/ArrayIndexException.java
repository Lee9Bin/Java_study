package java_study.chapter6.ch08;

public class ArrayIndexException {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

//      Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
//	at java_study.chapter6.ch08.ArrayIndexException.main(ArrayIndexException.java:8) 오류발생
//        for(int i = 0; i <= 5; i++){
//            System.out.println(arr[i]);
//        }

//      예외처리를 해주면 프로그램이 멈추지 않아
        try{
            for(int i = 0; i <= 5; i++){
                System.out.println(arr[i]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
        System.out.println("비정상으로 멈추지 않았습니다.");
    }
}
