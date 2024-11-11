package com.naezuo.user.domain;

import com.naezuo.user.domain.enums.Role;
import com.naezuo.user.domain.enums.Sex;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "pw", nullable = false)
    private String pw;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false )
    private Sex sex;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

}
