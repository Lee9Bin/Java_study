package java_study.chapter5.ch01_2;

public class GenericPrinter<T extends Material> {
    private T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    public String toString(){
        return material.toString();
    }
}
