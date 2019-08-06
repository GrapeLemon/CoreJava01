import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        String s = "{\"error\":0,\"status\":\"success\",\"results\":[{\"currentCity\":\"青岛\",\"index\":[{\"title\":\"穿衣\",\"zs\":\"较冷\",\"tipt\":\"穿衣指数\",\"des\":\"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。\"},{\"title\":\"紫外线强度\",\"zs\":\"最弱\",\"tipt\":\"紫外线强度指数\",\"des\":\"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。\"}],}]}";

        JSONObject jsonObject = JSON.parseObject(s);

        JSONArray result = jsonObject.getJSONArray("results");
        ResultVO resultVO= new ResultVO();
        for (int i = 0; i < result.size(); i++) {
            String currentCity = result.getJSONObject(i).getString("currentCity");
            resultVO.setCurrentCity(currentCity);
            //当字符串这样拿出来
            String jsonArrayString = result.getJSONObject(i).getString("index");
            //直接进行反序列化
            List<ResultVO.IndexVO> list = JSON.parseArray(jsonArrayString,ResultVO.IndexVO.class);
            resultVO.setIndexVOS(list);
        }
    }
}


