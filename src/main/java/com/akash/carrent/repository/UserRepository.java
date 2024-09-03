package com.akash.carrent.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.akash.carrent.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    

}
