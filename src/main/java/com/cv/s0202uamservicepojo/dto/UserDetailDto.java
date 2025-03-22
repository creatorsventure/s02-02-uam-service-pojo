package com.cv.s0202uamservicepojo.dto;

import com.cv.s01coreservice.dto.generic.GenericDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

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

}
