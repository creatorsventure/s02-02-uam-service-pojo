package com.cv.s0202uamservicepojo.entity;

import com.cv.s01coreservice.entity.generic.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
public class Role extends GenericEntity implements Serializable {

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Column
    private Integer permission;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    @Column
    private Integer roleType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_owner_id", referencedColumnName = "id")
    private MenuOwner menuOwner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission_mapping",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    private List<Permission> permissionList = new ArrayList<>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu_mapping",
            joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Menu> menuList = new ArrayList<>(0);


}
