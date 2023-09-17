package api.AluraFlix.domain.video;

import jakarta.validation.constraints.NotNull;

public record UpdateVideoDto(
    @NotNull
    Long id,

    String title,
    String description,
    String url,
    Boolean active
) {
}
