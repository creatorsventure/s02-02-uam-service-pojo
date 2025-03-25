package com.cv.s0202uamservicepojo.entity;

import com.cv.s01coreservice.annotation.ValidMobileNumber;
import com.cv.s01coreservice.entity.generic.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
public class UserDetail extends GenericEntity implements Serializable {

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Column(unique = true)
    private String userId;

    @NotNull(message = "${app.code.003}")
    @ValidMobileNumber
    @Column
    private String mobileNumber;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Email(message = "${app.code.003}")
    @Column(unique = true)
    private String email;

    @Column
    private LocalDateTime lastLogin;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "password_id", unique = true)
    private Password password;

}
