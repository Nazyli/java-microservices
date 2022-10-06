package com.api.sample.controller;

import com.api.sample.dtos.UsersDto;
import com.api.sample.repositories.UsersRepository;
import com.api.sample.util.hash;
import com.api.sample.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public Map<String, Object> getUsres(Pageable pageable) {
        Map<String, Object> output = new HashMap<>();
        try {
            output.put("data", repository.findAll(pageable));
            output.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            output.put("success", false);
        }
        return output;
    }

    @PostMapping
    public Map<String, Object> addUsers(@RequestBody UsersDto req) {
        Map<String, Object> output = new HashMap<>();
        Users users = new Users();
        users.setUserName(req.getUserName());
        users.setUserPassword(hash.SHA_256.digestAsHex(req.getUserPassword()));
        users.setScope(req.getScope());
        users.setActives(req.isActives());
        try {
            users = repository.save(users);
            output.put("data", users);
            output.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            output.put("success", false);
        }
        return output;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateUsers(@PathVariable("id") String id, @RequestBody UsersDto req) {
        Map<String, Object> output = new HashMap<>();
        Users users = repository.findById(id).orElseThrow();
        users.setUserName(req.getUserName());
        users.setUserPassword(req.getUserPassword());
        users.setScope(req.getScope());
        users.setActives(req.isActives());
        try {
            users = repository.save(users);
            output.put("data", repository.save(users));
            output.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            output.put("success", false);
        }
        return output;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteUsers(@PathVariable("id") String id) {
        Map<String, Object> output = new HashMap<>();
        Users users = repository.findById(id).orElseThrow();
        try {
            repository.delete(users);
            output.put("data", users);
            output.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            output.put("success", false);
        }
        return output;
    }

}
