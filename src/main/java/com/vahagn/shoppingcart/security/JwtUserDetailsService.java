package com.vahagn.shoppingcart.security;

import com.vahagn.shoppingcart.jpa.UserEntity;
import com.vahagn.shoppingcart.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserEntity entity = userService.findByUserName(username);

    if (entity != null) {
      List<GrantedAuthority> authorities = new ArrayList<>();

      authorities.add(new SimpleGrantedAuthority(entity.isAdmin() ? "ROLE_ADMIN" : "ROLE_USER"));
      return new User(entity.getUserName(), entity.getPassword(), authorities);
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}
