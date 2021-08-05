package com.nowcoder.demo.service;

import com.nowcoder.demo.dao.UserDAO;
import com.nowcoder.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void addUser(User user) { userDAO.addUser(user);}

    public User getUser(String email) { return userDAO.selectByEmail(email);}

    public User getUser(int id) { return userDAO.selectById(id);}

    public User selectByName(String name) { return userDAO.selectByName(name);}

    public User selectByEmail(String email) { return userDAO.selectByEmail(email);}

    public void updatePassword(String email,String password) { userDAO.updatePassword(email,password);}

    public boolean containsUser(String email) {
        if(userDAO.containsUser(email) == null) return false;
        else return true;
    }

    public void updateisOnline(String email){
        userDAO.updateOnline(email);
    }

    public void updateDeline(String email){
        userDAO.updateDeline(email);
    }

    public User getOnlineUser(){
        return userDAO.isOnline();
    }

}
