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
    
	MoteurRpn r;
	@Before
	public void init() {
    	this.r = new MoteurRpn();
    }

    @Test
    public void testMoteurRPN() {
    	
    	r.pile.push(5);
    	assertEquals(5, r.pile.pop(), 0);
    	
    	
    }
    
    @Test
    public void testEnregistrer() {
    	
    	CommandeEnregistrer c1 = new CommandeEnregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	assertEquals(4, r.pile.pop(), 0);
    	assertEquals(5, r.pile.pop(), 0);
    	
    	
    }
    
    @Test
    public void testApplication() {
    	
    	CommandeEnregistrer c1 = new CommandeEnregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	CommandeApplication c2 = new CommandeApplication(r, Operation.PLUS);
    	c2.execute();
    	assertEquals(9, r.pile.pop(), 0);
    }
    @Test
    public void testRetourner() {
    	CommandeEnregistrer c1 = new CommandeEnregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	CommandeRetourner c2 = new CommandeRetourner(r);
    	c2.execute();
    	Stack<Integer> tmp = c2.Retourner();
    	Stack<Integer> test = new Stack <Integer>();
    	test.push(5);
    	test.push(4);
    	assertEquals(test, tmp);
    	
    	
    }
    
    
    
    

}
