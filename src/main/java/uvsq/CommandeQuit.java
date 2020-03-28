package uvsq;

public class CommandeQuit implements Commande {

  private Interpreteur interpreteur;

  public CommandeQuit(Interpreteur inter) {
    this.interpreteur = inter;
  }

  @Override
  public void execute() {
    this.interpreteur.quit();
  }
}
