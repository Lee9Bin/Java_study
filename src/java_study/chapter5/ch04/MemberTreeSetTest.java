package java_study.chapter5.ch04;

public class MemberTreeSetTest {
//  정렬이 가능한 set클래스 중복을 허용하지 않고, 오름차순이나 내림차순으로 정렬 가능
//  TreeSet은 Comparable 이나 Comparator을 구현해야 추가 될 수 있다.
    public static void main(String[] args) {

        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member memberKim = new Member(1003, "c");
        Member memberLee = new Member(1001, "z");
        Member memberKang = new Member(1002, "a");

        memberTreeSet.addMember(memberKim);
        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberKang);
        memberTreeSet.showAllMember();

    }
}