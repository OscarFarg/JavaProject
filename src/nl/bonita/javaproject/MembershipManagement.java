package nl.bonita.javaproject;
import sun.awt.image.ImageWatched;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            try
            {
                choice = reader.nextInt();
                if (choice == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            }
            catch (InputMismatchException e)
            {
                reader.nextLine();
                System.out.println("ERROR: INVALID INPUT. Please try again:");
            }
        }
        return choice;
    }

    private void printClubOptions(){
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) MultiClubs");
    }

    public int getChoice() {
        int choice;
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("===============================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println(" ");
        System.out.println("Please select an option (or Enter -1 to quit");
        choice = getIntInput();
        return choice;
    }

    //Voor deze methode geldt ook:
    // Duidelijke namen gebruiken voor variable, geen afkortingen.
    // Variabelen declareren wanneer ze nodig zijn. Niet allemaal aan het begin van de methode.
    // Integers in een switch statement vervangen voor constanten om de leesbaarheid te vergroten.
    public String addMembers(LinkedList<Member> m){
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;
        System.out.print("Please enter your name:");
        name = reader.nextLine();
        printClubOptions();
        System.out.println("Please enter your club ID");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("Your choice is invalid");
            System.out.println("Please enter correct value");
            club = getIntInput();
        }
        if (m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;
        if (club != 4)
        {
            cal = (n) -> { //Haakjes om 'n' zijn niet nodig. 'n' is een onduidelijke naam.
                switch (n)
                {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added \n");
        } else {
            cal = (n) -> { //Haakjes om 'n' zijn niet nodig. 'n' is een onduidelijke naam.
                if (n == 4)
                    return 1200;
                else {
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added \n");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.println("Please enter the memberID of the member you want to remove");
        memberID = getIntInput();
        for (int i = 0; i<m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.println("The member has been removed");
                return;
            }
            }
            System.out.println("MemberID is not found");
        }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberID;
        String[] memberInfo;
        System.out.println("Please enter the memberID of the member you want to view");
        memberID = getIntInput();
        for (int i = 0; i<m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                memberInfo = m.get(i).toString().split(", ");
                if (memberInfo[0] == "S") {
                    System.out.println("Member Type: " + memberInfo[0]);
                    System.out.println("Member ID: " + memberInfo[1]);
                    System.out.println("Member Name: " + memberInfo[2]);
                    System.out.println("Membership Fees: " + memberInfo[3]);
                    System.out.println("Club ID: " + memberInfo[4]);
                    return;
                }
                else {
                    System.out.println("Member Type: " + memberInfo[0]);
                    System.out.println("Member ID: " + memberInfo[1]);
                    System.out.println("Member Name: " + memberInfo[2]);
                    System.out.println("Membership Fees: " + memberInfo[3]);
                    System.out.println("Membership Points: " + memberInfo[4]);
                    return;
                    }
            } else {
                System.out.println("This member does not exist");
                System.out.println("Please enter a correct value");
                memberID = getIntInput();
            }
        }
    }
}
