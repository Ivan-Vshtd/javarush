package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by user on 29.07.2016.
 */
public class MainModel implements Model
{  private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    @Override
    public void loadUsers()
    {  modelData.setDisplayDeletedUserList(false);
        //Достань всех пользователей между 1 и 100 уровнями
        //Положи всех пользователей в modelData
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 100)));

    }

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }
    private List<User> getActiveUsers(List<User> userList){
        return userService.filterOnlyActiveUsers(userList);
    }

    @Override
    public void loadDeletedUsers()
    {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deletedUserbyId(long id)
    {
        userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1,100)));
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name,id,level);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 100)));
    }
}