package java_study.chapter5.ch03;

public class MemberHashSetTest {

    public static void main(String[] args) {

        MemberHashSet memberHashSet = new MemberHashSet();

        Member memberLee = new Member(1001, "이순신");
        Member memberKim = new Member(1002, "김유신");
        Member memberKang = new Member(1003, "강감찬");

        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberKim);
        memberHashSet.addMember(memberKang);

        Member memberHong = new Member(1003, "홍길동");  //이름 중복
        memberHashSet.addMember(memberHong);
        memberHashSet.showAllMember();
//      분명 중복을 허용하지 않는다 했는데 둘중 하나만 달라도 들어가네? String 등 같은경우는 equals랑 hash코드가 재정의 돼있지만
//      내가 만든 클래스의 경우 재정의를 직접 해줘야해
    }
}
