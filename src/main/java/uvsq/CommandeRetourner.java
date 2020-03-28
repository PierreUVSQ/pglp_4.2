package uvsq;

import java.util.Stack;

public class CommandeRetourner implements Commande {

  private MoteurRpn moteurRPN;

  private Stack<Integer> ret;

  public CommandeRetourner(MoteurRpn moteur) {

    this.moteurRPN = moteur;
    this.ret = new Stack<Integer>();
  }

  public Stack<Integer> Retourner() {

    return ret;
  }

  @Override
  public void execute() {

    this.ret.addAll(this.moteurRPN.retourner());
    this.Retourner();
  }
}
