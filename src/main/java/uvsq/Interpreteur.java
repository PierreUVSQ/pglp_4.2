package uvsq;

import java.util.Stack;

public class Interpreteur {

  protected Stack<Integer> pile;
  protected Stack<Integer> pilePrecedente;

  public Interpreteur() {
    this.pile = new Stack<Integer>();
  }

  public void undo() {

    pile = pilePrecedente;
  }

  public void quit() {
    System.exit(0);
  }
}
