package nl.bonita.javaproject;
import java.util.LinkedList;

public class JavaProject {

    public static final int ADD_MEMBER = 1;
    public static final int REMOVE_MEMBER = 2;
    public static final int DISPLAY_MEMBER_INFORMATION = 3;

    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();
        while (choice != -1) {
            switch (choice){
                case ADD_MEMBER: //In plaats van 1/2/3 kan je hier gebruik maken van constanten.
                    // Dat maakt dit stuk code een stuk leesbaarder.
                    mem = mm.addMembers(members);
                    fh.appendFile(mem);
                    return;
                case REMOVE_MEMBER:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    return;
                case DISPLAY_MEMBER_INFORMATION:
                    mm.printMemberInfo(members);
                    return;
                default:
                    System.out.println("Your input is invalid, please try again");
            }
            choice = mm.getChoice();
        }
        System.out.println("Goodbye!");
    }
}
