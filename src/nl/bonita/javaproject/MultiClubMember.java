package nl.bonita.javaproject;

public class MultiClubMember extends Member {
    private int membershipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints){
        super(pMemberType, pMemberID, pName, pFees);
        pMembershipPoints = membershipPoints;
    }
    public void setMembershipPoints(int pMembershipPoints){
        membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints(){
        return membershipPoints;
    }

    public String toString(){
        return super.toString() + ", " + membershipPoints;
    }
}
