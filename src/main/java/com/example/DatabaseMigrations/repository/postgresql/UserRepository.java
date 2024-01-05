package com.example.DatabaseMigrations.repository.postgresql;

import com.example.DatabaseMigrations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
