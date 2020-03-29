package uvsq;

import java.util.HashMap;
import java.util.Map;
import uvsq.inter.MoteurRpn;

public class CommandeFactory {

  private final Map<String, Commande> commandes;
  private MoteurRpn moteur;

  public CommandeFactory() {

    this.commandes = new HashMap<>();
  }

  public void addCommande(String nom, Commande commande) {

    this.commandes.put(nom, commande);
  }

  /**
   * Renvoie la commande associée à la chaine de caractère.
   *
   * @param name Chaine correspondant à la commande souhaitée
   */
  public void executeCommande(String name) {
    if (this.commandes.containsKey(name)) {
      this.commandes.get(name).execute();
      System.out.println(this.moteur.retourner());
    }
  }

  /**
   * Dans le cas où la commande est une application.
   * Associe une opération à utiliser.
   * @param op Opération à utiliser
   */
  public void setOperation(Operation op) {
    CommandeApplication test;
    if (this.commandes.containsKey("Application")) {
      test = (CommandeApplication) this.commandes.get("Application");
      test.setOperation(op);
    }
  }

  /**
   * Dans le cas où on utilise la commande enregistrer.
   * Permet de définir la valeur à ajouter.
   * @param val Valeur à ajouter
   */
  public void setValeur(Integer val) {

    CommandeEnregistrer test;
    if (this.commandes.containsKey("Enregistrer")) {
      test = (CommandeEnregistrer) this.commandes.get("Enregistrer");
      test.setValeur(val);
    }
  }

  /**
   * Ajoute les commandes à traiter et le moteur qui va intéragir.
   *
   * @param moteur Moteur utiliser pour les calculs
   */
  public void init(MoteurRpn moteur) {
    this.moteur = moteur;
    this.addCommande("exit", new CommandeQuit(moteur));
    this.addCommande("undo", new CommandeUndo(moteur));
    this.addCommande("Application", new CommandeApplication(moteur, Operation.PLUS));
    this.addCommande("Enregistrer", new CommandeEnregistrer(moteur, 0));
    this.addCommande("Retourner", new CommandeRetourner(moteur));
  }
}
