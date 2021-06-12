/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.bao;

import com.ga.tc.courses.dao.CourseDao;
import com.ga.tc.courses.dao.CourseDaoImpl;
import com.ga.tc.courses.dto.CourseInfoDto;
import com.ga.tc.courses.dto.CourseUserDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class CourseBaoImpl implements CourseBao{
    private CourseDao dao = new CourseDaoImpl();

    @Override
    public List<CourseInfoDto> listAll(Integer status) {
        try{
            return dao.listAll(status);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer save(CourseInfoDto course) {
        try{
            if(course.getId()>0)
                return dao.update(course);
            return dao.save(course);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(CourseInfoDto course) {
        try{
            return dao.delete(course);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CourseInfoDto> loadCoursesLOV() {
        return dao.loadCoursesLOV();
    }

    @Override
    public Integer saveCourseRegisteration(List<CourseUserDto> cReg) {
        try{
            List<CourseUserDto> oldReg = new ArrayList<>(), newReg = new ArrayList<>();
            for(CourseUserDto cr:cReg){
                if(cr.getRegId()==null || cr.getRegId()==0){
                    newReg.add(cr);
                }else
                    oldReg.add(cr);
            }
            int ret1 = 1, ret2 = 1;
            
            if(!oldReg.isEmpty()){
                ret1 = dao.unregister(oldReg);
            }
            if(!newReg.isEmpty()){
                ret1 = dao.insertNewCourseRegisteration(newReg);
            }
            
            if(ret1>0 && ret2>0)
                return 1;
            else 
                return -1;
                
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        
    }
    @Override
    public List<CourseUserDto> loadCourseRegisteration(Integer courseId) {
        try{
            return dao.loadCourseRegisteration(courseId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
