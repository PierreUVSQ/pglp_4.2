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
    
    public char getSymbole() {
    	return this.symbole;
    }
    Operation(char symbole){

        this.symbole= symbole;


    }

    public abstract int eval(int op1, int op2) throws DivisionZeroException, IllegalArgumentException;
    
    public static Operation valueOf(char in) {
    	char oper;	
    	for(Operation val: values()) {
    		
    		oper = val.getSymbole();
    		if(in == oper) {
    			
    			return val;
    			
    		}	
    	
    	}
    	throw new IllegalArgumentException();
    }
}