package uvsq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
import uvsq.inter.MoteurRpn;

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
    public void testCommandeEnregistrer() {
    	
    	CommandeEnregistrer c1 = new CommandeEnregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	assertEquals(4, r.pop(), 0);
    	assertEquals(5, r.pop(), 0);
    	
    	
    }
    
    @Test
    public void testApplication() {
    	
    	CommandeEnregistrer c1 = new CommandeEnregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	CommandeApplication c2 = new CommandeApplication(r, Operation.PLUS);
    	c2.execute();
    	assertEquals(9, r.pop(), 0);
    }
    @Test
    public void testRetourner() {
    	CommandeEnregistrer c1 = new CommandeEnregistrer(r, 5);
    	c1.execute();
    	c1.setValeur(4);
    	c1.execute();
    	CommandeRetourner c2 = new CommandeRetourner(r);
    	c2.execute();
    	Stack<Integer> tmp = new Stack<>();
    	tmp.addAll(c2.retourner());
    	Stack<Integer> test = new Stack <Integer>();
    	test.push(5);
    	test.push(4);
    	assertEquals(test, tmp);
    	
    	
    }


    @Test
	public void testAddition(){
		r.ajoutValeur(10);
		r.ajoutValeur(5);
		r.application(Operation.PLUS);
		Stack<Integer> test = new Stack<>();
		test.addAll(r.retourner());
		assertEquals(15, test.pop(), 0);
	}

	@Test
	public void testSoustraction(){
		r.ajoutValeur(10);
		r.ajoutValeur(5);
		r.application(Operation.MOINS);
		Stack<Integer> test = new Stack<>();
		test.addAll(r.retourner());
		assertEquals(5, test.pop(), 0);
	}

	@Test
	public void testMultiplication(){
		r.ajoutValeur(10);
		r.ajoutValeur(5);
		r.application(Operation.MULT);
		Stack<Integer> test = new Stack<>();
		test.addAll(r.retourner());
		assertEquals(50, test.pop(), 0);
	}

	@Test
	public void testDivision(){
		r.ajoutValeur(10);
		r.ajoutValeur(5);
		r.application(Operation.DIV);
		Stack<Integer> test = new Stack<>();
		test.addAll(r.retourner());
		assertEquals(2, test.pop(), 0);
	}

	@Test
	public void testEnregistrerMoteur(){
		r.ajoutValeur(10);
		r.ajoutValeur(5);
		Stack<Integer> test = new Stack<>();
		test.addAll(r.retourner());
		Stack<Integer> compare = new Stack<>();
		compare.push(10);
		compare.push(5);
		for(Integer i : test){
			assertEquals(compare.pop(), test.pop(), 0);
		}

	}


}
