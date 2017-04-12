package net.proselyte.usermanager.service;

import net.proselyte.usermanager.dao.UserDao;
import net.proselyte.usermanager.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }


    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }


    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }


    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }


    @Transactional
    public List<User> listUsers(String name) {
        List<User> listUsers = this.userDao.listUsers();
        List<User> list = new ArrayList<User>();
        if(name==null||name.trim().equals(""))
            return listUsers;
        else {
            for(User user: listUsers) {
                if(name.toLowerCase().trim().equals(user.getName().toLowerCase())) {
                    list.add(user);
                }
            }
            return list;
        }
    }
}
