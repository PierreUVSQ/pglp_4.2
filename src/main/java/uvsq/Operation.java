package uvsq;

public enum Operation {



    PLUS('+'){

        public int eval(int op1, int op2){

            return op1 + op2;


        }

    },
    MOINS('-'){

        public int eval (int op1, int op2){
            return op1 - op2;

        }

    },

    MULT('*'){

        public int eval (int op1, int op2){

            return op1 * op2;

        }

    },
    DIV('/'){

        public int eval (int op1, int op2) throws DivisionZeroException {
            if(op1 == 0) throw new DivisionZeroException();
            else return op2 / op1;

        }

    };


    private char symbole;

    Operation(char symbole){

        this.symbole= symbole;


    }

    public abstract int eval(int op1, int op2) throws DivisionZeroException;

}