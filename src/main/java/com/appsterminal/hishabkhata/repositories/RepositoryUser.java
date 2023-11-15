package com.appsterminal.hishabkhata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsterminal.hishabkhata.models.entities.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
