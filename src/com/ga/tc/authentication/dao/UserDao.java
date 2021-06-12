package com.ga.tc.authentication.dao;

import com.ga.tc.authentication.dto.UserInfoDto;

import java.util.List;

public interface UserDao {
    /**
     *this method saves (insert / update) the user information and returns 
     * the old / newley generated ID
     * or -1 if the save failed.
     * @param user
     * @return
     */
    public Integer save(UserInfoDto user);
    /**
     * This method delete the user information from the DB
     * @param userId
     * @return true when deletion succeded or false otherwise.
     */
    public boolean delete(Integer userId);
    /**
     * this method takes key object which may be id, fullname, address
     * and also takes type 
     * [0]-->id
     * [1]-->fullName
     * [2]-->email
     * @param key
     * @param type
     * @return the user information object UserInfoDto
     */
    public UserInfoDto search(Object key, Integer type);
    /**
     * takes an integer parameter which indicates the list type 
     * 0 retuens inactive users
     * 1 returns active users
     * 2 returns all users
     * returns 
     * 
     * @param active
     * @return
     */
    public List<UserInfoDto> listAll(Integer active);
    /**
     * used for login purpose takes the email and password
     * returns null if the user information are fake
     * otherwise returns full user info.
     * @param email
     * @param password
     * @return UserInfoDto
     */
    public UserInfoDto authenticateUser(String email, String password);

    public List<UserInfoDto> listAllInstructors();

    public Boolean changePassword(String email, String password);
    
    public List<UserInfoDto> listAllStudents();

    public boolean updateUserProfile(UserInfoDto info);
}
