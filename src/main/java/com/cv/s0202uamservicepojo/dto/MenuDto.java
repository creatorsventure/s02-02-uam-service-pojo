package com.cv.s0202uamservicepojo.dto;

import com.cv.s01coreservice.dto.generic.GenericDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MenuDto extends GenericDto implements Comparable<MenuDto>, Serializable {

    @Serial
    private static final long serialVersionUID = 7400625511096934266L;

    @NotBlank(message = "{app.code.002}")
    @NotNull(message = "{app.code.003}")
    @Size(min = 3, max = 250, message = "{app.code.005}")
    private String path;

    @NotBlank(message = "{app.code.002}")
    @NotNull(message = "{app.code.003}")
    @Size(min = 3, max = 250, message = "{app.code.005}")
    private String icon;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    private String iconType;

    @NotBlank(message = "${app.code.002}")
    @NotNull(message = "${app.code.003}")
    @Size(min = 3, max = 250, message = "${app.code.005}")
    private String iconTheme;

    @NotNull(message = "{app.code.003}")
    private Integer rootMenuId;

    @NotNull(message = "{app.code.003}")
    private Integer displayPosition;

    @NotNull(message = "{app.code.003}")
    private Integer menuType;

    @NotNull(message = "${app.code.003}")
    private Integer menuOwner;

    @JsonProperty("submenu")
    private List<MenuDto> subMenuList = new ArrayList<>(0);

    private List<RoleDto> roleList = new ArrayList<>(0);


    @Override
    public int compareTo(MenuDto o) {
        return this.getDisplayPosition() < o.getDisplayPosition() ? -1 : 1;
    }
}
