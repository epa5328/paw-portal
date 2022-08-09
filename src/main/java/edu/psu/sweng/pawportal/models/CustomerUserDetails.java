package edu.psu.sweng.pawportal.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * By Kevin
 * This class assists when users login
 */
public class CustomerUserDetails implements UserDetails {

    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;
    private String address;
    private String password;
    private List<GrantedAuthority> authorities;

    public CustomerUserDetails(Customer customer) {

        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.address = customer.getAddress();
        this.email = customer.getEmail();
        this.password = customer.getPassword();
        this.authorities = Arrays.stream(customer.getRoles().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    private static long loggedIn = 0;

    // returns 0 unless
    public static long getLoggedIn() {
        return loggedIn;
    }
    // changes from 0
    public static void setLoggedIn(long custID) {
        loggedIn = custID;
    }
}
