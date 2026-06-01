package com.agile_development.tdd_activity.user.api.event;

import java.util.UUID;

public record UserDeletedEvent(
        UUID id
) {
}
