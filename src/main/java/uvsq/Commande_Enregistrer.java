package uvsq;

import java.util.Stack;

public class Commande_Enregistrer implements Commande{

	
	private MoteurRPN moteurRPN;
	private Integer value;
	
	public Commande_Enregistrer(MoteurRPN moteur, Integer value) {
		this.moteurRPN = moteur;
		this.value = value;
	}
	
	@Override
	public void execute() {
		this.moteurRPN.pilePrecedente = (Stack<Integer>) this.moteurRPN.pile.clone();
		this.moteurRPN.pile.push(value);
		System.out.println("Pile precedente" +this.moteurRPN.pilePrecedente);
		System.out.println(("Pile nouvelle" + this.moteurRPN.pile));
	}
	
	public void setValeur(Integer val) {
		this.value = val;
	}

}
