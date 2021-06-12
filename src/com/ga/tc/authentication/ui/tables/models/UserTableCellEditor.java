/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.authentication.ui.tables.models;

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
public class UserTableCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{
    private RoleInfoDto selctdRole;
    private List<RoleInfoDto> roles = new ArrayList<>();
    public UserTableCellEditor(RoleInfoDto sr, List<RoleInfoDto> r){
        this.selctdRole = sr;
        this.roles = r;
    }
    @Override
    public Object getCellEditorValue() {
        return selctdRole;
    }

    @Override
    public Component getTableCellEditorComponent
        (JTable table, Object value, boolean isSelected, int row, int column) {
        JComboBox<RoleInfoDto> roleCombo = null;
        if(value instanceof RoleInfoDto){
            selctdRole = (RoleInfoDto)value;
            roleCombo = new JComboBox<>();
            for(RoleInfoDto r:roles)
                roleCombo.addItem(r);
            roleCombo.setSelectedItem(selctdRole);
            roleCombo.addActionListener(this);
        }
//        if(isSelected)
//            roleCombo.setBackground(table.getSelectionBackground());
//        else
//            roleCombo.setBackground(table.getSelectionForeground());
        return roleCombo;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((RoleInfoDto)((JComboBox)e.getSource()).getSelectedItem()).getName());
    }
    
}
