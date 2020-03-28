package uvsq;

import java.util.Scanner;

public class SaisieRpn {

  private MoteurRpn moteur;
  private Scanner scanner;

  public SaisieRpn(MoteurRpn moteur) {

    this.moteur = moteur;
    this.scanner = new Scanner(System.in, "UTF-8");
  }

  public void getInput() {

    String in;
    in = this.scanner.next();
    if (in.matches("\\p{Digit}+")) {
      this.moteur.enregistrer(Integer.parseInt(in));
    } else if (in.length() == 1 && Operation.isOperation(in.charAt(0))) {
      this.moteur.application(Operation.valueOf(in.charAt(0)));
    } else {
      this.moteur.elseExec(in);
    }
  }
}
