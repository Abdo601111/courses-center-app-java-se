/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.common;

/**
 *
 * @author pc
 */
public class GenericDto {
    private String code;
    private boolean readOnly, fullAccess;
    public GenericDto(String code, boolean readOnly, boolean fullAccess){
        this.code = code;
        this.readOnly = readOnly;
        this.fullAccess = fullAccess;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isFullAccess() {
        return fullAccess;
    }

    public void setFullAccess(boolean fullAccess) {
        this.fullAccess = fullAccess;
    }
    private String description;

    @Override
    public String toString() {
        return description;
    }

    public GenericDto(String description, Integer value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    private Integer value;
}
