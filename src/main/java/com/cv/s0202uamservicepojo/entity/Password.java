package com.cv.s0202uamservicepojo.entity;

import com.cv.s01coreservice.entity.generic.GenericEntity;
import jakarta.persistence.*;
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
@Entity
public class Password extends GenericEntity implements Serializable {


    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Column
    private String hashPassword;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Column
    private String encryptedPassword;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id" , referencedColumnName = "id")
    private UserDetail userDetail;


}
