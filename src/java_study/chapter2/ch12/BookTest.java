package java_study.chapter2.ch12;

public class BookTest {
    public static void main(String[] args) {
//      기본데이터타입 int string 등은 각각 0,""으로 초기화 되고
//      객체는 null로 초기화
        Book[] arr = new Book[5];
        Book[] arr2 = new Book[5];

        arr[0] = new Book("태백산맥1", "조정래");
        arr[1] = new Book("태백산맥2", "조정래");
        arr[2] = new Book("태백산맥3", "조정래");
        arr[3] = new Book("태백산맥4", "조정래");
        arr[4] = new Book("태백산맥5", "조정래");
//      자바에서 제공하는 복사 메서드 (복사할 배열, 복사할 배열의 어디부터, 복사해서 저장할 배열, 저장할 배열의 어디부터, 복사할 갯수)
//      얕은복사 = 같은 주소를 가르키기 때문에 한쪽의 배열에 값이 수정되면 같이 수정돼 이것이 얕은복사
//      깊은복사 = 다른 주소를 가르키게 하기위해 각각 객체를 만들어준다면 얕은복사를 보완가능
//        arr2[0] = new Book();
//        arr2[1] = new Book();
//        arr2[2] = new Book();
//        arr2[3] = new Book();
//        arr2[4] = new Book();
          arr2 = arr;
//        System.arraycopy(arr, 0, arr2, 0, 5);
        for (int i =0; i<5; i++){
            System.out.println(arr[i].getTitle());
        }

        arr[0].setTitle("백두산");

        for (int i =0; i<5; i++){
            System.out.println(arr[i].getTitle());
        }
        for (int i =0; i<5; i++){
            System.out.println(arr2[i].getTitle());
        }
    }
}
