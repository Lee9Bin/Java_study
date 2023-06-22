package java_study.chapter2.ch06;

public class Birthday {
    private int year;
    private int month;
    private int day;
//  불린값은 false값으로 초기화
    private int check ;
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 2023){
            check += 1 ;

        }
        else {
            this.year = year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month > 12 || month < 1){
            check += 1 ;
        }
        else {
            this.month = month;
        }

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void showBirthday(){
        if(check == 0){
            System.out.println(year + "년 " + month + "월 " + day +"일 입니다.");
        }
        else {
            System.out.println("유효하지 않은 생일입니다.");
        }
        check = 0;
    }

}
