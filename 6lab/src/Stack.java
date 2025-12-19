public class Stack<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if(size == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[size++] = element;
    }

    public T pop() {
        if(size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = data[--size];
        data[size] = null; // Clear reference
        return value;
    }

    public T peek() {
        if(size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}