package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
import java.lang.*;
public class Mainclass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Solve solve=new Solve();
		String s=new String();
		System.out.println("negative numbers in postfix will appear with a (-) before it");
		System.out.println("you should enter your expression in a form similar to: a + b - c");
	System.out.println("Enter your infix expression");
	s=scan.nextLine();
	System.out.println("Your postfix expression:");
	System.out.println(solve.infixToPostfix(s));
	System.out.println("Evaluation of the expression");
	System.out.println(solve.evaluate(solve.infixToPostfix(s)));
	}

}
