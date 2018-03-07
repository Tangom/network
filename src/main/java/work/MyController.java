package work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    private final DAO dao;

    @Autowired
    public MyController(DAO dao) {
        this.dao = dao;
    }
    @RequestMapping(method = RequestMethod.GET,path = "/")
    public String  hello (ModelMap model) {

        MyBean bean = new MyBean();
        bean.setAllModel(dao.all());

        model.put("bean", bean);

        return "hello";
    }
    @RequestMapping(method = RequestMethod.POST ,path = "/registration")
    public String addModel(@RequestParam String login,
                         @RequestParam(name = "user-name")String name)throws Throwable{

        dao.createModel(login, name);
        return "hello";
    }

    }


