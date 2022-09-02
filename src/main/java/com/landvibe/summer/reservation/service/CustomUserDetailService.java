package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneWithAuthoritiesByName(username)
                .map(user -> createUser(username, user))
                .orElseThrow(() -> new IllegalStateException("user not found"));
    }

    private User createUser(String name, com.landvibe.summer.reservation.entity.User user) {
        List<GrantedAuthority> grantedAuthorityList = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());
        return new User(
                user.getName(),
                user.getPassword(),
                grantedAuthorityList
        );
    }
}
