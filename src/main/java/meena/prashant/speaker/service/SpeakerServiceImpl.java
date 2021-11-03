package meena.prashant.speaker.service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import meena.prashant.speaker.model.Speaker;
import meena.prashant.speaker.repository.SpeakerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("speakerService")
@Scope(scopeName = SCOPE_SINGLETON)
@Profile(value = {"prod", "dev"})
public class SpeakerServiceImpl implements SpeakerService {

  SpeakerRepository repository;

  public SpeakerServiceImpl(SpeakerRepository repository) {
    System.out.println("SpeakerServiceImpl Constructor: setting up repository");
    this.repository = repository;
  }

  @PostConstruct
  private void postBeanCreationOfThisClassObviously() {
    System.out.println("POST Bean Creation : [SpeakerServiceImpl]");
  }

  @PreDestroy
  private void preBeanDestroyOfThisClassObviously() {
    System.out.println("PRE Bean Destruction : [SpeakerServiceImpl]");
  }

  @Override
  public List<Speaker> findAll() {
    return repository.findAll();
  }

  @Override
  public List<Speaker> findByName(String name) {
    return repository.findByName(name);
  }

}
