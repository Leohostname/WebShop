package ua.kapchamiroso.project.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/helo")
    public String test() {
        return "jsTest";
    }

    @ResponseBody
    @GetMapping("/test")
    public Message getMessage(@RequestParam long id) {
        return messageRepository.findById(id).orElseGet(() -> { throw new RuntimeException("no message"); });
    }

    @ResponseBody
    @PostMapping(value = "/test", consumes = "application/json")
    public String saveMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return "saved successfully";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody UserData info, HttpServletResponse response) {
        if (info.getLogin() != null) {
            String login = info.getLogin();
            System.out.println(login);
            Cookie cookie = new Cookie("username", login);
            response.addCookie(cookie);
            return "logged in";
        }
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "logged out";
    }

    @ResponseBody
    @GetMapping("/myLogin")
    public String myLogin(@CookieValue(value = "username", defaultValue = "") String username) {
        if (username.equals(""))
            return "you are not authorized!";
        return "hello, " + username;
    }
}
