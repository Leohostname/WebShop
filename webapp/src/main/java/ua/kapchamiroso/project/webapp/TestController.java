package ua.kapchamiroso.project.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
