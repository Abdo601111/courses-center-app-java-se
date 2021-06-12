package com.ga.tc.authentication.bao;

import com.ga.tc.authentication.dao.UserDao;
import com.ga.tc.authentication.dao.UserDaoImpl;
import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.Constants;

import java.util.List;

public class UserBaoImpl implements UserBao{
    private UserDao data = new UserDaoImpl();
    public UserBaoImpl() {
        super();
    }

    @Override
    public Integer save(UserInfoDto user) {
        try{
            if(user.getPassword() == null){
                user.setPassword(Constants.DEFAULT_PASSWORD);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return data.save(user);
    }

    @Override
    public boolean delete(Integer userId) {
        // TODO Implement this method
        return data.delete(userId);
    }

    @Override
    public UserInfoDto search(Object key, Integer type) {
        // TODO Implement this method
        return data.search(key, type);
    }

    @Override
    public List<UserInfoDto> listAll(Integer active) {
        // TODO Implement this method
        return data.listAll(active);
    }

    @Override
    public UserInfoDto authenticateUser(String email, String password) {
        // TODO Implement this method
        return data.authenticateUser(email, password);
    }

    public void setData(UserDao data) {
        this.data = data;
    }

    public UserDao getData() {
        return data;
    }

    public List<UserInfoDto> listAllInstructors() {
        return data.listAllInstructors();
    }

    @Override
    public Boolean changePassword(String email, String password) {
        return data.changePassword(email, password);
    }

    @Override
    public List<UserInfoDto> listAllStudents() {
        return data.listAllStudents();
    }

    @Override
    public boolean updateUserProfile(UserInfoDto info) {
        return data.updateUserProfile(info);
    }
}
