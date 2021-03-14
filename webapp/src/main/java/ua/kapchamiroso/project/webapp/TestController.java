package ua.kapchamiroso.project.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/helo")
    public String test() {
        return "Heloworld";
    }

    @GetMapping("/test")
    public Message getMessage(@RequestParam long id) {
        return messageRepository.findById(id).orElseGet(() -> { throw new RuntimeException("no message"); });
    }

    @PostMapping(value = "/test", consumes = "application/json")
    public void saveMessage(@RequestBody Message message) {
        messageRepository.save(message);
    }
}
