package cholog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @GetMapping("/hello")
    // extracts query parameter name from url
    // /hello?name="zin" -> name = "zin"
    // /hello -> name = ""
    // Model model : like a data bag that sends data to view(template file)
    public String world(@RequestParam(name="name",required = false,defaultValue = "")String name, Model model) {
        // TODO: /hello 요청 시 resources/templates/static.html 페이지가 응답할 수 있도록 설정하세요.
        // TODO: 쿼리 파라미터로 name 요청이 들어왔을 때 해당 값을 hello.html에서 사용할 수 있도록 하세요.
        // add key("name") value(name) pair to model so that template file can access it using: <p>Hello, [[${name}]]!</p>
        model.addAttribute("name",name);
        // render hello.html template
        return "hello";
    }

    @GetMapping("/json")
    // return value will be sent directly to http response body not used to find a view(template)
    @ResponseBody
    public Person json() {
        // TODO: /json 요청 시 {"name": "brown", "age": 20} 데이터를 응답할 수 있도록 설정하세요.
        // new Person("brown", 20) is converted to -> {"name": "brown", "age": 20}
        return new Person("brown", 20);
    }
}
