package uvsq;

import java.util.Collections;
import java.util.Stack;

public class Commande_Retourner implements Commande{

	
	private MoteurRPN moteurRPN;

	private Stack<Integer> ret;
	
	public Commande_Retourner(MoteurRPN moteur) {
		this.moteurRPN = moteur;
	}
	
	public Stack<Integer> Retourner(){
		
		return ret;
	}
	
	
	@Override
	public void execute() {
			
		this.ret = this.moteurRPN.pile;
		this.Retourner();
		
		
	}
	
	
	
}
