package datastructure;

class Stack extends Datastructure {
	private int top;

	public Stack(int capa) {
		super(capa);
		top = -1;
	}

	@Override
	public void create() {
		elements = new int[capacity];
		size = 0;
		top = -1;
	}

	@Override
	protected void insert(int element) {
		if (size == capacity) {
			resize();
		}
		elements[++top] = element;
		size++;
	}

	@Override
	protected void delete(int element) {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		top--;
		size--;
	}

	@Override
	public void display() {
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				System.out.println(elements[i]);
			}
		}
	}

	public void push(int element) {
		insert(element);
	}

	public void pop() {
		delete(top);
	}

	public int peek() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		return elements[top];
	}
}