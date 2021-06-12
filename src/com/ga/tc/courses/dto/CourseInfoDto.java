/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.courses.dto;

import com.ga.tc.authentication.dto.UserInfoDto;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class CourseInfoDto {
    private Integer id, totalHrs;
    private String name, description;
    private Date startDate, endDate, creationDate;
    private UserInfoDto instructor, createdBy;
    private boolean active;
    public CourseInfoDto(){}
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.totalHrs);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.startDate);
        hash = 17 * hash + Objects.hashCode(this.endDate);
        hash = 17 * hash + Objects.hashCode(this.creationDate);
        hash = 17 * hash + Objects.hashCode(this.instructor);
        hash = 17 * hash + Objects.hashCode(this.createdBy);
        return hash;
    }

    public CourseInfoDto(Integer id, Integer totalHrs, String name, String description, Date startDate, Date endDate, Date creationDate, UserInfoDto instructor, UserInfoDto createdBy) {
        this.id = id;
        this.totalHrs = totalHrs;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.creationDate = creationDate;
        this.instructor = instructor;
        this.createdBy = createdBy;
    }

    public CourseInfoDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CourseInfoDto other = (CourseInfoDto) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.totalHrs, other.totalHrs)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.creationDate, other.creationDate)) {
            return false;
        }
        if (!Objects.equals(this.instructor.getId(), other.instructor.getId())) {
            return false;
        }
        if (!Objects.equals(this.createdBy.getId(), other.createdBy.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(Integer totalHrs) {
        this.totalHrs = totalHrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserInfoDto getInstructor() {
        return instructor;
    }

    public void setInstructor(UserInfoDto instructor) {
        this.instructor = instructor;
    }

    public UserInfoDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserInfoDto createdBy) {
        this.createdBy = createdBy;
    }
}
