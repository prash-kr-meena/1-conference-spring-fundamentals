package meena.prashant.dependency_injection;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

import meena.prashant.speaker.model.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class DependencyConfig {
  private static int count = 0;

  // Note : its object will not be created, while creation of the context
  //        as it needs to be created on demand, so when ever we request this bean from the context
  //        Spring will create a new bean and provide
  @Bean(name = "newSpeaker")
  @Scope(scopeName = SCOPE_PROTOTYPE)
  public Speaker getNewSpeakerInstance() {
    System.out.println("Bean Creation: NewSpeaker");
    count++;
    return new Speaker("first" + count, "last" + count);
  }

  @Bean(name = "sameSpeaker")
  @Scope(scopeName = SCOPE_SINGLETON)
  public Speaker getSameSpeakerInstance() {
    System.out.println("Bean Creation: SameSpeaker");
    count++;
    return new Speaker("first" + count, "last" + count);
  }


  @Bean(name = "ManualSpeakerBeanButAutomaticWiring")
  @Scope(scopeName = SCOPE_SINGLETON)
  public Speaker getSpeakerBeanAndAutoWireItWithoutNeedOfStereotypeAnnotation() {
    // If you think properly, you would not be able to do automatic constructor autowiring using @Autowired
    // and only do either field or setter Autowiring, because in case of constructor you would
    // have to pass the bean in the constructor,
    // NOTE: here we are creating the beans manually but the wiring up is done automatically via annotation
    System.out.println("Bean Creation: ManualSpeakerBeanButAutomaticWiring");
    return new Speaker("Manual Bean Creating", "Automatic Wiring");
  }


  @Bean(name = "AutomaticWiring")
  @Scope(scopeName = SCOPE_SINGLETON)
  public AutomaticWiringExamples createAutowiringObjectForItToInjectTheSpeakInsideOfIt() {
    // Note : we are creating a bean of AutomaticWiring, and not setting the internal speaker object
    // (even though we have its bean that we created by the name of ManualSpeakerBeanButAutomaticWiring)
    //
    // so that when its object will be created, the internal object will be wired automatically via setter injection
    System.out.println("Bean Creation: AutomaticWiringExamples");
    return new AutomaticWiringExamples();
  }
}
