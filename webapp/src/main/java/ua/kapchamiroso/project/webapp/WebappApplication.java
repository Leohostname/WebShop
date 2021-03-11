package ua.kapchamiroso.project.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class WebappApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebappApplication.class, args);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello()
    {
        return "Du hast";
    }

    @GetMapping("/mainPage")
    public String mainPage()
    {
        return "index";
    }
}
