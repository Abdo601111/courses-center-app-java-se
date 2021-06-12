package com.ga.tc.common;

public class Queries {
    /**
     * Authentication module
     */
    public static final String INSERT_NEW_USER =
        "INSERT INTO TC_USER (USR_FULL_NAME,USR_EMAIL,USR_PASSWORD,USR_PHONE,USR_ADDRESS, USR_LAF, USR_ROLE) VALUES(?,?,?,?,?,?,?)";
    public static final String UPDATE_USER_PROFILE ="UPDATE TC_USER  SET USR_FULL_NAME = ?, USR_EMAIL =?, USR_PHONE = ?, USR_ADDRESS = ?, USR_LAF=? WHERE USR_ID = ?";
    
    public static final String AUTHENTICATE_USER = "SELECT USR_ID, USR_FULL_NAME, USR_PHONE, USR_ADDRESS, USR_ROLE, USR_LAF "
            + "FROM TC_USER WHERE USR_EMAIL = ? AND USR_PASSWORD=? AND USR_ACTIVE =1";
    public static final String USER_ACCESSIBLE_SCREENS = "select s.CODE,sr.VIEW_ONLY, sr.FULL_CONTROL " +
            "from TC_ROLE_SCREENS sr, TC_USER u, TC_SCREEN s " +
            "where sr.ROLE_ID = u.USR_ROLE and s.ID = sr.SCREEN_ID and u.USR_ID=?";
    public static final String LIST_ALL_USERS_ACTIVE ="SELECT  USR_ID, USR_FULL_NAME, USR_EMAIL, USR_PASSWORD, USR_PHONE, USR_ADDRESS, USR_ROLE FROM TC_USER"
            + " WHERE USR_ACTIVE =?";
    public static final String LIST_ALL_INSTRUCTORS_ACTIVE ="SELECT  USR_ID, USR_FULL_NAME, USR_EMAIL, USR_PASSWORD, USR_PHONE, USR_ADDRESS, USR_ROLE FROM TC_USER"
            + " WHERE USR_ACTIVE =1 AND USR_IS_INSTRUCTOR =1";
    public static final String LIST_ALL_USERS = "SELECT  USR_ID, USR_FULL_NAME, USR_EMAIL, USR_PASSWORD, USR_PHONE, USR_ADDRESS, USR_ROLE FROM TC_USER";
    
    public static final String LIST_ALL_STUDENTS = "SELECT  USR_ID, USR_FULL_NAME, USR_EMAIL, USR_PHONE, USR_ADDRESS FROM TC_USER WHERE "
            + " USR_ACTIVE = 1 AND USR_IS_STUDENT =1";
    
    public static final String CHANGE_USER_PASSWORD = "UPDATE TC_USER SET USR_PASSWORD=? WHERE USR_EMAIL=?";
    /**
     * Security Module
     */
    public static final String INSERT_NEW_ROLE = "INSERT INTO TC_ROLE (ROLE_NAME, ROLE_DESCRIPTION) VALUES(UPPER(?), ?)";
    public static final String UPDATE_ROLE = "UPDATE TC_ROLE SET ROLE_NAME = ?, ROLE_DESCRIPTION= ?, ROLE_ACTIVE = ? WHERE ROLE_ID=?";
    public static final String UPDATE_SCREEN ="UPDATE TC_SCREEN SET AR_NAME = ?, EN_NAME = ?,ACTIVE  = ?, CODE    = ? WHERE ID    = ?";
    public static final String LIST_ALL_ROLES  = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_ACTIVE FROM TC_ROLE";
    public static final String DELETE_ROLE = "DELETE FROM TC_ROLE WHERE ROLE_ID = ?";
    public static final String DELETE_SCREEN = "DELETE FROM TC_SCREEN WHERE CODE = ?";
    public static final String INSERT_SCREEN = "INSERT INTO TC_SCREEN (AR_NAME,EN_NAME,ACTIVE,CODE) VALUES(?,?,?,?)";
    public static final String LIST_ALL_SCREENS ="SELECT ID, AR_NAME, EN_NAME, ACTIVE, CODE FROM TC_SCREEN";
    public static final String GRANT_ACCESS= "INSERT INTO TC_ROLE_SCREENS  ( ROLE_ID,SCREEN_ID, VIEW_ONLY, FULL_CONTROL) VALUES(?,?,?,? )";
    public static final String REVOK_PERMISSION = "DELETE FROM TC_ROLE_SCREENS WHERE ROLE_ID = ?";
    /**
     * Courses Module
     */
    public static String INSERT_NEW_COURSE = "INSERT INTO TC_COURSE (NAME,DESCRIPTION,ACTIVE,TOTAL_HOURS,INSTRUCTOR,START_DATE,END_DATE,CREATED_BY) " +
                                "VALUES (?,?,?,?,?,?,?,?)";
    public static String LIST_ALL_COURSES_WITH_STATUS = "SELECT ID, NAME,DESCRIPTION,TOTAL_HOURS,INSTRUCTOR,START_DATE,END_DATE,CREATED_BY, CREATION_DATE " +
                                " FROM TC_COURSE WHERE ACTIVE = ?";
    public static String LIST_ALL_COURSES = "SELECT ID, NAME,DESCRIPTION,TOTAL_HOURS,INSTRUCTOR,START_DATE,END_DATE,CREATED_BY, CREATION_DATE " +
                                " FROM TC_COURSE";
    public static String LIST_COURSES_LOV ="SELECT ID, NAME ||'   ('||DESCRIPTION||')' FROM TC_COURSE WHERE ACTIVE =1";
    
    public static String REGISTER_A_COURSE = "INSERT INTO TC_COURSE_USERS (COURSE, STUDENT) VALUES(?, ?)";
    
    public static String LOAD_COURSE_STUDENTS = "SELECT ID, STUDENT, ACTIVE FROM TC_COURSE_USERS WHERE COURSE = ?";
    
    public static String UNREGISTER_USER = "DELETE FROM TC_COURSE_USERS WHERE ID = ?";
}
