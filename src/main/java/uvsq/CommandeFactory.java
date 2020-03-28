package uvsq;

import java.util.HashMap;
import java.util.Map;

public class CommandeFactory {

  private final Map<String, Commande> commandes;
  private MoteurRpn moteur;

  CommandeFactory() {

    this.commandes = new HashMap<>();
  }

  public void addCommande(String nom, Commande commande) {

    this.commandes.put(nom, commande);
  }

  public void executeCommande(String name) {
    if (this.commandes.containsKey(name)) {
      this.commandes.get(name).execute();
      System.out.println(this.moteur.retourner());
    }
  }

  public void setOperation(Operation op) {
    CommandeApplication test;
    if (this.commandes.containsKey("Application")) {
      test = (CommandeApplication) this.commandes.get("Application");
      test.setOperation(op);
    }
  }

  public void setValeur(Integer val) {

    CommandeEnregistrer test;
    if (this.commandes.containsKey("Enregistrer")) {
      test = (CommandeEnregistrer) this.commandes.get("Enregistrer");
      test.setValeur(val);
    }
  }

  public void init(MoteurRpn moteur) {
    this.moteur = moteur;
    this.addCommande("exit", new CommandeQuit(moteur));
    this.addCommande("undo", new CommandeUndo(moteur));
    this.addCommande("Application", new CommandeApplication(moteur, Operation.PLUS));
    this.addCommande("Enregistrer", new CommandeEnregistrer(moteur, 0));
    this.addCommande("Retourner", new CommandeRetourner(moteur));
  }
}
