package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Sheilla Muligande
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
    this.height = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  public void bitChecker(String bits) {
    if (bits.length() < 0 || bits.length() > height) {
      throw new IndexOutOfBoundsException("bits length is not 0<=length<=6");
    }
    for (char ch : bits.toCharArray()) { // if this doesn't work just use a regular for loop.
      if (ch != '0' && ch != '1') {
        throw new IllegalArgumentException("bit is not 0 or 1");
      }
    }
  }


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * follows the path through the tree given by bits (adding nodes as appropriate) and adds or
   * replaces the value at the end with value. set should throw an IndexOutOfBoundsException if bits
   * is the inappropriate length or contains values other than 0 or 1.
   * 
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    bitChecker(bits);

    BitTreeNode currNode = root;
    for (int i = 0; i < bits.length(); i++) {
      char currBit = bits.charAt(i);

      if (currNode instanceof BitTreeInteriorNode) {
        BitTreeInteriorNode newNode = (BitTreeInteriorNode) currNode;

        if (currBit == '0') {
          if (newNode.getLeft() == null) {
            newNode.setLeft(new BitTreeInteriorNode());
          } else {
            currNode = newNode.getLeft();
          }
        } else {
          if (newNode.getRight() == null) {
            newNode.setRight(new BitTreeInteriorNode());
          } else {
            currNode = newNode.getRight();
          }
        }
      }
    }

    if (currNode instanceof BitTreeLeaf) {
      ((BitTreeLeaf) currNode).value = value;
    } else {
      if (bits.charAt(bits.length() - 1) == '0') {
        ((BitTreeInteriorNode) currNode).setLeft(new BitTreeLeaf(value));
      } else {
        ((BitTreeInteriorNode) currNode).setRight(new BitTreeLeaf(value));
      }
    }
  } // set(String, String)


  /**
   * follows the path through the tree given by bits, returning the value at the end. If there is no
   * such path, or if bits is the incorrect length, get should throw an IndexOutOfBoundsException.
   * 
   * @param bits
   * @return
   */
  public String get(String bits) {
    bitChecker(bits);

    BitTreeNode currNode = root;
    for (int i = 0; i < bits.length(); i++) {
      char currBit = bits.charAt(i);

      if (currNode instanceof BitTreeInteriorNode) {
        BitTreeInteriorNode newNode = (BitTreeInteriorNode) currNode;

        if (currBit == '0') {
          if (newNode.getLeft() == null) {
            throw new IndexOutOfBoundsException();
          } else {
            currNode = newNode.getLeft();
          }
        } else {
          if (newNode.getRight() == null) {
            throw new IndexOutOfBoundsException();
          } else {
            currNode = newNode.getRight();
          }
        }
      }
    }

    if (currNode instanceof BitTreeLeaf) {
      return ((BitTreeLeaf) currNode).getVal();
    } else {
      throw new IndexOutOfBoundsException();
    }
  } // get(String, String)

  /**
   * prints out the contents of the tree in CSV format. For example, one row of our braille tree
   * will be “101100,M” (without the quotation marks).
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    dumpHelper(this.root, "", pen);
  } // dump(PrintWriter)


  /**
   * 
   * @param node
   * @param path
   * @param pen
   */
  public void dumpHelper(BitTreeNode node, String path, PrintWriter pen) {
    if (node instanceof BitTreeLeaf) {
      pen.println(path + "," + ((BitTreeLeaf) node).getVal());
    } else if (node instanceof BitTreeInteriorNode) {
      BitTreeInteriorNode newNode = (BitTreeInteriorNode) node;
      if (newNode.getLeft() != null) {
        dumpHelper(newNode.getLeft(), path + "0", pen);
      }
      if (newNode.getRight() != null) {
        dumpHelper(newNode.right, path + "1", pen);
      }
    }
  }

  /**
   * Reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  public void load(InputStream source) {
    Scanner scanner = new Scanner(source);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] lineParts = line.split(",");
      if (lineParts.length == 2) {
        set(lineParts[0], lineParts[1]);
      }
    }
  } // load(InputStream)

} // class BitTree
