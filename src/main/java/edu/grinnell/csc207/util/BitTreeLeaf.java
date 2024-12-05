package edu.grinnell.csc207.util;

public class BitTreeLeaf implements BitTreeNode{
  
  public String value;

  public BitTreeLeaf(){
    this.value = null;
  }

    /**
   * returns the character from leaf.
   * @return the character.
   */
  @Override
  public String getVal() {
    return this.value;
  }

   /**
   * returns the left child's value.
   * @return an exception because leaf doesn't have children.
   */
  @Override
  public BitTreeNode getLeft() {
    throw new UnsupportedOperationException("leaf does not have left child.'");
  }

   /**
   * returns the right child's value.
   * @return an exception because leaf doesn't have children.
   */
  @Override
  public BitTreeNode getRight() {
    throw new UnsupportedOperationException("leaf does not have right child.");
  }

}
