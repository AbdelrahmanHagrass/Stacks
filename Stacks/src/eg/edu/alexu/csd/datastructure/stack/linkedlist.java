package eg.edu.alexu.csd.datastructure.stack;
public class linkedlist {
	Node head;

	public void add(int index, Object element) {
		if (index > size()) {
			return;
		}
		if (index == 0) {
			if (head == null) {
				head = new Node(element);
				return;
			}
			Node headnew = new Node(element);
			headnew.next = head;
			head = headnew;
			return;
		}
		int i = 1;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		Node New = new Node(element);
		New.next = current.next;
		current.next = New;
		return;

	}

	
	public void show() {
		if(head==null)
			return;
		Node current = head;
		while (current != null) {
			System.out.print(current.data+" ");
			System.out.println();
			current = current.next;
		}
	}
	public void add(Object element) {
		if (head == null) {
			add(0, element);
			return;
		}
		add(size(),element);
	}

	
	public Object get(int index) {
		if (head == null || index > this.size() - 1) {
			return null;
		}
		int i = 0;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		return current.data;
	}

	
	public void set(int index, Object element) {
		if (index > size() - 1) {
			return;
		}
		Node current = head;
		if (index == 0) {
			head.data = element;
			return;
		}
		int i = 0;
		while (i < index) {
			current = current.next;
			i++;
		}
		current.data = element;

	}

	public void clear() {
		head = null;

	}


	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public void remove(int index) {
		if (index == 0) {
			head = head.next;
			return;
		}
		if (index > size() - 1) {
			return;
		}
		int i = 1;
		Node current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		current.next = current.next.next;
	}

	public int size() {
		Node current = head;
		int i = 0;
		while (current != null) {
			i++;
			current = current.next;
		}
		return i;
	}


}
