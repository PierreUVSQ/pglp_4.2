package uvsq;

public enum CalculatriceRPN {

	 CALC(){

	      public void exec(){
	          MoteurRPN m= new MoteurRPN();
	          SaisieRPN s= new SaisieRPN(m);

	          while(true){


	                  s.getInput();
	            


	          }


	      }

	    };
	    public abstract void exec()throws DivisionZeroException;

	    public static void main(String args[]) throws DivisionZeroException {

	        CalculatriceRPN test = CALC;
	        test.exec();




	    }
	
	
	
}


