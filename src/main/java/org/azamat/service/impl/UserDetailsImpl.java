package org.azamat.service.impl;

import org.azamat.model.Checkout;
import org.azamat.model.Order;
import org.azamat.model.securitymodel.Status;
import org.azamat.model.securitymodel.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Calendar;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String username;
/*    private String firstName;
    private String lastName;
    private String email;*/
    private String password;
/*    private Order order; // ????*/
    private boolean enabled;
/*    private Calendar created;
    private Calendar updated;*/
    private Collection<? extends GrantedAuthority> authorities;
/*    private Collection<Checkout> checkouts;*/


    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
/*        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.order = user.getOrder();*/
        this.password = user.getPassword();
/*        this.created = user.getCreated();
        this.updated = user.getUpdated();*/
        this.enabled = user.getStatus().equals(Status.ACTIVE);
        this.authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
/*        this.checkouts = user.getCheckouts().stream().map(checkout -> new Checkout(checkout.getId())).collect(Collectors.toList());*/
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

/*    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getCreated() {
        return created;
    }

    public Calendar getUpdated() {
        return updated;
    }

    public Order getOrder() { return order; }*/

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return enabled;
    }
}
