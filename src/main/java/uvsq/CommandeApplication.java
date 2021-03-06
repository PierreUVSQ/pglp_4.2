package uvsq;

import java.util.Stack;
import uvsq.inter.MoteurRpn;

public class CommandeApplication implements Commande {

  private MoteurRpn moteurRpn;
  private Operation operation;

  public CommandeApplication(MoteurRpn moteur, Operation operation) {
    this.moteurRpn = moteur;
    this.operation = operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  @Override
  public void execute() { // Charger de faire le calcul

    Integer i = 0;
    if (this.moteurRpn.retourner().size() > 1) {
      Stack<Integer> test = new Stack<>();
      test.addAll(this.moteurRpn.retourner());
      this.moteurRpn.setPilePrecedente(test);
      try {

        i = operation.eval(this.moteurRpn.pop(), this.moteurRpn.pop());
        this.moteurRpn.ajoutValeur(i);
      } catch (DivisionZeroException e) {
        this.moteurRpn.undo();
        System.out.println("Impossible de diviser par zéro");
      }
    }
  }
}
