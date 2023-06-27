package java_study.chapter3.ch02;
//상속: 새로운 클래스를 정의 할 때 이미 구현된 클래스를 상속 받아서 속성이나 기능을 확장한다.
//이미 구현된 클래스보다 더 구체적인 기능를 가진 클래스를 구현해야할때


//고객 중 VIP를 위해 추가된 기능이 있고 등급이 다르니
//상속을 통해서 클래스를 구현하는거야

public class VIPCustomer extends Customer {
    double salesRatio;
    private String agentId;

    public VIPCustomer(int customerId, String customerName){
        super(customerId,customerName);
        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;

    }

//  이 주석이 있으면 오버라이드 메서드라고 알려주는 애너테이션 그래서 메서드 이름이 틀리면 오류가 나!
//  메서드 재정의
    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        price -= (int)(price * salesRatio);
        return price;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
