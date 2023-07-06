package java_study.chapter5.ch05;

public class MemberTreeSetTest {
//  정렬이 가능한 set클래스
    public static void main(String[] args) {
//        TreeSet<String> set = new TreeSet();
//
//        set.add("b");
//        set.add("a");
//        set.add("e");
//        set.add("z");
//        System.out.println(set);

        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member memberKim = new Member(1003, "z");
        Member memberLee = new Member(1001, "a");
        Member memberKang = new Member(1002, "c");

        memberTreeSet.addMember(memberKim);
        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberKang);
        memberTreeSet.showAllMember();

    }
}