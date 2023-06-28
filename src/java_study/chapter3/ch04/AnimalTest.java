package java_study.chapter3.ch04;

import javax.swing.event.AncestorListener;
import java.util.ArrayList;

class Animal{
    public void move(){
        System.out.println("동물이 움직입니다.");
    }
}

class Human extends Animal{
    @Override
    public void move() {
        System.out.println("사람이 두 발로 걷습니다.");
    }

    public void readBook(){
        System.out.println("사람이 책을 읽습니다다.");

    }
}

class Tiger extends Animal{
    @Override
    public void move() {
        System.out.println("호랑이가 네 발로 뜁니다.");
    }

    public void hunting(){
        System.out.println("호랑이가 사냥을 합니다.");

    }
}

class Eagle extends Animal{
    @Override
    public void move() {
        System.out.println("독수리가 하늘을 날아 다닙니다.");
    }

    public void flying(){
        System.out.println("독수리가 날개를 펴고 하늘을 날아갑니다.");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal hAnimal = new Human();
        Animal tAnimal = new Tiger();
        Animal eAnimal = new Eagle();
        AnimalTest test = new AnimalTest();
//        test.moveAnimal(hAnimal);
//        test.moveAnimal(tAnimal);
//        test.moveAnimal(eAnimal);
        ArrayList<Animal> animalsList = new ArrayList<>();
        animalsList.add(hAnimal);
        animalsList.add(tAnimal);
        animalsList.add(eAnimal);

        test.testDownCasting(animalsList);
    }
    public void testDownCasting(ArrayList<Animal> animalsList){
        for (Animal animal : animalsList){
            if (animal instanceof Human){
                Human human = (Human) animal;
                human.readBook();
            }
            else if (animal instanceof Tiger){
                Tiger tiger = (Tiger) animal;
                tiger.hunting();
            }
            else if (animal instanceof Eagle){
                Eagle eagle = (Eagle) animal;
                eagle.flying();
            }
        }

    }
    public void moveAnimal(Animal animal){
        animal.move();
    }
}
