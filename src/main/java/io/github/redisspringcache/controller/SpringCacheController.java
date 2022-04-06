package io.github.redisspringcache.controller;

import io.github.redisspringcache.model.User;
import io.github.redisspringcache.response.Response;
import io.github.redisspringcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class SpringCacheController {

    @Autowired
    private UserService service;

    @PostMapping("/save")
    public Response save(@RequestBody User user) {
        service.save(user);
        return new Response("incluido", 200);
    }

    @GetMapping("/search")
    public User search(@RequestParam int id) {
        return service.search(id);
    }

    @DeleteMapping("/delete")
    public Response delte(@RequestParam int id) {
        service.delete(id);
        return new Response("deletado", 200);
    }

    @GetMapping("/listAll")
    public List<User> listAll() {
        return service.listAll();
    }
}