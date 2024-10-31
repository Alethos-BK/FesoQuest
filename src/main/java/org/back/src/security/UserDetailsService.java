package org.back.src.security;

import org.back.src.user.repository.UserRepository;
import org.back.src.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        User user = userRepository.findByRegistration(matricula)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + matricula));
        return user;
    }

}
