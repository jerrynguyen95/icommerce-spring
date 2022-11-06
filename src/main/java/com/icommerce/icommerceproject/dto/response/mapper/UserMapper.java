package com.icommerce.icommerceproject.dto.response.mapper;

import com.icommerce.icommerceproject.dto.response.UserDto;
import com.icommerce.icommerceproject.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
