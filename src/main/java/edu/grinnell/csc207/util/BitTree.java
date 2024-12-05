package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Your Name Here
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * the root.
   */
    public BitTreeNode root;

  /**
   * Height of the tree.
   */
    public int height;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.root = new BitTreeInteriorNode();
    this.height = height;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  public void bitChecker(String bits){
    if (bits.length() != height){
      throw new IndexOutOfBoundsException("bits length is not 0<=length<=6");
    }
    for (char ch : bits.toCharArray()){ // if this doesn't work just use a regular for loop.
      if (ch != 0 && ch != '1'){
        throw new IllegalArgumentException("bit is not 0 or 1");
      }
    }
  }


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * follows the path through the tree given by bits 
   * (adding nodes as appropriate) and adds or replaces
   * the value at the end with value. set should throw an 
   * IndexOutOfBoundsException if bits is the inappropriate 
   * length or contains values other than 0 or 1.
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    bitChecker(bits);

    BitTreeNode currNode = root;
    for (int i = 0; i < bits.length(); i++){
      char currBit = bits.charAt(i);
      
      if(currNode instanceof BitTreeInteriorNode){
        Bit
      }
    }
  } // set(String, String)

  
  /**
   * follows the path through the tree given by bits, 
   * returning the value at the end. If there is no 
   * such path, or if bits is the incorrect length, 
   * get should throw an IndexOutOfBoundsException.
   * @param bits 
   * @return
   */
  public String get(String bits) {
    return "";  // STUB
  } // get(String, String)

  /**
   * prints out the contents of the tree in CSV format. 
   * For example, one row of our braille tree will be “101100,M” 
   * (without the quotation marks).
   * @param pen
   */
  public void dump(PrintWriter pen) {
    // STUB
  } // dump(PrintWriter)

  /**
   * Reads a series of lines of the form bits,value and stores them in the tree.
   * @param source 
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)


  

} // class BitTree
