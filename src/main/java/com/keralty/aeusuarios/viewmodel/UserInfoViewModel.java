package com.keralty.aeusuarios.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.GridPreferences;
import com.keralty.aeusuarios.utils.DynamicPermissionsUtils;

public class UserInfoViewModel {

    @JsonProperty("email")
    private String email;

    @JsonProperty("hasRegistered")
    private boolean hasRegistered;

    @JsonProperty("roles")
    private String roles;

    @JsonIgnore
    private List<String> visibleHATNodes;

    @JsonIgnore
    private List<VisibleIUPermissions> visibleIUs;

    @JsonIgnore
    private List<GridPreferences> gridPreferences;

    @JsonProperty("token")
    private String token;

    @JsonProperty("oidJson")
    private String oidJson;

    @JsonProperty("errorCode")
    private String errorCode = "";

    @JsonProperty("userCache")
    private String userCache = "";

    public UserInfoViewModel() {
        this.email = "";
        this.hasRegistered = false;
        this.roles = "";
        this.visibleHATNodes = new ArrayList<>();
        this.visibleIUs = new ArrayList<>();
        this.gridPreferences = new ArrayList<>();
    }

    public UserInfoViewModel(String userName, String userRoles) {
        this.email = userName;
        this.roles = userRoles;
        this.hasRegistered = true;

        this.gridPreferences = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHasRegistered() {
        return hasRegistered;
    }

    public void setHasRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<String> getVisibleHATNodes() {
        return visibleHATNodes;
    }

    public void setVisibleHATNodes(List<String> visibleHATNodes) {
        this.visibleHATNodes = visibleHATNodes;
    }

    public List<VisibleIUPermissions> getVisibleIUs() {
        return visibleIUs;
    }

    public void setVisibleIUs(List<VisibleIUPermissions> visibleIUs) {
        this.visibleIUs = visibleIUs;
    }

    public List<GridPreferences> getGridPreferences() {
        return gridPreferences;
    }

    public void setGridPreferences(List<GridPreferences> gridPreferences) {
        this.gridPreferences = gridPreferences;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOidJson() {
        return oidJson;
    }

    public void setOidJson(String oidJson) {
        this.oidJson = oidJson;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getUserCache() {
        return userCache;
    }

    public void setUserCache(String userCache) {
        this.userCache = userCache;
    }

}
