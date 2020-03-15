package uvsq;

import java.util.HashMap;
import java.util.Map;

public class Commande_Factory {

	private final Map <String, Commande>commandes;
	private MoteurRPN moteur;

	Commande_Factory() {
		
		this.commandes = new HashMap<>();
		
	}
	
	public void addCommande(String nom, Commande commande) {
		
		this.commandes.put(nom, commande);
		
	}
	
	public void executeCommande(String name) {
		if(this.commandes.containsKey(name)) {
			this.commandes.get(name).execute();
			System.out.println(this.moteur.pile.toString());
		}
	}
	
	public void setOperation(Operation op) {
		Commande_Application test;
		if(this.commandes.containsKey("Application")) {
			test =(Commande_Application) this.commandes.get("Application");
			test.setOperation(op);
		}	
	}
	
	
	public void setValeur(Integer val) {
		
		Commande_Enregistrer test;
		if(this.commandes.containsKey("Enregistrer")) {
			test =(Commande_Enregistrer) this.commandes.get("Enregistrer");
			test.setValeur(val);
		}
	}
	
	public void init(MoteurRPN moteur) { 
		this.moteur = moteur;
		this.addCommande("exit", new Commande_quit(moteur));
		this.addCommande("undo", new Commande_undo(moteur));
		this.addCommande("Application", new Commande_Application(moteur, Operation.PLUS));
		this.addCommande("Enregistrer", new Commande_Enregistrer(moteur, 0));
		this.addCommande("Retourner", new Commande_Retourner(moteur));
	}
	
	
}
