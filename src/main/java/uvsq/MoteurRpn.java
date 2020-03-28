package uvsq;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class MoteurRpn extends Interpreteur {

  private CommandeFactory com;

  public MoteurRpn() {
    super();
    this.com = new CommandeFactory();
    this.com.init(this);
  }

  public void enregistrer(Integer op) {

    this.com.setValeur(op);
    this.com.executeCommande("Enregistrer");
  }

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
