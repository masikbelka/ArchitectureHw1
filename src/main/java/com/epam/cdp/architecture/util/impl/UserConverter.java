package com.epam.cdp.architecture.util.impl;

import com.epam.cdp.architecture.model.dto.UserDTO;
import com.epam.cdp.architecture.model.entity.User;
import com.epam.cdp.architecture.util.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {

    @Override
    public UserDTO convert(User user) {
        UserDTO converted = null;
        if (user != null) {
            converted = new UserDTO();
            converted.setUsername(user.getUsername());
            converted.setName(user.getName());
            Calendar instance = Calendar.getInstance();
            instance.setTime(user.getDateOfBirth());
            converted.setDateOfBirth(instance);
        }
        return converted;
    }
}
