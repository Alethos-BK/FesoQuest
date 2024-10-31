package org.back.src.user.service;

import org.back.src.user.dto.UserRequestDto;
import org.back.src.user.dto.UserResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.user.repository.UserRepository;
import org.back.src.shared.conversor.MapperConvert;
import org.back.src.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user ->
                MapperConvert.convert(user, UserResponseDto.class)).toList();
    }

    public UserResponseDto getById(int id) throws CustomException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        return MapperConvert.convert(user, UserResponseDto.class);
    }

    public User create(UserRequestDto userRequestDto) throws CustomException {
        BCryptPasswordEncoder bcript = new BCryptPasswordEncoder();
        userRequestDto.setPassword(bcript.encode(userRequestDto.getPassword()));

        User user = MapperConvert.convert(userRequestDto, User.class);
        return userRepository.save(user);
    }

    public User update(int id, UserRequestDto userRequestDto) throws CustomException {
        userRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        User user = MapperConvert.convert(userRequestDto, User.class);
        user.setId(id);

        return userRepository.save(user);
    }

    public void delete(int id) throws CustomException {
        userRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        userRepository.deleteById(id);
    }
}
