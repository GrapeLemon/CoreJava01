/**
 * @author wx-li
 * @date 2019/10/25-11:04
 **/
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("123");
        stack.push("456");
        stack.push("789");
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
