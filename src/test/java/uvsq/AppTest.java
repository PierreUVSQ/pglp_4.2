package uvsq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
	MoteurRPN r;
	@Before
	public void init() {
    	this.r = new MoteurRPN();
    }

    @Test
    public void testMoteurRPN() {
    	
    	r.pile.push(5);
    	assertEquals(5, r.pile.pop(), 0);
    	
    	
    }
    
    @Test
    public void testEnregistrer() {
    	
    	Commande_Enregistrer c1 = new Commande_Enregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	assertEquals(4, r.pile.pop(), 0);
    	assertEquals(5, r.pile.pop(), 0);
    	
    	
    }
    
    @Test
    public void testApplication() {
    	
    	Commande_Enregistrer c1 = new Commande_Enregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	Commande_Application c2 = new Commande_Application(r, Operation.PLUS);
    	c2.execute();
    	assertEquals(9, r.pile.pop(), 0);
    }
    @Test
    public void testRetourner() {
    	Commande_Enregistrer c1 = new Commande_Enregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	Commande_Retourner c2 = new Commande_Retourner(r);
    	c2.execute();
    	Stack<Integer> tmp = c2.Retourner();
    	Stack<Integer> test = new Stack <Integer>();
    	test.push(5);
    	test.push(4);
    	assertEquals(test, tmp);
    	
    	
    }
    
    
    
    

}
