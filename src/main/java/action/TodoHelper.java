package action;

import java.util.HashMap;
import java.util.Map;

public class TodoHelper {

    public Map<String,Object> createTask (String type){
        Map<String,Object> paramMap = new HashMap<>();
        System.out.println("comming inside *** ");
        paramMap.put("status",true);
        paramMap.put("type",type);
        return paramMap;
    }
}
