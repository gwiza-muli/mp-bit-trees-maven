package edu.grinnell.csc207.util;

/**
 * Creates a bit tree interior node. Implements 
 * the BitTreeNode interface.
 * @author Sheilla Muligande
 */
public class BitTreeInteriorNode implements BitTreeNode{

  //Fields//
  BitTreeNode left;
  BitTreeNode right;

  //constructor//
  public BitTreeInteriorNode(){
    this.left = null;
    this.right = null;
  }

    /**
   * returns an exception.
   * @return an exception because interior node does not have a letter value.
   */
  @Override
  public String getVal() {
    
    throw new UnsupportedOperationException("Interior node does not have letter value.");
  }

  /**
   * returns the left child's value.
   * @return the left child's value.
   */
  @Override
  public BitTreeNode getLeft() {
   return this.left;
  }

  /**
   * returns the right child's value.
   * @return the right child's value.
   */
  @Override
  public BitTreeNode getRight() {
    return this.right;
  }

  public void setLeft(BitTreeNode leftNode){
    this.left = leftNode;
  }

  public void setRight(BitTreeNode rightNode){
    this.right = rightNode;
  }

}
