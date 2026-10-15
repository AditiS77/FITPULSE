package com.fitness.ADT.userservice;
import com.fitness.ADT.userservice.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User, String> {
    Boolean existsByEmail(String email);

    Boolean existsByKeycloakId(String userId);

    User findByEmail(@NotBlank(message = "EMAIL IS REQUIRED!") @Email(message = "INVALID EMAIL FORMAT!") String email);
}
