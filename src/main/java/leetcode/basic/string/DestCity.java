package leetcode.basic.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 旅行终点站
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class DestCity {

    public String destCity(List<List<String>> paths) {
        if (paths.size() == 1){
            return paths.get(0).get(1);
        }
        Map<String , String> pathMap = new HashMap<>();
        for (List<String> path : paths) {
            pathMap.put(path.get(0),path.get(1));
        }

        int l = 0;
        String destCity = null;
        for (Map.Entry<String, String> entry : pathMap.entrySet()) {
            String value = entry.getValue();
            int i = 0;
            while (pathMap.get(value) != null){
                value = pathMap.get(value);
                i++;
                if (i > l){
                    destCity = value;
                    l = i;
                }
            }
        }
        return destCity;
    }

}
