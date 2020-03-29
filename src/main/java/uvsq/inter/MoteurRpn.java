package uvsq.inter;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import uvsq.CommandeFactory;
import uvsq.Operation;

public class MoteurRpn extends Interpreteur {

  private CommandeFactory com;

  /** Constructeur du moteur. Il s'initialise ici avec les les commandes demandées. */
  public MoteurRpn() {
    super();
    this.com = new CommandeFactory();
    this.com.init(this);
  }

  /**
   * Permet d'enregistrer des opérandes en appelant la commande.
   *
   * @param op Opérande à ajouter
   */
  public void enregistrer(Integer op) {

    this.com.setValeur(op);
    this.com.executeCommande("Enregistrer");
  }

  /**
   * Effectue le calcul.
   *
   * @param operation Operation à effectuer
   */
  public void application(Operation operation) {

    this.com.setOperation(operation);
    this.com.executeCommande("Application");
  }

  public Collection<Integer> retourner() {

    return Collections.unmodifiableCollection(this.pile);
  }

  public void setPilePrecedente(Stack<Integer> nv) {

    this.pilePrecedente = nv;
  }

  public void ajoutValeur(int val) {

    this.pile.push(val);
  }

  public void elseExec(String in) {
    this.com.executeCommande(in);
  }

  public int pop() {

    return this.pile.pop();
  }
}
