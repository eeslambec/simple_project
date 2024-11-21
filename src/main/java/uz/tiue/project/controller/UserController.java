package uz.tiue.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tiue.project.dto.UserCRUDDto;
import uz.tiue.project.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserCRUDDto userCRUDDto) {
        return ResponseEntity.ok(userService.signUp(userCRUDDto));
    }
    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserCRUDDto userCRUDDto) {
        return ResponseEntity.ok(userService.signIn(userCRUDDto));
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
    @GetMapping("/get/username/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getByUsername(username));
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
