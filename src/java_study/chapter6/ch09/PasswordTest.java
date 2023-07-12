package java_study.chapter6.ch09;

public class PasswordTest {
    public static void main(String[] args) {
        Password pass1 = new Password();
        Password pass2 = new Password();
        Password pass3 = new Password();
        Password pass4 = new Password();

        try {
            pass1.setPassword(null);
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
        try {
            pass2.setPassword("qwer");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
        try {
            pass3.setPassword("qwer23");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
        try {
            pass4.setPassword("qwerqwe");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}
