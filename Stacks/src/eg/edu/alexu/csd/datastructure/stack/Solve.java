package eg.edu.alexu.csd.datastructure.stack;

public class Solve implements IExpressionEvaluator {

	private String extract(String s,int i)
	{
		String out=new String();
		while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
		{
			out+=s.charAt(i);
			i++;
		}
		out+=' ';
		return out;
	}
	private double extractI(String s,int i,int flag)
	{
		double x=0;
		int j=i;
		while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
		{
			x=x*10+(s.charAt(i)-'0');
			i++;
		}
		if(flag==-1)
		{
			x=-x;
		}
		//System.out.println(x);
		return x;
	}
	private boolean compare(String operation,char c1,char c2)
	{
		int x=operation.charAt(operation.indexOf(c1)+1)-'0';
		int y=operation.charAt(operation.indexOf(c2)+1)-'0';
		if(x>y)
		{
			return true;
		}
		return false;
	}
	private void spaces(String s)
	{
		String out=new String();
		for(int i=0;i<s.length();i++)
		{
			
		}
	}
	@Override
	public String infixToPostfix(String expression) {
		int i=0;
		stack s=new stack();
		String out=new String();
		String operation= "*2+1/2-1^3()";
		int flag=0;
		int f=0;
		char prev = 0;
		while(i<expression.length())
		{
			char c=expression.charAt(i);
			f=0;
			if(i==0)
				prev=c;
			if(c==' ')
			{
				i++;
				continue;
			}
			if(prev>='0'&&prev<='9')
				f=1;
		 if(c=='-'&& expression.charAt(i+1)>='0'&& expression.charAt(i+1)<='9'&&f!=1)
		 {
			
			
			out+="(-)";
			i++;
			c=expression.charAt(i);
		}
		 if(c>='0'&&c<='9')
		{
				out+=extract(expression,i);
				i+=extract(expression,i).length()-1;
				prev=c;
				continue;
		}
		if((c<'0'||c>'9')&& operation.indexOf(c)==-1)
		{
			System.out.println("Invalid input");
			throw new RuntimeException();
		}
		
			if(c=='(')
			{
				s.push(c);
				flag++;
			}
			else if(c==')')
			{
				if(s.isEmpty())
				{
					throw new RuntimeException();
				}
				while(!s.isEmpty()&&(char)s.peek()!='(')
				{
					out+=(char)s.pop();
					out+=' ';
				}			
				s.pop();
				flag--;
				
			}
			else if(s.isEmpty())
			{
				s.push(c);
			}
			else if(compare(operation, c,(char)s.peek()))
			{
				s.push(c);
			}
			else
			{
				while(!s.isEmpty()&&!compare(operation, c,(char)s.peek()))
				{
					out+=(char)s.pop();
					out+=' ';
				}
				s.push(c);
			}
			i++;
			prev=c;
		}
		if(flag!=0)
		{
			System.out.println("Invalid");
			throw new RuntimeException();
		}
		while(!s.isEmpty())
		{
			
			out+=(char)s.pop();
			out+=' ';
			
		}
		return out;
	}

	@Override
	public int evaluate(String expression)
	{
		stack s=new stack();
		for(int i=0;i<expression.length();i++)
		{
			int flag=1;
			
		if(expression.charAt(i)==' ')
		{
			continue;
		}
		char c=expression.charAt(i);
		if(c=='(')
		{
			i+=3;
			flag=-1;
			c=expression.charAt(i);
		}
		if(c>='0'&&c<='9')
		{
			s.push(extractI(expression,i,flag));
			
			i+=extract(expression,i).length()-1;
			continue;
		}
		if(s.isEmpty())
		{
			continue;
		}
		double x=(double)s.pop();
		double y=(double)s.pop();
		double z;
		if(c=='+')
		{
			z=x+y;
		}
		else if(c=='-')
		{
			z=y-x;
		}
		else if(c=='*')
		{
			z=x*y;
		}
		else if(c=='/')
		{
			z=y/x;
		}
		else
		{
			z=(double) Math.pow(y,x);
		}
		s.push(z);
	}
		double x=(double)s.peek();
		int a=(int)x;
		return a;
	}

}
