package uvsq;

import java.util.Scanner;
import uvsq.inter.MoteurRpn;

public class SaisieRpn {

  private MoteurRpn moteur;
  private Scanner scanner;

  /**
   * Constructeur pour le moteur chargé d'exécuter les actions d'enregistrement des opérandes,
   * d'applications et de retour.
   *
   * @param moteur Moteur choisie
   */
  public SaisieRpn(MoteurRpn moteur) {

    this.moteur = moteur;
    this.scanner = new Scanner(System.in, "UTF-8");
  }

  /** Récupère les données entrées et les envoie au moteur pour être traitées. */
  public void getInput() {

    String in;
    in = this.scanner.next();
    if (in.matches("\\p{Digit}+")) {
      try {
        this.moteur.enregistrer(Integer.parseInt(in));
      } catch (NumberFormatException n) {
        System.out.println("Nombre trop grand");
      }

    } else if (in.length() == 1 && Operation.isOperation(in.charAt(0))) {
      this.moteur.application(Operation.valueOf(in.charAt(0)));
    } else {
      this.moteur.elseExec(in);
    }
  }
}
