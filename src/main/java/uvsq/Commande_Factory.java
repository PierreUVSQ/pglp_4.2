package uvsq;

import java.util.HashMap;
import java.util.Map;

public class Commande_Factory {

	private final Map <String, Commande>commandes;
	
	private Commande_Factory() {
		
		this.commandes = new HashMap<>();
		
	}
	
	public void addCommande(String nom, Commande commande) {
		
		this.commandes.put(nom, commande);
		
	}
	
	public void executeCommande(String name) {
		this.commandes.get(name).execute();
	}
	
}
