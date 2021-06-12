/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.security.dao;

import com.ga.tc.common.exception.TCException;
import com.ga.tc.security.dto.RoleInfoDto;
import com.ga.tc.security.dto.ScreenDto;
import java.util.List;

/**
 *
 * @author pc
 */
public interface SecurityDao {
    public Integer save(RoleInfoDto role) throws TCException;
   
    public Integer update(RoleInfoDto role) throws TCException;
    
    public boolean delete(Integer roleId);
   
    public RoleInfoDto search(Object key, Integer type);
    
    public List<RoleInfoDto> listAll(Integer active);

    public int save(ScreenDto screen)  throws TCException;

    public List<ScreenDto> listAllScreens(Integer active);

    public boolean deleteScr(String scrCode);

    public int update(ScreenDto screen)throws TCException;

    public boolean updateRolePermissions(Integer roleId, List<ScreenDto> screens);
}
