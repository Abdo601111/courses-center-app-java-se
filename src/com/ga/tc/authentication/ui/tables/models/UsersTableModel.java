/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.authentication.ui.tables.models;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.security.dto.RoleInfoDto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class UsersTableModel extends AbstractTableModel{
    private String[] headers ={"User Id", "User Name","Email", "Password", "Phone", "Address", "Role"};
    private List<UserInfoDto> usersList = new ArrayList<>();
    public UsersTableModel(List<UserInfoDto> uL){
        this.usersList = uL;
    }
    @Override
    public int getRowCount() {
        return usersList.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retVal = null;
        try{
            switch(columnIndex){
            case 0:
                retVal =  usersList.get(rowIndex).getId();
                break;
            case 1:
                retVal =  usersList.get(rowIndex).getFullName();
                break;
            case 2:
                retVal =  usersList.get(rowIndex).getEmail();
                break;
            case 3:
                retVal =  usersList.get(rowIndex).getPassword();
                break;
            case 4:
                retVal =  usersList.get(rowIndex).getPhone();
                break;
            case 5:
                retVal =  usersList.get(rowIndex).getAddress();
                break;
            case 6:
                retVal =  (RoleInfoDto)usersList.get(rowIndex).getRole();
                break;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try{
            if(aValue != null)
                switch(columnIndex){
                    case 0:
                        usersList.get(rowIndex).setId(Integer.parseInt(aValue.toString()));
                        break;
                    case 1:
                        usersList.get(rowIndex).setFullName(aValue.toString());
                        break;
                    case 2:
                        usersList.get(rowIndex).setEmail(aValue.toString());
                        break;
                    case 3:
                        usersList.get(rowIndex).setPassword(aValue.toString());
                        break;
                    case 4:
                        usersList.get(rowIndex).setPhone(aValue.toString());
                        break;
                    case 5:
                        usersList.get(rowIndex).setAddress(aValue.toString());
                        break;
                    case 6:
                        usersList.get(rowIndex).setRole((RoleInfoDto)aValue);
                        break;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0 || columnIndex == 3)
            return false;
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(usersList.size() >0 )
            return getValueAt(0, columnIndex).getClass();
        return super.getColumnClass(columnIndex); 
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
}
