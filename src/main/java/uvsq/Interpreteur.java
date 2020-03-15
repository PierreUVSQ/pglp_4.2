package uvsq;
import java.util.Stack;
public class Interpreteur {
	
	private Stack<Integer> pile;
	private Stack<Integer> pilePrecedente;
	
	public Interpreteur(Stack <Integer> pile) {
		this.pile = pile;
	}

	public void undo() {
		
		pile = pilePrecedente;
	
	}
	
	public void quit() {
		System.exit(0);
	}

}
