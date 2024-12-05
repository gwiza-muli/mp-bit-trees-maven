package edu.grinnell.csc207.util;

public interface BitTreeNode {
  
  //////////////Fields///////////
  
  /**
   * returns the character from leaf.
   * @return the character.
   */
  String getVal();

  /**
   * returns the left child's value.
   * @return the left child's value.
   */
  BitTreeNode getLeft();

  /**
   * returns the right child's value.
   * @return the right child's value.
   */
  BitTreeNode getRight();


 
}
