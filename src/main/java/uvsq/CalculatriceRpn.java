package uvsq;

import uvsq.inter.MoteurRpn;

public enum CalculatriceRpn {
  CALC() {

    /** Méthode lançant le programme la saisie. */
    public void exec() {
      MoteurRpn m = new MoteurRpn();
      SaisieRpn s = new SaisieRpn(m);

      while (true) {

        s.getInput();
      }
    }
  };

  public abstract void exec();

  /**
   * Programme principale.
   *
   * @param args Non pris en compte
   */
  public static void main(String[] args) {

    CalculatriceRpn test = CALC;
    test.exec();
  }
}
