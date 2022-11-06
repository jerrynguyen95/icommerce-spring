package com.icommerce.icommerceproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.icommerce.icommerceproject.entity.User} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    private String postCode;
}