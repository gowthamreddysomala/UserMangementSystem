package org.usermanag.UserManagementAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.usermanag.UserManagementAPI.model.User;

import java.util.List;
import java.util.Optional;

    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email);
        List<User> findByNameContainingIgnoreCase(String name);
        Optional<User> findById(long id);
} 