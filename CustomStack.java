package com.custom.impl.stack;

public class CustomStack<T> {

	private final int MAX_SIZE  =10;
	private T[] intArr = null;
	private int top;
	
	public CustomStack() {
	   this.intArr = (T[]) new Object[MAX_SIZE];
	   this.top = -1;
	}
	
	//Method to add element to the stack: Push
	protected void push(T element) {
		try {
			if (top == MAX_SIZE -1)
				throw new StackFullException();
			else
			{
				top++;
			    intArr[top] = element;	
			}
		}catch(Exception e) {
			exceptionHandler(e);
		}
		
	}
	
	//Method to get the element: Pop
	protected T pop() {
		T element = null;
		try {
			if (top == -1)
				throw new ArrayIndexOutOfBoundsException("empty");
			else {
				 element= intArr[top];
				 intArr[top] = null;
				 top -= 1;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
		    exceptionHandler(e);
		}

	    return element;
	}
	
	protected T peek() {
		T element = null;
		try {
			if (top == -1)
				throw new ArrayIndexOutOfBoundsException("stack is empty");
			else
				 element = intArr[top];
		}catch(ArrayIndexOutOfBoundsException e) {
			exceptionHandler(e);
		}
 
		 return element;
	}
	protected void exceptionHandler(Exception e) {
		if(e.getClass() == StackFullException.class)
			System.out.println("stack is full");
		if(e.getClass() == ArrayIndexOutOfBoundsException.class)
		    System.out.println("stack is empty");
	}
	
}
