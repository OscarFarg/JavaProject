package nl.bonita.javaproject;

public class SingleClubMember extends Member {
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub){
        super(pMemberType, pMemberID, pName, pFees);
                pClub = club;
    }

    public void setClub(int pClub){
        club = pClub;
    }

    public int setClub(){
        return club;
    }

    public String toString(){
        return super.toString() +", " + club;
    }
}
