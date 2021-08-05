package com.nowcoder.demo.controllers;

import com.nowcoder.demo.model.User;
import com.nowcoder.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/users/register"}, method = {RequestMethod.GET})
    public String register() {
        return "login/register";
    }

    @RequestMapping(path={"/users/register/do"},method ={RequestMethod.POST})
    public String doRegister(
            Model model,
            HttpServletResponse responce,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        if(userService.containsUser(email)){
            model.addAttribute("error","该邮箱已被注册！");
            return "404";
        }
        else{
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userService.addUser(user);
            userService.updateisOnline(email);
            return "redirect:/index";
        }

    }

    @GetMapping(path = {"/users/login"})
    public String login(){ return "login/login";}

    @PostMapping(path = {"/users/login/do"})
    public String doLogin(
            Model model,
            HttpServletResponse responce,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        User user = userService.getUser(email);
        if(user.getPassword().equals(password)){
            if(userService.getOnlineUser()==null||userService.getOnlineUser().getEmail().equals(email)){
                userService.updateisOnline(email);
                return "redirect:/index";
            }
            else{
                model.addAttribute("error","当前在线人数过多！请稍后登录！");
                return "404";
            }
        }
        else {
            model.addAttribute("error","邮箱或密码错误");
            return "404";
        }

    }

    @GetMapping(path = {"/users/logout"})
    public String doLogout(){
        User curUser = userService.getOnlineUser();
        userService.updateDeline(curUser.getEmail());
        return "redirect:/users/login";
    }

}
