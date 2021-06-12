/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.bao;

import com.ga.tc.courses.dto.CourseInfoDto;
import com.ga.tc.courses.dto.CourseUserDto;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CourseBao {
    public List<CourseInfoDto> listAll(Integer status);
    public Integer save(CourseInfoDto course);
    public Boolean delete(CourseInfoDto course);
    public List<CourseInfoDto> loadCoursesLOV();
    public Integer saveCourseRegisteration(List<CourseUserDto> cReg);
    public List<CourseUserDto> loadCourseRegisteration(Integer courseId);
    
}
