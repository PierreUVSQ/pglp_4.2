package uvsq;

import java.util.Stack;

public class Commande_Application implements Commande{

	private MoteurRPN moteurRPN;
	private Operation operation;
	
	public Commande_Application(MoteurRPN moteur, Operation operation) {
		this.moteurRPN = moteur;
		this.operation = operation;
	}
	
	public void setOperation(Operation operation) {
		this.operation = operation;
		
	}
	
	
	@Override
	public void execute() {

		 Integer i = 0;
         if(this.moteurRPN.pile.size() > 1) {
             try {
            	this.moteurRPN.pilePrecedente = (Stack<Integer>) this.moteurRPN.pile.clone();
             	i = operation.eval(this.moteurRPN.pile.pop(), this.moteurRPN.pile.pop());
             }
             catch(DivisionZeroException e) {
            	 
             }
         }
         this.moteurRPN.pile.push(i);
		
		
	}
	
	
}
