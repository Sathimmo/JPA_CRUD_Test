package org.example.crud_test.Controller;

import lombok.RequiredArgsConstructor;
import org.example.crud_test.DTO.Request.UserRepuest;
import org.example.crud_test.DTO.Response.UserResponse;
import org.example.crud_test.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRepuest repuest){
        UserResponse createUser = userService.createUser(repuest);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRepuest repuestById){
        UserResponse updateUser = userService.updateUser(id, repuestById);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        UserResponse getUserbyId = userService.getUserById(id);
        return ResponseEntity.ok(getUserbyId);
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponse> getUserByName(@RequestParam String name) {
        UserResponse user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable Long id){
        UserResponse deleteUserById = userService.deleteUserById(id);
        return ResponseEntity.ok(deleteUserById);
    }
}
