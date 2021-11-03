package meena.prashant;

import meena.prashant.speaker.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

  public static void main(String[] args) {
    System.out.println("Application Context Creation : STARTED");
    // ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(
        AppConfig.class);
    System.out.println("Application Context Creation : END\n");

    SpeakerService speakerService = appContext.getBean("speakerService", SpeakerService.class);
    System.out.println(speakerService.findAll());
    System.out.println(speakerService.findByName("Meena"));

    //    contextDetails()
    applicationContextDetails(appContext);
    Runtime.getRuntime().addShutdownHook(new Thread(appContext::close));
  }

  private static void applicationContextDetails(ApplicationContext appContext) {
    System.out.println("\n--------");
    System.out.println("Application Name: " + appContext.getApplicationName());
    System.out.println("Display Name: " + appContext.getDisplayName());
    System.out.println("Id: " + appContext.getId());
    System.out.println(
        "AutowiredCapableBeanFactory : " + appContext.getAutowireCapableBeanFactory());
    System.out.println("Parent : " + appContext.getParent());
    System.out.println("StartupDate : " + appContext.getStartupDate());
    System.out.println("BeanDefinitionCount : " + appContext.getBeanDefinitionCount());
    System.out.println("ClassLoader : " + appContext.getClassLoader());
    System.out.println("Environment : " + appContext.getEnvironment());
    System.out.println("--------\n");
  }

}
