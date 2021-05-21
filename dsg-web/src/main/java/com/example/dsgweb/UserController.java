package com.example.dsgweb;

import com.example.dsgbase.model.Message;
import com.example.dsgdao.User;
import com.example.dsgservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.addOne(user);
        return Message.RETURN_MESSAGE;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.findAll();
    }
}
