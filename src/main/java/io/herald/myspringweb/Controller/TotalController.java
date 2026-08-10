package io.herald.myspringweb.Controller;


import io.herald.myspringweb.Model.UserTable;
import io.herald.myspringweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//Controller handles http requests (Get, Post, Put, Delete)
@Controller
public class TotalController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    //Autowired helps in dependancy injection, provides all the required
    //functions and APIs to a class/interface object no new keyword is required
    @Autowired
    private UserRepository uRepo;

    @GetMapping("/")
    public String firstPage(){
        return "index";
    }

    @GetMapping("/signup")
    public String signupGet(){
        return "signupPage";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "loginPage";
    }

    @PostMapping("/loginPost")
    public String loginPost(HttpServletRequest request, Model model) {
        String username, password;

        username = request.getParameter("username");
        password = request.getParameter("password");

        String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        //Repository login
        //if(uRepo.existsByUsernameAndPassword(username,hashPassword)){
        try {
            UserTable user = uRepo.findByUsername(username);
            if (user != null && passwordEncoder.matches(password, user.getPassword())) {

                List<UserTable> totalUsers = uRepo.findAll();
                model.addAttribute("totalUsers", totalUsers);

                HttpSession session = request.getSession();
                //Session revolves around the http requests, we are trying to get a running session with the above code
                session.setAttribute("username", username);

                //After a successful siginin, a username is provided a session acc to their username
                return "homePage";

            }
        } catch (Exception e) {
            //message lai model ko attribute bhanincha
            model.addAttribute("message", "Too many username");
        }
            return "loginPage";


    }
    @PostMapping("/signupPost")
    public String signupPost(HttpServletRequest request,Model model){

        String username, password;
        username = request.getParameter("username");
        password = request.getParameter("password");
        String email= request.getParameter("email");

        //md5- DigestUtils
        //String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());

        String hashPassword= passwordEncoder.encode(password);

        UserTable ut = new UserTable();
        ut.setUsername(username);
        ut.setPassword(hashPassword);

        uRepo.save(ut);

        //Mail Sender
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Signup Successful");
        mailMessage.setText("Welcome " +username+ "!");
        //mailSender.send(mailMessage);

        model.addAttribute("signupSuccess","You Have succesfully signed Up. Please login");
        return "loginPage";
    }

    @GetMapping("/home")
    public String homePage(Model m){
        m.addAttribute("totalUsers",uRepo.findAll());
        return "homePage";
    }

    //Model attribute is only for the upcoming page.
    //Request attribute is for the whole session.

}
