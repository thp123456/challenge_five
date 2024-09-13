package com.challengethree.Swagger.Repository;

import com.challengethree.Swagger.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
