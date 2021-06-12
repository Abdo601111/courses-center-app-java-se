/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.security.bao;

import com.ga.tc.common.exception.TCException;
import com.ga.tc.security.dao.SecurityDao;
import com.ga.tc.security.dao.SecurityDaoImpl;
import com.ga.tc.security.dto.RoleInfoDto;
import com.ga.tc.security.dto.ScreenDto;
import java.util.List;

/**
 *
 * @author pc
 */
public class SecurityBaoImpl implements SecurityBao{
    private SecurityDao database = new SecurityDaoImpl();
    @Override
    public Integer save(RoleInfoDto role) throws TCException{
        if(role.getId() != null)
            return database.update(role);
        return database.save(role);
    }

    @Override
    public boolean delete(Integer roleId) {
        return  database.delete(roleId);
    }

    @Override
    public RoleInfoDto search(Object key, Integer type) {
        return database.search(key, type);
    }

    @Override
    public List<RoleInfoDto> listAll(Integer active) {
        return database.listAll(active);
    }

    @Override
    public int save(ScreenDto screen)  throws TCException{
        if(screen.getId() == -1)
            return database.save(screen);
        else
            return database.update(screen);
    }

    @Override
    public List<ScreenDto> listAllScreens(Integer active) {
        return database.listAllScreens(active);
    }

    @Override
    public boolean deleteScr(String scrCode) {
        return database.deleteScr(scrCode);
    }

    @Override
    public boolean updateRolePermissions(Integer roleId, List<ScreenDto> screens) {
        return database.updateRolePermissions(roleId, screens);
    }
    
}
