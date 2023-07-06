package java_study.chapter5.ch01;

public class ThreeDPrinterTest {
    public static void main(String[] args) {
        Powder powder = new Powder();
        ThreeDPrinterObject printerObject = new ThreeDPrinterObject();

        printerObject.setMaterial(powder);
//      그런데 이제 여기서 재료를 꺼내올때 강제로 형변환을 해줘야하는 번거러움이 발생하지
        Powder p = (Powder) printerObject.getMaterial();
//      그래서 나온게 제네릭 !!

    }
}
