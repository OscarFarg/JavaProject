package nl.bonita.javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {

  //Voeg altijd een lege regel toe tussen je class en eerste methode.
  public LinkedList<Member> readFile() { //In plaats van LinkedList<Member> is het beter om een List<Member> te returnen.

    //Hier declareer je al de variabelen voor deze methode bovenin je methode. Het is beter om
    // variabelen te declareren vlak voordat je ze gebruikt. Dat maakt de code leesbaarder.
    LinkedList<Member> m = new LinkedList();
    // Gebruik altijd duidelijke beschrijvende namen voor variabelen. Dus bijvoorbeeld 'memberList' in plaats van 'm'
    String lineRead;
    String[] splitLine;
    Member mem; //Ook hier zou je een duidelijke naam moeten gebruiken, bijvoorbeeld gewoon 'member' ipv 'mem'.

    try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
      lineRead = reader.readLine();
      while (lineRead != null) {
        splitLine = lineRead.split(", ");
        if (splitLine[0].equals("S")) {
          mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2],
              Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
        } else {
          mem = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2],
              Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
        }
        m.add(mem);
        lineRead = reader.readLine();
      }
    } catch (IOException e) {
      System.out.println(e);
    }
    return m;
  }

  //Hier ook een duidelijke naam gebruiken ipv mem. Zorg er voor dat je code leesbaar is als normale tekst.
  public void appendFile(String mem) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
      writer.write(mem + "\n");
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  //Hier ook een duidelijke naam gebruiken ipv m.
  public void overwriteFile(LinkedList<Member> m) {
    String s; //Andere naam ipv 's'.

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
      for (int i = 0; i < m.size(); i++) {
        s = m.get(i).toString();
        writer.write(s + "\n");
      }
    } catch (IOException e) {
      System.out.println(e);
    }

    try {
      File f = new File("members.csv"); //Duidelijkere naam gebruiken
      File tf = new File("members.temp"); //Duidelijkere naam gebruiken.
      f.delete();
      tf.renameTo(f);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
