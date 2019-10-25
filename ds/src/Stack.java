import java.util.ArrayList;

/**
 * @author wx-li
 * @date 2019/10/25-10:58
 **/
public class Stack<E> {
    private ArrayList<E> list = new ArrayList<>();

    // 往栈顶中添加一个元素
    public void push(E e) {
//        list.addFirst(e);
        list.add(e);
    }

    // 获取栈顶元素
    public E top() {
        return list.get(list.size() - 1);
    }

    // 获取栈顶元素并将该元素弹出栈
    public E pop() {
//        E first = list.getFirst();
//        list.removeFirst();
        E first = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return first;
    }
}
