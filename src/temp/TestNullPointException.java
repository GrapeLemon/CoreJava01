package temp;

/**
 * @author wx-li
 * @date 2019/10/18-14:39
 **/
public class TestNullPointException {
    public static void main(String[] args) throws Throwable{
        String s = null;
       // s.length();
        int[] array = null;
       // System.out.println(array.length);
        //System.out.println(array[0]);
        throw null;

    }
}
