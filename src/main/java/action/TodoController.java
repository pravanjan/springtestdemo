package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoHelper helper;

    @RequestMapping(value="/createtask/{type}/", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> createTask (HttpServletResponse request, HttpServletResponse response,  @PathVariable String type){
    return helper.createTask(type);

 }

}
