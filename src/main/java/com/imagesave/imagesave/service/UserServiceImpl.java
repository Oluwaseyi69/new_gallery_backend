package com.imagesave.imagesave.service;

import com.imagesave.imagesave.data.models.User;
import com.imagesave.imagesave.data.repository.UserRepo;
import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.LoginRequest;
import com.imagesave.imagesave.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public ApiResponse<?> login(LoginRequest loginRequest) {
        User user = buildUser();
         // Validate username (optional)
    // if (!user.getUsername().equals(loginRequest.getUsername())) {
    //     return ApiResponse.failure("User not found");
    // }

    // // Check password
    // if (!user.getPassword().equals(loginRequest.getPassword())) {
    //     return ApiResponse.failure("Invalid password");
    // }
        return ApiResponse.success(user, "Login successful");
    }

    @Override
    public void createMainUser() {
        boolean noAdminYet = userRepo.findByUsername("SuperAdmin").isEmpty();
        if (noAdminYet) {
            User user = buildUser();
            userRepo.save(user);
        }
    }

    private static User buildUser() {
        User user = new User();
        // user.setUsername("AOG");
        // user.setPassword("AOG2024");
        return user;
    }

    private void checkPassword(String password, String password1) {
        if (!password.equals(password1)) {
            throw new IllegalArgumentException("Incorrect password");
        }
    }

    private User getUser(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) throw new IllegalArgumentException("User not found");
        return user.get();
    }
}
