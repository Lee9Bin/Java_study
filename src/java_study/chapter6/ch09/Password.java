package java_study.chapter6.ch09;

public class Password {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException {
        if(password == null){
            throw new PasswordException("비밀번호는 null일 수 없습니다.");
        }
        else if(password.length() < 5){
            throw new PasswordException("비밀번호는 5자 이상이여야 합니다.");
        }
        else if(password.matches("[a-zA=Z]+")){
            throw new PasswordException("비밀번호는 숫자나 특수 문자를 조합해야합니다");
        }
        this.password = password;
        System.out.println("정상입니다.");
    }
}
