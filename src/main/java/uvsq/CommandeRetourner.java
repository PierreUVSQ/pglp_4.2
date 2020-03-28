package uvsq;

import java.util.Stack;

public class CommandeRetourner implements Commande {

  private MoteurRpn moteurRpn;

  private Stack<Integer> ret;

  public CommandeRetourner(MoteurRpn moteur) {

    this.moteurRpn = moteur;
    this.ret = new Stack<Integer>();
  }

  public Stack<Integer> retourner() {

    return ret;
  }

  @Override
  public void execute() {

    this.ret.addAll(this.moteurRpn.retourner());
    this.retourner();
  }
}
