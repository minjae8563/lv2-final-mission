package finalmission.omakase.controller.dto;

import finalmission.omakase.entity.Rating;

public record OmakaseCreateRequest(
        String name,
        Rating rating
) {
}
