package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("AppUser")

public class AppUser {

    @Id
    private String username;

    private String passwordHash;

    private List<String> roles;
}
