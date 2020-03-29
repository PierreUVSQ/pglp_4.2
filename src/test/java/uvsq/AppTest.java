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
    	Stack<Integer> tmp = new Stack<>();
    	tmp.addAll(c2.retourner());
    	Stack<Integer> test = new Stack <Integer>();
    	test.push(5);
    	test.push(4);
    	assertEquals(test, tmp);
    	
    	
    }


    @Test
	public void testAddition(){
		MoteurRpn moteurRpn = new MoteurRpn();
		moteurRpn.ajoutValeur(10);
		moteurRpn.ajoutValeur(5);
		moteurRpn.application(Operation.PLUS);
		Stack<Integer> test = new Stack<>();
		test.addAll(moteurRpn.retourner());
		assertEquals(15, test.pop(), 0);
	}

	@Test
	public void testSoustraction(){
		MoteurRpn moteurRpn = new MoteurRpn();
		moteurRpn.ajoutValeur(10);
		moteurRpn.ajoutValeur(5);
		moteurRpn.application(Operation.MOINS);
		Stack<Integer> test = new Stack<>();
		test.addAll(moteurRpn.retourner());
		assertEquals(5, test.pop(), 0);
	}

	@Test
	public void testMultiplication(){
		MoteurRpn moteurRpn = new MoteurRpn();
		moteurRpn.ajoutValeur(10);
		moteurRpn.ajoutValeur(5);
		moteurRpn.application(Operation.MULT);
		Stack<Integer> test = new Stack<>();
		test.addAll(moteurRpn.retourner());
		assertEquals(50, test.pop(), 0);
	}

	@Test
	public void testDivision(){
		MoteurRpn moteurRpn = new MoteurRpn();
		moteurRpn.ajoutValeur(10);
		moteurRpn.ajoutValeur(5);
		moteurRpn.application(Operation.DIV);
		Stack<Integer> test = new Stack<>();
		test.addAll(moteurRpn.retourner());
		assertEquals(2, test.pop(), 0);
	}

	@Test
	public void testEnregistrerMoteur(){
		MoteurRpn moteurRpn = new MoteurRpn();
		moteurRpn.ajoutValeur(10);
		moteurRpn.ajoutValeur(5);
		Stack<Integer> test = new Stack<>();
		test.addAll(moteurRpn.retourner());
		Stack<Integer> compare = new Stack<>();
		compare.push(10);
		compare.push(5);
		for(Integer i : test){
			assertEquals(compare.pop(), test.pop(), 0);
		}

	}


}
