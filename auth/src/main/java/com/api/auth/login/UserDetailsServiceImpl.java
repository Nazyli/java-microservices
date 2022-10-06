package com.api.auth.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.auth.dtos.CustomUser;
import com.api.auth.models.Users;
import com.api.auth.repositories.UsersRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        int applicationId = 0;
        Users users = usersRepository.findUserByUsername(username);
        if (users != null) {
            if (users.isActives()) {
                String role = users.getScope();
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
                return new CustomUser(users.getUserName(), encoder.encode(users.getUserPassword()), grantedAuthorities,
                        users.getUserId(), applicationId);
            }
            throw new UsernameNotFoundException("Username: " + username + " is not active");
        }
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}