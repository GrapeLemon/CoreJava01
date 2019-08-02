package paging;

import java.util.ArrayList;
import java.util.List;

public class PageingDemo {
    public static void main(String[] args) {
        int total = 66;
        List<Integer> extensions = new ArrayList();
        for (int i = 0; i < total; i++) {
            extensions.add(i);
        }
        int divideCount = 10;           //一次多少个
        for (int i = 0; i < extensions.size(); i += divideCount) {
            List<Integer> subExtensions = new ArrayList<>();
            int nextIndex = i + divideCount;
            if(i + divideCount > extensions.size()) nextIndex = extensions.size();  //最后一组数据需特殊处理一下
            subExtensions = extensions.subList(i,nextIndex);
            System.out.println(subExtensions);
        }
    }
}
