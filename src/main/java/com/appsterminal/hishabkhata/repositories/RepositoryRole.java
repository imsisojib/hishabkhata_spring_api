package com.appsterminal.hishabkhata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsterminal.hishabkhata.enums.ERole;
import com.appsterminal.hishabkhata.models.entities.Role;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
