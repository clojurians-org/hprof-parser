import java.io.*;
import parser.HprofParser;
import handler.*;


public class Parse {

  public static void main(String[] args) {

    if (args.length != 1) {
      System.out.println("Usage: java Parser inputfile");
      System.exit(1);
    }

    RecordHandler handler = new PrintHandler();
    HprofParser parser = new HprofParser(handler);

    try {
      FileInputStream fs = new FileInputStream(args[0]);
      DataInputStream in = new DataInputStream(new BufferedInputStream(fs));

      parser.parse(in);

      in.close();
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

  }

}
