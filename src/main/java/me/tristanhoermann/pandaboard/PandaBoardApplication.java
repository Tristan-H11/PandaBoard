package me.tristanhoermann.pandaboard;

import me.tristanhoermann.pandaboard.repository.database.MongoHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PandaBoardApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PandaBoardApplication.class, args);
        MongoHandler.connectAndOpenDB("testDB", "testCollection");
    }

}
