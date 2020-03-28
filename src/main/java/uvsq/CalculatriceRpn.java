package uvsq;

public enum CalculatriceRpn {
  CALC() {

    public void exec() {
      MoteurRpn m = new MoteurRpn();
      SaisieRpn s = new SaisieRpn(m);

      while (true) {

        s.getInput();
      }
    }
  };

  public abstract void exec() throws DivisionZeroException;

  public static void main(String [] args) throws DivisionZeroException {

    CalculatriceRpn test = CALC;
    test.exec();
  }
}
