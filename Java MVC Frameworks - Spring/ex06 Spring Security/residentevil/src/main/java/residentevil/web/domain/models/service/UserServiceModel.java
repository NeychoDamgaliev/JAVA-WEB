package residentevil.web.domain.models.service;

import residentevil.web.domain.entities.Role;

import java.util.Set;

/**
 * Created by Neycho Damgaliev on 3/23/2019.
 */
public class UserServiceModel {

    private String id;

    private String username;

    private String password;

    private String email;

    private Set<Role> authorities;

    public UserServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
