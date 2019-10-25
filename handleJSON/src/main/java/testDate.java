import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

/**
 * @author wx-li
 * @date 2019/10/18-17:42
 **/
public class testDate {
    public static void main(String[] args) {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        Date date = new Date();
        String s = JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s);
    }
}
