package com.cv.s0202uamservicepojo.dto;

import com.cv.s01coreservice.dto.generic.GenericDto;
import com.cv.s0202uamservicepojo.dto.groups.password.ChangeGroup;
import com.cv.s0202uamservicepojo.dto.groups.password.ForgotGroup;
import com.cv.s0202uamservicepojo.dto.groups.password.ResetAdminGroup;
import com.cv.s0202uamservicepojo.dto.groups.password.ResetGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class PasswordDto extends GenericDto implements Serializable {

    @NotBlank(message = "${app.code.002}", groups = {ChangeGroup.class, ResetAdminGroup.class})
    @NotNull(message = "${app.code.003}", groups = {ChangeGroup.class, ResetAdminGroup.class})
    @Size(min = 3, max = 250, message = "${app.code.005}", groups = {ChangeGroup.class, ResetAdminGroup.class})
    private String userId;

    @NotBlank(message = "${app.code.002}", groups = {ChangeGroup.class, ResetGroup.class})
    @NotNull(message = "${app.code.003}", groups = {ChangeGroup.class, ResetGroup.class})
    @Size(min = 3, max = 250, message = "${app.code.005}", groups = {ChangeGroup.class, ResetGroup.class})
    private String password;

    @NotBlank(message = "${app.code.002}", groups = {ChangeGroup.class})
    @NotNull(message = "${app.code.003}", groups = {ChangeGroup.class})
    @Size(min = 3, max = 250, message = "${app.code.005}", groups = {ChangeGroup.class})
    private String oldPassword;

    @NotBlank(message = "${app.code.002}", groups = {ForgotGroup.class})
    @NotNull(message = "${app.code.003}", groups = {ForgotGroup.class})
    @Size(min = 3, max = 250, message = "${app.code.005}", groups = {ForgotGroup.class})
    private String email;

    @NotBlank(message = "${app.code.002}", groups = {ResetGroup.class})
    @NotNull(message = "${app.code.003}", groups = {ResetGroup.class})
    @Size(min = 3, max = 250, message = "${app.code.005}", groups = {ResetGroup.class})
    private String token;
    
}
