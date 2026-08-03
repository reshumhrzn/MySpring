package io.herald.myspringweb.RController;

import io.herald.myspringweb.Model.UserTable;
import io.herald.myspringweb.Repository.ImageRepository;
import io.herald.myspringweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RControllerClass {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/api/getAllUsers")
    public List<UserTable> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/api/saveUser")
    public String saveUser(@RequestBody UserTable user){
        //@RequestBody -> JSON ma data aako cha bhane requestbody lekhnu parxa

        userRepository.save(user);
        return "Saved Successfully";
    }
}
