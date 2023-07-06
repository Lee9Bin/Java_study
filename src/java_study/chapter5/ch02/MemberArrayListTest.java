package java_study.chapter5.ch03;

public class MemberArrayListTest {
    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberL = new Member(1001,"lee");
        Member memberK = new Member(1001,"kim");
        Member memberP = new Member(1001,"park");
        Member memberS = new Member(1001,"son");
        Member memberG = new Member(1001,"gang");

        memberArrayList.addMember(memberL);
        memberArrayList.addMember(memberK);
        memberArrayList.addMember(memberP);
        memberArrayList.addMember(memberS);
        memberArrayList.addMember(memberG);

        memberArrayList.showAllMember();

        memberArrayList.removeMember(memberP.getMemberId());
        memberArrayList.showAllMember();
    }
}
