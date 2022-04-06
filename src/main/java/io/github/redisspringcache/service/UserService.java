package io.github.redisspringcache.service;

import io.github.redisspringcache.model.User;
import io.github.redisspringcache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void save(User user){
        repository.save(user);
    }

    public User search(int id){
        Optional<User> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<User> listAll(){
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }
}
