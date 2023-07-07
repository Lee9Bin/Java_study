package java_study.chapter5.ch04;

public class Member implements Comparable<Member>{
    private int memberId;        //회원 아이디
    private String memberName;   //회원 이름

    public Member(int memberId, String memberName){ //생성자
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {  //
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString(){   //toString 메소드 오버로딩
        return memberName + " 회원님의 아이디는 " + memberId + "입니다";
    }

//  중복제거를 위한
    @Override
    public int hashCode() {
        return memberId;
    }
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Member){
            Member member = (Member)obj;
            if( this.memberId == member.memberId )
                return true;
            else
                return false;
        }
        return false;
    }
//  정렬을 위한
//  Comparable 인터페이스 구현
    @Override
    public int compareTo(Member member) {
//      아이디 기준으로 오름차순으로 정렬
        if (this.memberId > member.memberId){
            return -1;
        }
        else if (this.memberId < member.memberId){
            return 1;
        }
        else {
        return 0;
        }
//      위에 코드를 간단히 쓰면 return(this.memberId - member.memberId)
//      이때 부호에 따라 오름차순 내림차순 가능
    }
//  Comparator인터페이스 구현 하는 경우
//  이 인터페이스를 할 경우 treeSet = new TreeSet<>();에서 반드시<> ()에 내가 어떤것으로 구현했는지 명시해야해
//  그래서 보통 Comparable을 일반적으로 사용을 해 그럼 언제 쓰냐? 이미 Comparable이 구현 된 경우 Comparator로 비교하는 방식을 다시 구현 가능
//    @Override
//    public int compare(Member member1, Member member2){
//        return (member1.memberId - member2.memBerId2);
//    }
}
