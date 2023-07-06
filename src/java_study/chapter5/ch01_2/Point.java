package java_study.chapter5.ch01_2;

public class Point <T,V>{
    T x;
    V y;

    public Point(T x, V y){
        this.x = x;
        this.y = y;
    }

    public T getX(){
        return x;
    }

    public V getY(){
        return y;
    }
}
