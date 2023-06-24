package java_study.chapter1;

public class Array {
    public static void main(String[] args) {
//      배열 선언하기
//      배열의 길이가 10이고 0으로 각각 초기화가 돼
        int[] arr = new int[10];
        int total = 0;
        for (int i =0; i<10; i++){
            System.out.print(arr[i]);
        }
        System.out.println();

//      각 자리에 값을 변경할수 있다.
        for(int i=0; i<10; i++) {
            arr[i] = i;
        }

        for (int i =0; i<10; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
//      파이썬에서 for i in arr:과 같은 역할
        for( int i : arr) {
            System.out.println(i);
        }

    }
}
