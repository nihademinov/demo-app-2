package com.example.demoapp.repository;

import com.example.demoapp.domain.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserContactRepository extends JpaRepository<UserContact, UUID> {
}
