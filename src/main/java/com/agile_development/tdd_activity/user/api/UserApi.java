package com.agile_development.tdd_activity.user.api;

import com.agile_development.tdd_activity.user.api.dto.UserSummaryDto;

import java.util.UUID;

public interface UserApi {
    UserSummaryDto findById(UUID id);
    boolean existsById(UUID id);
}
