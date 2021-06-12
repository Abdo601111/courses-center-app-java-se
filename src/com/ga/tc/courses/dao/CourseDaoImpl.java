/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.dao;
import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.ConnectionFactory;
import com.ga.tc.common.Constants;
import com.ga.tc.common.Queries;
import com.ga.tc.common.exception.TCException;
import com.ga.tc.courses.dto.CourseInfoDto;
import com.ga.tc.courses.dto.CourseUserDto;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author pc
 */
public class CourseDaoImpl implements CourseDao{

    @Override
    public List<CourseInfoDto> listAll(Integer status) {
        List<CourseInfoDto> courses = null;
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
           jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            if(status == Constants.STATUS_LIST_ALL)
                jdbcRs.setCommand(Queries.LIST_ALL_COURSES);
            else{
                jdbcRs.setCommand(Queries.LIST_ALL_COURSES_WITH_STATUS);
                jdbcRs.setInt(1, status);
            }
            jdbcRs.execute();
            
            CourseInfoDto course = null;
            while(jdbcRs.next()){
                if(courses == null)
                    courses = new ArrayList<>();
                course = new CourseInfoDto();
                course.setId(jdbcRs.getInt(1));
                course.setName(jdbcRs.getString(2));
                course.setDescription(jdbcRs.getString(3));
                course.setTotalHrs(jdbcRs.getInt(4));
                course.setInstructor(new UserInfoDto(jdbcRs.getInt(5)));
                course.setStartDate(jdbcRs.getDate(6));
                course.setEndDate(jdbcRs.getDate(7));
                course.setCreatedBy(new UserInfoDto(jdbcRs.getInt(8)));
                course.setCreationDate(jdbcRs.getDate(9));
//                if(    status == Constants.STATUS_LIST_ALL 
//                   ||  (status == Constants.STATUS_ACTIVE && cu.isActive())
//                   ||  (status == Constants.STATUS_INACTIVE && ! cu.isActive() )
//                  ){
                    courses.add(course);
//                }
            }
       }catch(Exception e){
           e.printStackTrace();
       } 
       return courses; 
    }

    @Override
    public Integer save(CourseInfoDto course) throws TCException{
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.INSERT_NEW_COURSE);
            jdbcRs.setString(1, course.getName().toUpperCase());
            jdbcRs.setString(2, course.getDescription());
            jdbcRs.setInt(3, course.isActive()?1:0);
            jdbcRs.setInt(4, course.getTotalHrs());
            jdbcRs.setInt(5, course.getInstructor().getId());
            
            if(course.getStartDate() != null)
                jdbcRs.setDate(6, new java.sql.Date(course.getStartDate().getTime()));
            else
                jdbcRs.setNull(6, java.sql.Types.DATE);
            if(course.getEndDate() != null)
                jdbcRs.setDate(7, new java.sql.Date(course.getEndDate().getTime()));
            else
                jdbcRs.setNull(7, java.sql.Types.DATE);
            
            jdbcRs.setInt(8, course.getCreatedBy().getId());
            
            jdbcRs.execute();
            return 1;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            TCException ex = new TCException();
            ex.setExactMessage("Role Name Already Exists!!!");
            throw ex;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public Integer update(CourseInfoDto course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(CourseInfoDto course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourseInfoDto> loadCoursesLOV() {
        List<CourseInfoDto> courses = null;
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
           jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_COURSES_LOV);
            
            jdbcRs.execute();
            
            CourseInfoDto course = null;
            while(jdbcRs.next()){
                if(courses == null)
                    courses = new ArrayList<>();
                course = new CourseInfoDto();
                course.setId(jdbcRs.getInt(1));
                course.setName(jdbcRs.getString(2));
                courses.add(course);
            }
       }catch(Exception e){
           e.printStackTrace();
       } 
       return courses; 
    }

    @Override
    public List<CourseUserDto> loadCourseRegisterations(Integer courseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertNewCourseRegisteration(List<CourseUserDto> cReg) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            
            for(CourseUserDto cu:cReg){
                jdbcRs.setCommand(Queries.REGISTER_A_COURSE);
                jdbcRs.setInt(1, cu.getCourseId());
                jdbcRs.setInt(2, cu.getStudentId());
                
                jdbcRs.execute();
            }
            return 1;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            
            
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }

    @Override
    public Integer updateNewCourseRegisteration(List<CourseUserDto> cReg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourseUserDto> loadCourseRegisteration(Integer courseId) {
        List<CourseUserDto> courseUsers = null;
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LOAD_COURSE_STUDENTS);
            jdbcRs.setInt(1, courseId);
            
            jdbcRs.execute();
            
            CourseUserDto cu = null;
            while(jdbcRs.next()){
                if(courseUsers == null)
                    courseUsers = new ArrayList<>();
                cu = new CourseUserDto();
                cu.setRegId(jdbcRs.getInt(1));
                cu.setStudentId(jdbcRs.getInt(2));
                cu.setActive(jdbcRs.getBoolean(3));
                courseUsers.add(cu);
            }
       }catch(Exception e){
           e.printStackTrace();
       } 
       return courseUsers; 
    }

    @Override
    public Integer unregister(List<CourseUserDto> oldReg) {
        try(JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUser());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            
            for(CourseUserDto cu:oldReg){
                jdbcRs.setCommand(Queries.UNREGISTER_USER);
                jdbcRs.setInt(1, cu.getRegId());
                jdbcRs.execute();
            }
            return 1;
        }catch(Exception e){
           e.printStackTrace();     
        }
        return -1;
    }
    
}
