package se.leinonen.hmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

/**
 * Created by leinonen on 2016-03-30.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        checkConfig();
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
    }

    private static void checkConfig() {

        File mainConfig = new File("src/main/resources/application.properties");
        File testConfig = new File("src/test/resources/application.properties");

        System.out.println(mainConfig.isFile() + " " + testConfig.isFile());

        if (!mainConfig.isFile() || !testConfig.isFile()) {
            throw new IllegalStateException("\n\n========PLEASE CONFIGURE PROJECT========" +
                    "\nApplication configuration not found, have you:" +
                    "\n\t - copied \"application.main\" to \"src/main/resources/application.properties\"?" +
                    "\n\t - copied \"application.test\" to \"src/test/resources/application.properties\"?" +
                    "\n\t - edited these files with the correct configuration?" +
                    "\n========================================\n");
        }
    }
}
