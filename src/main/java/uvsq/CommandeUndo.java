package uvsq;

import uvsq.inter.Interpreteur;

public class CommandeUndo implements Commande {

  private Interpreteur interpreteur;

  public CommandeUndo(Interpreteur inter) {
    this.interpreteur = inter;
  }

  @Override
  public void execute() {
    this.interpreteur.undo();
  }
}
