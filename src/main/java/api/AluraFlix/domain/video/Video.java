package api.AluraFlix.domain.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private Boolean active;


    public Video(CreateVideoDto dto){
        this.title = dto.title();
        this.description = dto.description();
        this.url = dto.url();
        this.active = true;
    }

    public void dataUpdate(UpdateVideoDto dto){
        if(dto.title() != null){
            this.title = dto.title();
        }
        if(dto.description() != null){
            this.description = dto.description();
        }
        if(dto.url() != null){
            this.url = dto.url();
        }
        if(dto.active() != null){
            this.active = dto.active();
        }
    }

    public void delete() {
        this.active = false;
    }
}
