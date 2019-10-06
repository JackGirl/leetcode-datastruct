package src.com.zbxx.datastructure;

public class MyQueue {

	private Object[] elements;


	public MyQueue() {
		elements = new Object[0];
	}


	public Object add(Object data) {
		Object[] newArr = new Object[elements.length + 1];
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		newArr[newArr.length - 1] = data;
		elements = newArr;
		return data;
	}


	public Object poll() {
		Object[] newArr = new Object[elements.length - 1];
		for (int i = 1; i < elements.length; i++) {
			newArr[i - 1] = elements[i];
		}
		Object val = elements[0];
		elements = newArr;
		return val;
	}


	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.poll());
		for (int i = 0; i < queue.elements.length; i++) {
			System.out.print(queue.elements[i] + " ");
		}
	}
}
