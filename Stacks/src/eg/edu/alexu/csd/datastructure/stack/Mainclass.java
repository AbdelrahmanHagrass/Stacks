package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
import java.lang.*;
public class Mainclass {
	private static String extract(String s,int i)
	{
		String out=new String();
		if(s.charAt(i)=='-')
		{
			out+='-';
			i++;
		}
		
		while(s.charAt(i)>='0'&&s.charAt(i)<='9')
		{
			out+=s.charAt(i);
			i++;
			
		}
		out+=' ';
		return out;
	}
	private static int extractI(String s,int i)
	{
		int x=0;
		while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
		{
			x=x*10+(s.charAt(i)-'0');
			i++;
		}
	//	System.out.println(x);
		return x;
	}
	private static boolean compare(String operation,char c1,char c2)
	{
		int x=operation.charAt(operation.indexOf(c1)+1)-'0';
		int y=operation.charAt(operation.indexOf(c2)+1)-'0';
		if(x>y)
		{
			return true;
		}
		return false;
	}

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
