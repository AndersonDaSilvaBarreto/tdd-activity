package com.agile_development.tdd_activity.user.event;

import java.util.UUID;

public record UserDeletedEvent(
        UUID id
) {
}
