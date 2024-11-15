package uz.tiue.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.tiue.project.dto.JwtDto;
import uz.tiue.project.dto.UserCRUDDto;
import uz.tiue.project.exception.AlreadyExistException;
import uz.tiue.project.exception.InvalidArgumentException;
import uz.tiue.project.exception.NotFoundException;
import uz.tiue.project.exception.NullOrEmptyException;
import uz.tiue.project.model.User;
import uz.tiue.project.repository.UserRepository;
import uz.tiue.project.security.jwt.JwtTokenProvider;
import uz.tiue.project.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public JwtDto signUp(UserCRUDDto user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new AlreadyExistException("Username");
        }
         User user1 = User.builder()
                        .password(passwordEncoder.encode(user.getPassword()))
                        .username(user.getUsername())
                        .build();
         return new JwtDto(jwtTokenProvider.generateToken(userRepository.save(user1)));
    }

    @Override
    public JwtDto signIn(UserCRUDDto user) {
        if (user.getUsername().isBlank()){
            throw new NullOrEmptyException("Username");
        }
        User user1 = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new NotFoundException(user.getUsername()));
        if (!passwordEncoder.matches(user.getPassword(), user1.getPassword())){
            throw new InvalidArgumentException("Password");
        }
        return new JwtDto(jwtTokenProvider.generateToken(user1));
    }

    @Override
    public List<User> getAll() {
        List<User> all = userRepository.findAll();
        if (all.isEmpty()){
            throw new NullOrEmptyException("Users");
        }
        return all;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User"));
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User"));
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "salom";
    }
}
