package uvsq;

public class Commande_quit implements Commande{

	private Interpreteur interpreteur;
	
	public Commande_quit(Interpreteur inter)
	{
		this.interpreteur= inter;
		
	}

	@Override
	public void execute() {
		this.interpreteur.quit();
		
	}
	
	
	
}



