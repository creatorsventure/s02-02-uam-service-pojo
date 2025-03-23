package com.cv.s0202uamservicepojo.dto;

import com.cv.s01coreservice.dto.generic.GenericDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDetailDto extends GenericDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6860945950191011702L;

    @NotNull(message = "app.error.msg-2")
    private String email;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 20, message = "${app.code.005}")
    private String userName;

    private LocalDateTime last_login;

    @NotNull(message = "${app.code.003}")
    private Integer failedLoginAttempts;

}
