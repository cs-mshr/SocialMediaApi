package com.facebook.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;
    private String name;
    private String phone_number;

//    @Column(unique = true)
    private String email;

    private UUID friend_of;
    private String profile_image;

    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;
}
