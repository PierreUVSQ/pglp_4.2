package uvsq;

public class Commande_undo implements Commande {

	private Interpreteur interpreteur;

	public Commande_undo(Interpreteur inter) {
		this.interpreteur = inter;
	}
	
	@Override
	public void execute() {
		this.interpreteur.undo();
		
	}
	
	
	
	
}
