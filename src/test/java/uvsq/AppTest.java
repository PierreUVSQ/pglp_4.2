package uvsq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    
    

}
