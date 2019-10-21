package app.domain;

import org.junit.Assert;
import org.junit.Test;

public class ParticipantTest {
    @Test
    public void getParticipant() {
        Participant person1 = new Participant("name", "age", "height", "weight",
                "bloodPressure");

        person1.setName("name2");
        person1.setAge("age2");
        person1.setHeight("height2");
        person1.setWeight("weight2");
        person1.setBloodPressure("bp2");

        Assert.assertEquals(person1.toString(), "Participant[name='name2', age='age2', height='height2', " +
                "weight='weight2']");
        Assert.assertNotNull(person1);
    }
}
