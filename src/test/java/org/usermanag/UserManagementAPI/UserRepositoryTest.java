package org.usermanag.UserManagementAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.usermanag.UserManagementAPI.model.User;
import org.usermanag.UserManagementAPI.repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
// @dataJpaTest loads only a slice of the Spring context relevant to JPA.
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        user1 = new User("John Doe", "john@example.com");
        user2 = new User("Charlie Smith", "charlie@example.com");
        user3 = new User("Gowtham Reddy" , "gowthamreddysomala@gmail.com");
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.flush();
        entityManager.clear();
    }
    
    @Test
    void testFindByEmailFound() {
        Optional<User> foundUser = userRepository.findByEmail(user1.getEmail());
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo(user1.getName());
        assertThat(foundUser.get().getEmail()).isEqualTo(user1.getEmail());
        assertThat(foundUser.get().getId()).isEqualTo(user1.getId());

        
    }
    @Test
    void testSaveUser(){
        User newUser = new User("Charlie Chaplin" , "charlie@example.in");
        User saveduser = userRepository.save(newUser);
        assertThat(saveduser).isNotNull();
        assertThat(saveduser.getId()).isNotNull();
        assertThat(saveduser.getName()).isEqualTo("Charlie Chaplin");
    }

    @Test
    void testUpdateUser() {
        String newName = "Gowtham Reddy";
        String newEmail = "gowthamreddysomala@gmail.com";
        user3.setName(newName);
        user3.setEmail(newEmail);
        User updatedUser = userRepository.save(user3);
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getName()).isEqualTo(newName);
        assertThat(updatedUser.getEmail()).isEqualTo(newEmail);
        entityManager.clear();
    }


    @Test
    void testDeleteUserById() {
        Optional<User> existingUser = userRepository.findById(user1.getId());
        assertThat(existingUser).isPresent();
        userRepository.deleteById(user1.getId());
        entityManager.clear();
        Optional<User> deletedUser = userRepository.findById(user1.getId());
        assertThat(deletedUser).isNotPresent(); // Assert that the user is no longer found
    }
}
