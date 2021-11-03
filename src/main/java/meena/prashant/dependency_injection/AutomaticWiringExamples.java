package meena.prashant.dependency_injection;

import meena.prashant.speaker.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutomaticWiringExamples {
  Speaker speaker;

  @Autowired // gives warning, but it's correct
  @Qualifier(value = "ManualSpeakerBeanButAutomaticWiring")
  public void setSpeaker(Speaker speaker) {
    System.out.println("Setter Injection : Automatically wiring (via @Autowired)"
        + " a manually created bean of type Speaker");
    this.speaker = speaker;
    System.out.println("Autowired Bean " + this.speaker);
  }
}
