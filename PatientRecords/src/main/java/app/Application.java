package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating Participant table");

        jdbcTemplate.execute("DROP TABLE participants IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE participants(" +
                "name VARCHAR(50), age VARCHAR(50), height VARCHAR(50), weight VARCHAR(50), " +
                "bloodPressure VARCHAR (50), PRIMARY KEY (name, age, height, weight, bloodPressure))");

    }
}
