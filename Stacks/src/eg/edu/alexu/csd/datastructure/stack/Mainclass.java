package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
import java.lang.*;
public class Mainclass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("First -UI for Stacks Task");
		System.out.println("Second - UI for application");
		System.out.println("Enter the number of your Choosen UI : 1 for First , 2-For second ");
		int y=scan.nextInt();
		if(y==1)
		{
		int action=0;
		stack a=new stack();
		while(action!=6)
		{
		System.out.println("Please enter your Operation number : 1 push element , 2-pop element,3-The top Element, 4 Get size, 5- Check if empty -6 end");
		String x=new String();
		action=scan.nextInt();
		if(action==1)
		{
			x=scan.next();
			a.push(x);
			
		}
		else if(action==2)
		{
			System.out.println("Poped element:" +a.pop());
		}
		else if(action==3)
		{
			System.out.println("Top element: " +a.peek());
		}
		else if(action==4)
		{
			System.out.println("Size: "+a.size());
		}
		else if(action==5)
		{
			System.out.println("Check if empty: "+ a.isEmpty());
		}
		else
		{
			break;
		}
		
		}
		
		}
		else {
		Solve solve=new Solve();
		String s=new String();
		System.out.println("Second - UI for application");
		System.out.println("negative numbers in postfix will appear with a (-) before it");
		System.out.println("you should enter your expression in a form similar to: a + b - c");
	System.out.println("Enter your infix expression");
	s=scan.next();
	System.out.println("Your postfix expression:");
	System.out.println(solve.infixToPostfix(s));
	System.out.println("Evaluation of the expression");
	System.out.println(solve.evaluate(solve.infixToPostfix(s)));
		}
	}

}
