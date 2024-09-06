package com.akash.carrent.service.auth;
import org.springframework.stereotype.Service;
import com.akash.carrent.dto.SignupRequest;
import com.akash.carrent.dto.UserDto;
import com.akash.carrent.entity.User;
import com.akash.carrent.enums.UserRole;
import com.akash.carrent.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user= new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setUserRole(user.getUserRole());
        return userDto;
        
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
       return userRepository.existsByEmail(email);
    }

}
