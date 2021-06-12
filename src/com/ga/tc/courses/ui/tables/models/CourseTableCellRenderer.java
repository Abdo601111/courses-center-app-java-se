/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.ui.tables.models;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.security.dto.RoleInfoDto;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pc
 */
public class CourseTableCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent
        (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof UserInfoDto){
            setText(((UserInfoDto) value).getFullName());
        }        
        return this;
            
    }
    
}
