package uvsq;

import java.util.Collection;
import java.util.Stack;
import uvsq.inter.MoteurRpn;

public class CommandeRetourner implements Commande {

  private MoteurRpn moteurRpn;

  private Stack<Integer> ret;

  /**
   * Produit une commande retourner.
   *
   * @param moteur Moteur associée
   */
  public CommandeRetourner(MoteurRpn moteur) {

    this.moteurRpn = moteur;
    this.ret = new Stack<Integer>();
  }

  public Collection<Integer> retourner() {

    return this.moteurRpn.retourner();
  }

  @Override
  public void execute() {

    this.ret.addAll(this.moteurRpn.retourner());
    this.retourner();
  }
}
