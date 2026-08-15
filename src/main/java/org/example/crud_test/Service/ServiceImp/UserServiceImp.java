package org.example.crud_test.Service.ServiceImp;

import lombok.RequiredArgsConstructor;
import org.example.crud_test.DTO.Request.UserRepuest;
import org.example.crud_test.DTO.Response.UserResponse;
import org.example.crud_test.Exeption.ResourceNotFoundException;
import org.example.crud_test.Model.User;
import org.example.crud_test.Repository.UserRepository;
import org.example.crud_test.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRepuest repuest) {
        User user = new User();
        user.setName(repuest.getName());
        user.setEmail(repuest.getEmail());

        User saveUser = userRepository.save(user);
        return new UserResponse(saveUser.getId(), saveUser.getName(), saveUser.getEmail());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responseList = new ArrayList<>();

        for (User user : users){
            UserResponse response = new UserResponse(user.getId(), user.getName(), user.getEmail());
            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public UserResponse updateUser(Long id, UserRepuest repuest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by ID "+id));
        user.setName(repuest.getName());
        user.setEmail(repuest.getEmail());

        User updateUser = userRepository.saveAndFlush(user);
        return new UserResponse(updateUser.getId(), updateUser.getName(), updateUser.getEmail());
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by Id "+id));
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserResponse deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by Id "+id));
        UserResponse response = new UserResponse(user.getId(), user.getName(), user.getEmail());
        userRepository.delete(user);
        return response;
    }

    @Override
    public UserResponse getUserByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with name: " + name);
        }
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }


}
