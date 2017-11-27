package com.incture.sample.workbox.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by satiswardash on 24/11/17.
 */

public class UserWorkloadDto implements Serializable {

    private List<UserWorkLoad> userWorkloadDto;

    public List<UserWorkLoad> getUserWorkloadDto() {
        return userWorkloadDto;
    }

    public void setUserWorkloadDto(List<UserWorkLoad> userWorkloadDto) {
        this.userWorkloadDto = userWorkloadDto;
    }
}
