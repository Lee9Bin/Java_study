package java_study.chapter5.ch01;

public class GenericPrinterTest {
    public static void main(String[] args) {
//            <여기에 어떤 타입을 쓸거진 지정>
        Powder powder = new Powder();
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();

        powderPrinter.setMaterial(powder);

//      컴파일 되면서 T부분이 Powder라고 컴파일러가 리플레이스 해주기 때문에 형변환이 필요가 없어
        Powder p = powderPrinter.getMaterial();
        System.out.println(powderPrinter.toString());
    }
}
