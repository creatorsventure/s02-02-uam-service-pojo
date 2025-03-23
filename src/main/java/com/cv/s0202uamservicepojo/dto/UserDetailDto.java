package com.cv.s0202uamservicepojo.dto;

import com.cv.s01coreservice.annotation.ValidMobileNumber;
import com.cv.s01coreservice.dto.generic.GenericDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDetailDto extends GenericDto implements Serializable {

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    private String userId;

    @NotNull(message = "${app.code.003}")
    @ValidMobileNumber
    private String mobileNumber;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Email(message = "${app.code.007}")
    private String email;

    private LocalDateTime lastLogin;

    private PasswordDto passwordDto;
}
