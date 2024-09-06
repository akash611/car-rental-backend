package com.akash.carrent.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akash.carrent.dto.SignupRequest;
import com.akash.carrent.dto.UserDto;
import com.akash.carrent.service.auth.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @RequestMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest ) {
        if(authService.hasCustomerWithEmail(signupRequest.getEmail())){
            return new ResponseEntity<>("Customer already exists",HttpStatus.NOT_ACCEPTABLE );
        }
        UserDto createdCustomerDto= authService.createCustomer(signupRequest);
        if(createdCustomerDto==null){
            return new ResponseEntity<>("Customer not Created",HttpStatus.BAD_REQUEST );
        }
        return new ResponseEntity<>(createdCustomerDto,HttpStatus.CREATED);
        
    }

}
