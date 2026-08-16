package org.example.crud_test.Service;

import org.example.crud_test.DTO.Request.UserRepuest;
import org.example.crud_test.DTO.Response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRepuest repuest);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, UserRepuest repuest);
    UserResponse getUserById(Long id);
    UserResponse deleteUserById(Long id);
    UserResponse getUserByName(String name);

    Page<UserResponse> getAllUserPaginated(Pageable pageable);
}
