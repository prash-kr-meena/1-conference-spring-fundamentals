package meena.prashant.speaker.service;

import java.util.List;
import meena.prashant.speaker.model.Speaker;

public interface SpeakerService {
  List<Speaker> findAll();

  List<Speaker> findByName(String name);
}
