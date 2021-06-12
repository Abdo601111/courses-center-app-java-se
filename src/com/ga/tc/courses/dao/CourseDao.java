/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.dao;

import com.ga.tc.common.exception.TCException;
import com.ga.tc.courses.bao.*;
import com.ga.tc.courses.dto.CourseInfoDto;
import com.ga.tc.courses.dto.CourseUserDto;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CourseDao {
    public List<CourseInfoDto> listAll(Integer status);
    public Integer save(CourseInfoDto course) throws TCException;
    public Integer update(CourseInfoDto course);
    public Boolean delete(CourseInfoDto course);
    public List<CourseInfoDto> loadCoursesLOV();
    public List<CourseUserDto> loadCourseRegisterations(Integer courseId);
    public Integer insertNewCourseRegisteration(List<CourseUserDto> cReg);
    public Integer updateNewCourseRegisteration(List<CourseUserDto> cReg);

    public List<CourseUserDto> loadCourseRegisteration(Integer courseId);

    public Integer unregister(List<CourseUserDto> oldReg);
}
