package meena.prashant.dependency_injection;

import java.util.stream.IntStream;
import meena.prashant.speaker.model.Speaker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjection {
  public static void main(String[] args) {
    System.out.println("Application Context Creation : STARTED");
    ApplicationContext appContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
    System.out.println("Application Context Creation : END\n");

    singletonVsPrototypeScope(appContext);
  }

  private static void singletonVsPrototypeScope(ApplicationContext appContext) {
    // Differentiating b/w the singleton scope and prototype scope
    IntStream.range(1, 5)
        .mapToObj(_i -> appContext.getBean("newSpeaker", Speaker.class))
        .forEach(System.out::println);

    IntStream.range(1, 5)
        .mapToObj(_i -> appContext.getBean("sameSpeaker", Speaker.class))
        .forEach(System.out::println);
  }
}
