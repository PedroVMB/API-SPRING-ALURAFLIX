package api.AluraFlix.domain.video;

public record ListVideoDto(Long id, String title, String description, String url, Boolean active) {
    public ListVideoDto(Video video){
        this(video.getId(), video.getTitle(), video.getDescription(), video.getUrl(), video.getActive());
    }
}
