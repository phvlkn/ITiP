public class StackUsage {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Should print 30

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
    }
}