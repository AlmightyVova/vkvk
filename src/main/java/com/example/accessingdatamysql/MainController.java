package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private SingleService singleService;

    @PostMapping(path = "/add")
    public @ResponseBody
    JUser addNewUser(@RequestParam String name, @RequestParam String email) {
        return singleService.addUser(name, email);
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    JUser updateUser(@RequestParam int userId, @RequestParam String name, @RequestParam String email) {
        return singleService.updateJUser(userId, name, email);
    }

    @PostMapping(path = "/remove")
    public @ResponseBody
    void removeUser(@RequestParam int userId) {
        singleService.deleteJUser(userId);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<JUser> getAllUsers() {
        return singleService.getJUsers();
    }

    @GetMapping(path = "/single/{userId}")
    public @ResponseBody
    JUser getUser(@PathVariable int userId) {
        return singleService.getJUser(userId);
    }
}
