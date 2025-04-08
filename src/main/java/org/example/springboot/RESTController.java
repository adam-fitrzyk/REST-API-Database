package org.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@RestController
public class RESTController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "hello") String query) {
        if (query.equals("hello")) {
            return "Hello from Spring Boot!";
        } else if (query.equals("goodbye")) {
            return "Goodbye from Spring Boot!";
        } else {
            return "What do you want?";
        }
    }

    @GetMapping("/users")
    public String getAllUsers() {
        // Return all users
        var response = new StringBuilder();
        for (User user : userRepository.findAll()) {
            response.append(user);
            response.append("<br>");
        }
        return response.toString();
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable() String id) {
        // Return user with given id
        Optional<User> response = userRepository.findById(id);
        System.out.println(response);
        if (response.isPresent()) {
            return response.get().toString();
        }
        return null;
    }

    @GetMapping("/users/search")
    public String getUserByFilter(@RequestParam(defaultValue = "{}") String filter) {
        // Return by filter given
        var response = new StringBuilder();
        return response.toString();
    }

    @GetMapping("/events")
    public String getAllEvents() {
        // Return all events
        var response = new StringBuilder();
        for (Event event : eventRepository.findAll()) {
            response.append(event);
            response.append("<br>");
        }
        return response.toString();
    }

    @GetMapping("/events/{id}")
    public String getEventById(@PathVariable String id) {
        // Return event with given id
        Optional<Event> response = eventRepository.findById(id);
        if (response.isPresent()) {
            return response.get().toString();
        }
        return null;
    }

    @GetMapping("/events/search")
    public String getEventByFilter(@RequestParam(defaultValue = "{}") String filter) {
        var response = new StringBuilder();
        return response.toString();
    }

}
