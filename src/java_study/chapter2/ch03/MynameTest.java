package java_study.chapter2.ch03;

public class MynameTest {
    public static void main(String[] args){
        Myname LeeGyuBin = new Myname();

        LeeGyuBin.name = "Lee Gyu Bin";
        LeeGyuBin.age = 27;
        LeeGyuBin.home = "서울특별시 청와대";
        LeeGyuBin.phone="01000000000";

        LeeGyuBin.Info();
        LeeGyuBin.setName("이규팔");
        LeeGyuBin.Info();
    }
}
