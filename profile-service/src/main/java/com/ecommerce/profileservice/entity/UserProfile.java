package com.ecommerce.profileservice.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfile {

    @Id
    String id;

    String userId;
    String username;
    String email;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
    private Integer createId;
    private Integer updateId;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private boolean deleteFlag;
}
