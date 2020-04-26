package Models;

import java.util.Random;

public class News {

    String[] newsLinks = {
            "https://theconversation.com/us/topics/driver-safety-13479",
            "http://www.drivingdynamics.info/category/driver-safety-news/",
            "https://www.usnews.com/topics/subjects/driving"
    };

    Random random;

    public News()
    {
        random = new Random();
    }

    // returns a random link from newsLinks.
    public String getRandomNewsLink() {
        int index = (int) ((newsLinks.length) * random.nextDouble());
        return newsLinks[index];
    }
}
