package edu.grinnell.csc207.main;

import java.io.IOException;
import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
     * @throws IOException 
     *
     */
    public static void main(String[] args) throws IOException {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length < 2){
      throw new IOException ("invalid input");
    }

    String alphabet = args[0].toLowerCase();
    String message = args[1];

    try{
      switch(alphabet){
        case "braille":
        StringBuilder brailleMsg = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
          brailleMsg.append(BrailleAsciiTables.toBraille(message.charAt(i)));
        } //for
        System.out.println(brailleMsg.toString());
        break;
        case "ascii": 
          System.out.println(BrailleAsciiTables.toAscii(message));
          break;
        case "unicode":
          System.out.println(BrailleAsciiTables.toUnicode(message));
          break;
        default:
        System.err.println("wrong alphabet type.");
      } //switch
    } catch (Exception e){
      e.printStackTrace();
    } //try/catch.
    pen.close();
  } // main(String[]

} // class BrailleASCII
