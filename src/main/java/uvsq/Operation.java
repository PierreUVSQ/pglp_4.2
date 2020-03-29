package uvsq;

public enum Operation {
  PLUS('+') {

    public int eval(int op1, int op2) {

      return op1 + op2;
    }
  },
  MOINS('-') {

    public int eval(int op1, int op2) {
      return op2 - op1;
    }
  },

  MULT('*') {

    public int eval(int op1, int op2) {

      return op1 * op2;
    }
  },
  DIV('/') {
    /**
     * Fonction qui effectue le calcul.
     *
     * @param op1 opérande 1
     * @param op2 opérande 2
     * @return resultat calcul
     * @throws DivisionZeroException Dans le cas où on divise pas zéro
     */
    public int eval(int op1, int op2) throws DivisionZeroException {
      if (op1 == 0) {
        throw new DivisionZeroException();
      } else {
        return op2 / op1;
      }
    }
  };

  private char symbole;

  public char getSymbole() {
    return this.symbole;
  }

  Operation(char symbole) {

    this.symbole = symbole;
  }

  public abstract int eval(int op1, int op2) throws DivisionZeroException, IllegalArgumentException;

  /**
   * Prend en paramètre un caractère et renvoie l'opération lui étant associé.
   *
   * @param in caractère
   * @return Operation
   */
  public static Operation valueOf(char in) {
    char oper;
    for (Operation val : values()) {

      oper = val.getSymbole();
      if (in == oper) {

        return val;
      }
    }
    throw new IllegalArgumentException();
  }

  /**
   * Vérifie que le caractère passé en argument est bien une opération.
   *
   * @param in caractère
   * @return boolean
   */
  public static boolean isOperation(char in) {
    for (Operation val : values()) {

      if (in == val.getSymbole()) {
        return true;
      }
    }

    return false;
  }
}
