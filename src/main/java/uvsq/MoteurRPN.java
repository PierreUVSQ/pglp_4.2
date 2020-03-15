package uvsq;
import java.util.Stack;

public class MoteurRPN extends Interpreteur {

    private Integer tailleMax=100;
    private final static Integer MAX_VALUE=100000;
    private final static Integer MIN_VALUE=0;

    public MoteurRPN(){
    	super();	

    }

    public void Enregistrer(Integer op) throws OutOfBoundsException {
        Integer s=pile.size();
        if(s == tailleMax) {}
        else {

            if(Math.abs(op)>=MIN_VALUE && Math.abs(op) <=MAX_VALUE) {
                pile.add(s, op);
                Return();
            }
            else throw new OutOfBoundsException();
        }

    }


    public void Application(Operation operation) throws DivisionZeroException, OutOfBoundsException {


        Integer i= 0;
          if(pile.size()>1) {
              i = operation.eval(pile.pop(), pile.pop());

              if(Math.abs(i)<MIN_VALUE || Math.abs(i)>MAX_VALUE) throw new OutOfBoundsException();

          }
        pile.add(i);
        Return();

    }

    public Stack<Integer> Retourner(){


        return this.pile;
    }

    public void Return(){

        String expression =new String();
        for(Integer e: pile){
            expression += e;
            expression += " ";

        }
        System.out.println(expression);

    }
    public Integer Size(){

        return this.pile.size();

    }
	
	
	
}
