package uvsq;

import java.util.Scanner;

public class SaisieRPN {


    private MoteurRPN moteur;
    private Scanner scanner;
    private Commande_Factory com;
    public SaisieRPN(MoteurRPN moteur){

        this.moteur=moteur;
        this.scanner=new Scanner(System.in);
        this.com = new Commande_Factory();
        this.com.init(moteur);
    }

    public void getInput(){


            String in =new String();
            in=this.scanner.next();
            if (in.matches("\\p{Digit}+")) {
            	this.com.setValeur(Integer.parseInt(in));
            	this.com.executeCommande("Enregistrer");
            	
            }
            else if(in.length() == 1 && Operation.isOperation(in.charAt(0))) {
            	this.com.setOperation(Operation.valueOf(in.charAt(0)));
            	this.com.executeCommande("Application");
            }
            
            else {
            	this.com.executeCommande(in);
            }
            
            
            
            
            
            

    }

	
	
}
