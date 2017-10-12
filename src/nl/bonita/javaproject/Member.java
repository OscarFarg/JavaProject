package nl.bonita.javaproject;

public class Member {

  private char memberType;
  private int memberID;
  private String name;
  private double fees;

  //Parameters met prefixen met p is een beetje ouderwets en niet nodig. Mag gewoon hetzelfde heten.
  public Member(char memberType, int pMemberID, String pName, double pFees) {
    this.memberType = memberType; //Al ze hetzelfde heten moet je this.memberType gebruiken om de global variable te benaderen.
    memberID = pMemberID;
    name = pName;
    fees = pFees;
  }

  public char getMemberType() {
    return memberType;
  }

  public void setMemberType(char pMemberType) {
    memberType = pMemberType;
  }

  public int getMemberID() {
    return memberID;
  }

  public void setMemberID(int pMemberID) {
    memberID = pMemberID;
  }

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public double getFees() {
    return fees;
  }

  public void setFees(double pFees) {
    fees = pFees;
  }

  @Override
  public String toString() {
    return memberType + ", " + memberID + ", " + name + ", " + fees;
  }
}
