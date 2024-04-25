package com.imagesave.imagesave.service;

import com.imagesave.imagesave.data.models.User;
import com.imagesave.imagesave.data.repository.UserRepo;
import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public ApiResponse<?> login(LoginRequest loginRequest) {
        User user = getUser(loginRequest.getUsername());
        checkPassword(user.getPassword(), loginRequest.getPassword());
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
        user.setUsername("HusWife");
        user.setPassword("HusWife2024");
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
