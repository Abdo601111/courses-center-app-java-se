/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.security.dao;

import com.ga.tc.common.ConnectionFactory;
import com.ga.tc.common.Constants;
import com.ga.tc.common.Queries;
import com.ga.tc.common.exception.TCException;
import com.ga.tc.security.dto.RoleInfoDto;
import com.ga.tc.security.dto.ScreenDto;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author pc
 */
public class SecurityDaoImpl implements SecurityDao{

    @Override
    public Integer save(RoleInfoDto role) throws TCException{
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSERT_NEW_ROLE);
            jdbcRs.setString(1, role.getName());
            jdbcRs.setString(2, role.getDescription());
            
            jdbcRs.execute();
            return 1;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            TCException ex = new TCException();
            ex.setExactMessage("Role Name Already Exists!!!");
            throw ex;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public boolean delete(Integer roleId) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_ROLE);
            jdbcRs.setInt(1, roleId);
            jdbcRs.execute();
            return true;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return false;
    }

    @Override
    public RoleInfoDto search(Object key, Integer type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RoleInfoDto> listAll(Integer active) {
       List<RoleInfoDto> roles = null;
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
           jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            
            jdbcRs.setCommand(Queries.LIST_ALL_ROLES);
            jdbcRs.execute();
            RoleInfoDto role = null;
            while(jdbcRs.next()){
                if(roles == null)
                    roles = new ArrayList<>();
                role = new RoleInfoDto(jdbcRs.getInt(1), jdbcRs.getString(2), 
                        jdbcRs.getString(3), jdbcRs.getInt(4)==1?true:false);
                if(    active == Constants.STATUS_LIST_ALL 
                   ||  (active == Constants.STATUS_ACTIVE && role.isActive())
                   ||  (active == Constants.STATUS_INACTIVE && ! role.isActive() )
                  ){
                    roles.add(role);
                }
            }
       }catch(Exception e){
           e.printStackTrace();
       } 
       return roles; 
    }

    @Override
    public Integer update(RoleInfoDto role) throws TCException {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_ROLE);
            jdbcRs.setString(1, role.getName());
            jdbcRs.setString(2, role.getDescription());
            jdbcRs.setInt(3, role.isActive()? 1 : 0);
            jdbcRs.setInt(4, role.getId());
            
            jdbcRs.execute();
            return 1;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            TCException ex = new TCException();
            ex.setExactMessage("Role Name Already Exists!!!");
            throw ex;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public int save(ScreenDto screen) throws TCException{
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSERT_SCREEN);
            jdbcRs.setString(1, screen.getNameAr());
            jdbcRs.setString(2, screen.getNameEn());
            jdbcRs.setInt(3, screen.isActive()?1:0);
            jdbcRs.setString(4, screen.getCode());
            
            jdbcRs.execute();
            return 1;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            TCException ex = new TCException();
            ex.setExactMessage("Scrren Code Name Already Exists!!!");
            throw ex;
        }catch(Exception e){
            e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public List<ScreenDto> listAllScreens(Integer active) {
        List<ScreenDto> screens = null;
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
           jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            // ="SELECT ID, AR_NAME, EN_NAME, ACTIVE, CODE FROM TC_SCREEN";
            jdbcRs.setCommand(Queries.LIST_ALL_SCREENS);
            jdbcRs.execute();
            ScreenDto scr = null;
            while(jdbcRs.next()){
                if(screens == null)
                    screens = new ArrayList<>();
                scr = new ScreenDto(jdbcRs.getInt(1), jdbcRs.getString(5), 
                        jdbcRs.getString(2), jdbcRs.getString(3), jdbcRs.getInt(4)==1?true:false);
                if(    active == Constants.STATUS_LIST_ALL 
                   ||  (active == Constants.STATUS_ACTIVE && scr.isActive())
                   ||  (active == Constants.STATUS_INACTIVE && ! scr.isActive() )
                  ){
                    screens.add(scr);
                }
            }
       }catch(Exception e){
           e.printStackTrace();
       } 
       return screens; 
    }

    @Override
    public boolean deleteScr(String scrCode) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.DELETE_SCREEN);
            jdbcRs.setString(1, scrCode);
            jdbcRs.execute();
            return true;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return false;
    }

    @Override
    public int update(ScreenDto screen)  throws TCException{
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.UPDATE_SCREEN);
            //UPDATE TC_SCREEN SET AR_NAME = ?, EN_NAME = ?,ACTIVE  = ?, CODE    = ? WHERE ID    = ?
            jdbcRs.setString(1, screen.getNameAr());
            jdbcRs.setString(2, screen.getNameEn());
            jdbcRs.setInt(3, screen.isActive()? 1 : 0);
            jdbcRs.setString(4, screen.getCode());
            jdbcRs.setInt(5, screen.getId());
            
            jdbcRs.execute();
            return 1;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            TCException ex = new TCException();
            ex.setExactMessage("Code Name Already Exists!!!");
            throw ex;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public boolean updateRolePermissions(Integer roleId, List<ScreenDto> screens) {
         try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
          //  jdbcRs.setAutoCommit(false);
            
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.REVOK_PERMISSION);
            jdbcRs.setInt(1, roleId);
            jdbcRs.execute();
            // ROLE_ID,SCREEN_ID, VIEW_ONLY, FULL_CONTROL
            jdbcRs.setCommand(Queries.GRANT_ACCESS);
            for(ScreenDto screen : screens){
                jdbcRs.setInt(1, roleId);
                jdbcRs.setInt(2, screen.getId());
                jdbcRs.setInt(3, screen.isHasViewOnlyAccess()?1:0);
                jdbcRs.setInt(4, screen.isHasFullControlAccess()?1:0);
                jdbcRs.execute();
            }
            
            //jdbcRs.commit();
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
           e.printStackTrace();
        }catch(Exception e){
           e.printStackTrace();     
        }
        return false;
    }
    
}
