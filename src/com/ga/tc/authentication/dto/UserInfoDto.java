package com.ga.tc.authentication.dto;

import com.ga.tc.common.GenericDto;
import com.ga.tc.security.dto.RoleInfoDto;
import java.util.List;

public class UserInfoDto {
    private Integer id, active;
    private RoleInfoDto role;
    private String fullName, email, password, phone, address, laf;
    private List<GenericDto> accessibleScreens;

    public List<GenericDto> getAccessibleScreens() {
        return accessibleScreens;
    }

    public void setAccessibleScreens(List<GenericDto> accessibleScreens) {
        this.accessibleScreens = accessibleScreens;
    }
    public UserInfoDto(String fullName, String email, String password, String phone, String address, String laf) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.laf = laf;
    }

    @Override
    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (!(o2 instanceof UserInfoDto)) {
            return false;
        }
        final UserInfoDto other = (UserInfoDto) o2;
        if (!(id == null ? other.id == null : id.equals(other.id))) {
            return false;
        }
        if (!(active == null ? other.active == null : active.equals(other.active))) {
            return false;
        }
        if (!(role == null ? other.role == null : role.getId().equals(other.role.getId()))) {
            return false;
        }
        if (!(fullName == null ? other.fullName == null : fullName.equals(other.fullName))) {
            return false;
        }
        if (!(email == null ? other.email == null : email.equals(other.email))) {
            return false;
        }
        if (!(password == null ? other.password == null : password.equals(other.password))) {
            return false;
        }
        if (!(phone == null ? other.phone == null : phone.equals(other.phone))) {
            return false;
        }
        if (!(address == null ? other.address == null : address.equals(other.address))) {
            return false;
        }
        if (!(laf == null ? other.laf == null : laf.equals(other.laf))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        result = PRIME * result + ((active == null) ? 0 : active.hashCode());
        result = PRIME * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = PRIME * result + ((email == null) ? 0 : email.hashCode());
        result = PRIME * result + ((password == null) ? 0 : password.hashCode());
        result = PRIME * result + ((phone == null) ? 0 : phone.hashCode());
        result = PRIME * result + ((address == null) ? 0 : address.hashCode());
        result = PRIME * result + ((laf == null) ? 0 : laf.hashCode());
        return result;
    }

    public UserInfoDto(Integer id, Integer active, RoleInfoDto role, String fullName, String email, String password,
                       String phone, String address, String laf) {
        this.id = id;
        this.active = active;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.laf = laf;
    }

    @Override
    public String toString() {
        return this.fullName;
    }

    public UserInfoDto() {
        super();
    }

    public UserInfoDto(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getActive() {
        return active;
    }

    public RoleInfoDto getRole() {
        return role;
    }

    public void setRole(RoleInfoDto role) {
        this.role = role;
    }

    

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLaf(String laf) {
        this.laf = laf;
    }

    public String getLaf() {
        return laf;
    }
}
