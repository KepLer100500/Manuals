package com.kepler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public static List<User> createDefaultUsers() {
        return List.of(
                User.builder()
                        .username("user")
                        .password("$2a$12$PSLf1Kf.D4n9xqVcIWwNdOoSlmSq68qDgwmOaajknPs3aI7q1vIRe")
                        .role(Role.USER)
                        .status(Status.BANNED)
                        .build(),
                User.builder()
                        .username("admin")
                        .password("$2a$12$k2fRqNiVD4CDafY6/KRsLOTjRXHZhHwGYVclPqVxoHt0QJvexak06")
                        .role(Role.ADMIN)
                        .status(Status.ACTIVE)
                        .build()
        );
    }
}
