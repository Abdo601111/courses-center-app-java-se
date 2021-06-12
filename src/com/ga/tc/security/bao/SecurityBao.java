package com.ga.tc.security.bao;

import com.ga.tc.common.exception.TCException;
import com.ga.tc.security.dto.RoleInfoDto;
import com.ga.tc.security.dto.ScreenDto;

import java.util.List;

public interface SecurityBao {
    
    /**
     * Role
     */
    public Integer save(RoleInfoDto role) throws TCException;
   
    public boolean delete(Integer roleId);
   
    public RoleInfoDto search(Object key, Integer type);
    
    public List<RoleInfoDto> listAll(Integer active);
    
    /**
     * Screen
     */
    public int save(ScreenDto screen)  throws TCException;
    public List<ScreenDto> listAllScreens(Integer active);
    public boolean deleteScr(String scrCode);
    
    /**
     * Role - Screen permission
     */
    public boolean updateRolePermissions(Integer roleId, List<ScreenDto> screens);
}
