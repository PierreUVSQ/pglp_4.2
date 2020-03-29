package uvsq;

import uvsq.inter.Interpreteur;

public class CommandeQuit implements Commande {

  private Interpreteur interpreteur;

  public CommandeQuit(Interpreteur inter) {
    this.interpreteur = inter;
  }

  @Override
  public void execute() { // fait quitter le programme
    this.interpreteur.quit();
  }
}
