package com.ga.tc.authentication.dao;

import com.ga.tc.authentication.dto.UserInfoDto;

import com.ga.tc.common.ConnectionFactory;
import com.ga.tc.common.DeCoder;
import com.ga.tc.common.GenericDto;

import com.ga.tc.common.Queries;
import com.ga.tc.security.dto.RoleInfoDto;
import java.util.ArrayList;

import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        super();
    }

    @Override
    public Integer save(UserInfoDto user) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSERT_NEW_USER);
            //INSERT INTO TC_USER (USR_FULL_NAME,USR_EMAIL,USR_PASSWORD,USR_PHONE,USR_ADDRESS) VALUES(?,?,?,?,?)
            jdbcRs.setString(1, user.getFullName());
            jdbcRs.setString(2, user.getEmail().toLowerCase());
            jdbcRs.setString(3, new DeCoder().encode(user.getPassword()));
            jdbcRs.setString(4, user.getPhone());
            jdbcRs.setString(5, user.getAddress());
            jdbcRs.setString(6, user.getLaf());
            jdbcRs.setInt(7, user.getRole().getId());
            jdbcRs.execute();
            return 1;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public boolean delete(Integer userId) {
        // TODO Implement this method
        return false;
    }

    @Override
    public UserInfoDto search(Object key, Integer type) {
        // TODO Implement this method
        return null;
    }
    /**
     * * 0 returns inactive users
     * 1 returns active users
     * 2 returns all users
     * @param active
     * @return 
     */
    @Override
    public List<UserInfoDto> listAll(Integer active) {
        List<UserInfoDto> users = new ArrayList<>();
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            switch(active){
                case 0:
                    jdbcRs.setCommand(Queries.LIST_ALL_USERS_ACTIVE);
                    jdbcRs.setInt(1, 0);
                    break;
                case 1:
                    jdbcRs.setCommand(Queries.LIST_ALL_USERS_ACTIVE);
                    jdbcRs.setInt(1, 1);
                    break;
                case 2:
                    jdbcRs.setCommand(Queries.LIST_ALL_USERS);
                    break;
                default:
                    return users;
            }
            
            jdbcRs.execute();
            UserInfoDto userInfo =null;
            while(jdbcRs.next()){
                userInfo = new UserInfoDto();
                userInfo.setId(jdbcRs.getInt(1));
                userInfo.setFullName(jdbcRs.getString(2));
                userInfo.setEmail(jdbcRs.getString(3));
                userInfo.setPassword(jdbcRs.getString(4));
                userInfo.setPhone(jdbcRs.getString(5));
                userInfo.setAddress(jdbcRs.getString(6));
                userInfo.setRole(new RoleInfoDto(jdbcRs.getInt(7)));
//                userInfo.setLaf(jdbcRs.getString(6));
                users.add(userInfo);
            }
            
        }catch(Exception e){
           e.printStackTrace();     
        }
        return users;
    }

    @Override
    public UserInfoDto authenticateUser(String email, String password) {
        UserInfoDto userInfo = null;
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.AUTHENTICATE_USER);
            jdbcRs.setString(1, email.toLowerCase());
            jdbcRs.setString(2, new DeCoder().encode(password));
            jdbcRs.execute();
            while(jdbcRs.next()){
                if(userInfo == null)
                       userInfo = new UserInfoDto();
                userInfo.setId(jdbcRs.getInt(1));
                userInfo.setFullName(jdbcRs.getString(2));
                userInfo.setPhone(jdbcRs.getString(3));
                userInfo.setAddress(jdbcRs.getString(4));
                userInfo.setRole(new RoleInfoDto(jdbcRs.getInt(5)));
                userInfo.setLaf(jdbcRs.getString(6));
            }
            if(userInfo != null){
                //load accessible screens 
                jdbcRs.setCommand(Queries.USER_ACCESSIBLE_SCREENS);
                jdbcRs.setInt(1, userInfo.getId());
                jdbcRs.execute();
                while(jdbcRs.next()){
                    if(userInfo.getAccessibleScreens() == null)
                           userInfo.setAccessibleScreens(new ArrayList<>());
                     userInfo.getAccessibleScreens().add(new GenericDto(jdbcRs.getString(1),
                             jdbcRs.getInt(2)==1, jdbcRs.getInt(3)==1));
                }
            }
        }catch(Exception e){
           e.printStackTrace();     
        }
        return userInfo;
    }

    @Override
    public List<UserInfoDto> listAllInstructors() {
        List<UserInfoDto> users = new ArrayList<>();
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_INSTRUCTORS_ACTIVE);
            jdbcRs.execute();
            UserInfoDto userInfo =null;
            while(jdbcRs.next()){
                userInfo = new UserInfoDto();
                userInfo.setId(jdbcRs.getInt(1));
                userInfo.setFullName(jdbcRs.getString(2));
                userInfo.setEmail(jdbcRs.getString(3));
                userInfo.setPassword(jdbcRs.getString(4));
                userInfo.setPhone(jdbcRs.getString(5));
                userInfo.setAddress(jdbcRs.getString(6));
                userInfo.setRole(new RoleInfoDto(jdbcRs.getInt(7)));
                users.add(userInfo);
            }
            
        }catch(Exception e){
           e.printStackTrace();     
        }
        return users;
    }

    @Override
    public Boolean changePassword(String email, String password) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.CHANGE_USER_PASSWORD);
            //INSERT INTO TC_USER (USR_FULL_NAME,USR_EMAIL,USR_PASSWORD,USR_PHONE,USR_ADDRESS) VALUES(?,?,?,?,?)
            jdbcRs.setString(1, new DeCoder().encode(password));
            jdbcRs.setString(2, email.toLowerCase());
            jdbcRs.execute();
            return true;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return false;
    }

    @Override
    public List<UserInfoDto> listAllStudents() {
        List<UserInfoDto> users = new ArrayList<>();
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_STUDENTS);
            
            jdbcRs.execute();
            UserInfoDto userInfo =null;
            while(jdbcRs.next()){
                userInfo = new UserInfoDto();
                userInfo.setId(jdbcRs.getInt(1));
                userInfo.setFullName(jdbcRs.getString(2));
                userInfo.setEmail(jdbcRs.getString(3));
                userInfo.setPhone(jdbcRs.getString(4));
                userInfo.setAddress(jdbcRs.getString(5));
                users.add(userInfo);
            }
            
        }catch(Exception e){
           e.printStackTrace();     
        }
        return users;
    }

    @Override
    public boolean updateUserProfile(UserInfoDto info) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_USER_PROFILE);
            //INSERT INTO TC_USER (USR_FULL_NAME,USR_EMAIL,USR_PASSWORD,USR_PHONE,USR_ADDRESS) VALUES(?,?,?,?,?)
            jdbcRs.setString(1, info.getFullName());
            jdbcRs.setString(2, info.getEmail().toLowerCase());
            jdbcRs.setString(3, info.getPhone());
            jdbcRs.setString(4, info.getAddress());
            jdbcRs.setString(5, info.getLaf());
            jdbcRs.setInt(6, info.getId());
            jdbcRs.execute();
            return true;
        }catch(Exception e){
           e.printStackTrace();     
           return false;
        }
       
    }
}
