package uvsq;

import java.util.Stack;
import uvsq.inter.MoteurRpn;

public class CommandeEnregistrer implements Commande {

  private MoteurRpn moteurRpn;
  private Integer value;

  public CommandeEnregistrer(MoteurRpn moteur, Integer value) {
    this.moteurRpn = moteur;
    this.value = value;
  }

  @Override
  public void execute() { // Charger d'enregistrer les opérandes
    Stack<Integer> test = new Stack<>();
    test.addAll(this.moteurRpn.retourner());
    this.moteurRpn.setPilePrecedente(test);
    this.moteurRpn.ajoutValeur(value);
  }

  public void setValeur(Integer val) {
    this.value = val;
  }
}
