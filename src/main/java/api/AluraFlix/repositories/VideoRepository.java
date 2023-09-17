package api.AluraFlix.repositories;

import api.AluraFlix.domain.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Page<Video> findAllByActiveTrue(Pageable paginacao);
}
