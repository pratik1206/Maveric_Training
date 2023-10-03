package com.kuka.util;

import com.kuka.dtos.AppUserDetails;
import com.kuka.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public AppUserDetails toUserDetails(User user) {
        AppUserDetails desired = new AppUserDetails();
        BeanUtils.copyProperties(user,desired);
        return desired;
    }

}
