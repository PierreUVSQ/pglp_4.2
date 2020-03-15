package uvsq;

public class Commande_Enregistrer implements Commande{

	
	private MoteurRPN moteurRPN;
	private Integer value;
	
	public Commande_Enregistrer(MoteurRPN moteur, Integer value) {
		this.moteurRPN = moteur;
		this.value = value;
	}
	
	@Override
	public void execute() {
		
		this.moteurRPN.pile.push(value);
		
	}
	
	public void setValeur(Integer val) {
		this.value = val;
	}

}
