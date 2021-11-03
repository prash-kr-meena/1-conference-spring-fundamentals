package meena.prashant;

import meena.prashant.dependency_injection.DependencyConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
    basePackages = {"meena.prashant"},
    excludeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = DependencyConfig.class)}
)
public class AppConfig {

  /*
  // Instead of wiring up the beans manually, we can use the @ComponentScan and the Stereotype Annotations
  // (@Component, @Service, @Repository, @Controller <in web context>) to automatically create those beans
  // and then use @Autowired to autowire them appropriately (via our choice of injection)

  @Bean(name = "speakerService")
  @Scope(scopeName = SCOPE_SINGLETON)
  public SpeakerService getSpeakerService() {
    System.out.println("Bean Creation: SpeakerService");
    // Constructor Injection of SpeakerRepository in SpeakerService
    return new SpeakerServiceImpl(getSpeakerRepository());
    //    return new SpeakerServiceImpl();
  }

  @Bean(name = "speakerRepository")
  @Scope(scopeName = SCOPE_SINGLETON)
  public SpeakerRepository getSpeakerRepository() {
    System.out.println("Bean Creation: SpeakerRepository");
    return new HibernateSpeakerRepository();
  }
  */

}
