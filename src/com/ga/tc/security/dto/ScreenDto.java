/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.security.dto;

/**
 *
 * @author pc
 */
public class ScreenDto {
    private int id = -1;
    private String code, nameAr, nameEn;
    private boolean active, hasViewOnlyAccess, hasFullControlAccess;

    public boolean isHasViewOnlyAccess() {
        return hasViewOnlyAccess;
    }

    public void setHasViewOnlyAccess(boolean hasViewOnlyAccess) {
        this.hasViewOnlyAccess = hasViewOnlyAccess;
    }

    public boolean isHasFullControlAccess() {
        return hasFullControlAccess;
    }

    public void setHasFullControlAccess(boolean hasFullControlAccess) {
        this.hasFullControlAccess = hasFullControlAccess;
    }
    
    public int getId() {
        return id;
    }

    public ScreenDto(String code, String nameAr, String nameEn, boolean active) {
        this.code = code;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.active = active;
    }

    public ScreenDto(int id, String code, String nameAr, String nameEn, boolean active) {
        this.id = id;
        this.code = code;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.active = active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
