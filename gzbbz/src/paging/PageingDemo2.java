package paging;

import java.util.ArrayList;
import java.util.List;

public class PageingDemo2 {
    public static void main(String[] args) {
        int total = 66;
        List<Integer> extensions = new ArrayList();
        int divideCount = 10;           //一次多少个

        for (int i = 0; i < total; i++) {
            List<Integer> tempExtensions = new ArrayList<>();
            for(int j = i; j < divideCount; j++){
                tempExtensions.add(j);
            }
            extensions.addAll(tempExtensions);
        }
        System.out.println(extensions);
    }
}
