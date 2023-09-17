package api.AluraFlix.domain.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateVideoDto (
        @NotBlank
        @NotNull
        String title,
        @NotBlank
        @NotNull
        String description,
        @NotBlank
        @NotNull
        String url

){
}
