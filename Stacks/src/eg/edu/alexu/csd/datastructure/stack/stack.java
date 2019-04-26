package eg.edu.alexu.csd.datastructure.stack;

public class stack implements IStack {
	private linkedlist l=new linkedlist();
	@Override
	public Object pop() {
		if(l.isEmpty())
		{
			return null;
		}
		Object x=l.get(0); 
		l.remove(0);
		return x;
	}

	@Override
	public Object peek() {
		if(l.isEmpty())
		return null;
		
		return l.head.data;
	}

	@Override
	public void push(Object element) {
		l.add(0,element);
	}

	@Override
	public boolean isEmpty() {
		if(l.isEmpty())
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return l.size();
	}
	

}
