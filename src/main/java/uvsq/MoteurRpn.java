package uvsq;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class MoteurRpn extends Interpreteur {

  private CommandeFactory com;
  private int valeur;

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

  public Collection<Integer> retournerPrecedent() {

    return Collections.unmodifiableCollection(this.pilePrecedente);
  }


  public void returning() {

    String expression = new String();
    for (Integer e : pile) {
      expression += e;
      expression += " ";
    }
    System.out.println(expression);
  }

  public void setPilePrecedente(Stack<Integer> nv) {

    this.pilePrecedente = nv;
  }


  public void ajoutValeur(int val){

    this.pile.push(val);

  }

  public void elseExec(String in) {
    this.com.executeCommande(in);
  }

  public int pop() {

    return this.pile.pop();
  }

}
