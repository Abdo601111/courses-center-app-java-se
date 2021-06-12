/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.ui.tables.models;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.security.dto.RoleInfoDto;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author pc
 */
public class CourseTableCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{
    private UserInfoDto selectdUser;
    private List<UserInfoDto> users = new ArrayList<>();
    public CourseTableCellEditor(UserInfoDto sr, List<UserInfoDto> r){
        this.selectdUser = sr;
        this.users = r;
    }
    @Override
    public Object getCellEditorValue() {
        return selectdUser;
    }

    @Override
    public Component getTableCellEditorComponent
        (JTable table, Object value, boolean isSelected, int row, int column) {
        JComboBox<UserInfoDto> userCombo = null;
        if(value instanceof UserInfoDto){
            selectdUser = (UserInfoDto)value;
            userCombo = new JComboBox<>();
            for(UserInfoDto u:users)
                userCombo.addItem(u);
            userCombo.setSelectedItem(selectdUser);
            userCombo.addActionListener(this);
        }
        return userCombo;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((UserInfoDto)((JComboBox)e.getSource()).getSelectedItem()).getFullName());
    }
    
}
