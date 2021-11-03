package meena.prashant.speaker.repository;

import java.util.List;
import meena.prashant.speaker.model.Speaker;

public interface SpeakerRepository {
  List<Speaker> findAll();

  List<Speaker> findByName(String name);
}
