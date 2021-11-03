package meena.prashant.speaker.repository;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import meena.prashant.speaker.model.Speaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository("speakerRepository")
@Scope(scopeName = SCOPE_SINGLETON)
@Profile("dev")
public class HibernateSpeakerRepository implements SpeakerRepository {

  @Value("#{T(Math).random() * 100 }")
  private double salt;

  public HibernateSpeakerRepository() {
    System.out.println("HibernateSpeakerRepository Constructor: Default");
  }

  @PostConstruct
  private void postBeanCreationOfThisClassObviously() {
    System.out.println("POST Bean Creation : [HibernateSpeakerRepository]");
    System.out.println("Salted Value : " + salt + "\t\t Processed Post Bean Construction");
  }

  @PreDestroy
  private void preBeanDestroyOfThisClassObviously() {
    System.out.println("PRE Bean Destruction : [HibernateSpeakerRepository]");
  }


  private final List<Speaker> speakers = List.of(
      new Speaker("Prashant", "Meena"),
      new Speaker("Rahul", "Sehrawat"),
      new Speaker("Palak", "Meena")
  );

  @Override
  public List<Speaker> findAll() {
    return speakers;
  }

  @Override
  public List<Speaker> findByName(String name) {
    return speakers.stream()
        .filter(speaker -> speaker.getFirstName().equals(name) ||
            speaker.getLastName().equals(name)
        )
        .collect(Collectors.toList());
  }
}
