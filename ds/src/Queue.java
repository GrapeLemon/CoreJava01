import java.util.ArrayList;

/**
 * @author wx-li
 * @date 2019/10/25-13:18
 **/
public class Queue<E> {
    private ArrayList<E> list = new ArrayList<>();

    // 入队
    public void in(E e) {
        list.add(e);
    }

    // 出队
    public E out() {
        E head = list.get(0);
        list.remove(0);
        return list.get(0);
    }

    // 获取队头元素
    public E head() {
        return list.get(0);
    }
}
