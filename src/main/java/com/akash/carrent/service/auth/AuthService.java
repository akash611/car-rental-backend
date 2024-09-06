package com.akash.carrent.service.auth;

import com.akash.carrent.dto.SignupRequest;
import com.akash.carrent.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
}
