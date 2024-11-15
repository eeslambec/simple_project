package uz.tiue.project.service;

import org.springframework.stereotype.Service;
import uz.tiue.project.dto.JwtDto;
import uz.tiue.project.dto.UserCRUDDto;
import uz.tiue.project.model.User;

import java.util.List;

@Service
public interface UserService {
    JwtDto signUp(UserCRUDDto user);
    JwtDto signIn(UserCRUDDto user);
    List<User> getAll();
    User getById(Long id);
    User getByUsername(String username);
    String deleteById(Long id);
}
