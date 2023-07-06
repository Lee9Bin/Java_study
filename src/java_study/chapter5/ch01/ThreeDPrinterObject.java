package java_study.chapter5.ch01;
//그래서 자료형이 여러개인 것을 수용하기 위해 Object로 만들었어 왜? Object는 모든 클래스의 상위 클래스이니깐
public class ThreeDPrinterObject {
    private Object material;

    public Object getMaterial() {
        return material;
    }

    public void setMaterial(Object material) {
        this.material = material;
    }
}
