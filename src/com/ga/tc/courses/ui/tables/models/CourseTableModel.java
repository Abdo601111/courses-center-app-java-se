/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.ui.tables.models;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.courses.dto.CourseInfoDto;
import com.ga.tc.security.dto.RoleInfoDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class CourseTableModel extends AbstractTableModel{
    private String[] headers ={"Id", "Name","Description", "Total hrs", "Instructor", "Start Date", "End Date", "Created by", "Creation Date"};
    private List<CourseInfoDto> courseList = new ArrayList<>();
    public CourseTableModel(List<CourseInfoDto> cl){
        this.courseList = cl;
    }
    @Override
    public int getRowCount() {
        return courseList.size();
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
                retVal =  courseList.get(rowIndex).getId();
                break;
            case 1:
                retVal =  courseList.get(rowIndex).getName();
                break;
            case 2:
                retVal =  courseList.get(rowIndex).getDescription();
                break;
            case 3:
                retVal =  courseList.get(rowIndex).getTotalHrs();
                break;
            case 4:
                retVal = courseList.get(rowIndex).getInstructor();
                break;
            case 5:
                retVal =  courseList.get(rowIndex).getStartDate();
                break;
            case 6:
                retVal =  courseList.get(rowIndex).getEndDate();
                break;
            case 7:
                retVal =  courseList.get(rowIndex).getCreatedBy();
                break;
            case 8:
                retVal =  courseList.get(rowIndex).getCreationDate();
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
                        courseList.get(rowIndex).setId(Integer.parseInt(aValue.toString()));
                        break;
                    case 1:
                        courseList.get(rowIndex).setName(aValue.toString());
                        break;
                    case 2:
                        courseList.get(rowIndex).setDescription(aValue.toString());
                        break;
                    case 3:
                        courseList.get(rowIndex).setTotalHrs(Integer.parseInt(aValue.toString()));
                        break;
                    case 4:
                        courseList.get(rowIndex).setInstructor((UserInfoDto)aValue);
                        break;
                    case 5:
                        courseList.get(rowIndex).setStartDate((Date)aValue);
                        break;
                    case 6:
                        courseList.get(rowIndex).setEndDate((Date)aValue);
                        break;
                    case 7:
                        courseList.get(rowIndex).setCreatedBy((UserInfoDto)aValue);
                        break;
                    case 8:
                        courseList.get(rowIndex).setCreationDate((Date)aValue);
                        break;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0 || columnIndex == 7|| columnIndex == 8)
            return false;
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(courseList.size() >0 )
            return getValueAt(0, columnIndex).getClass();
        return super.getColumnClass(columnIndex); 
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
}
