package api.AluraFlix.domain.video;

public record DetailVideoDto(Long id, String title, String description, String url, Boolean active) {
    public DetailVideoDto(Video video){
        this(video.getId(), video.getTitle(), video.getDescription(), video.getUrl(), video.getActive());
    }
}
