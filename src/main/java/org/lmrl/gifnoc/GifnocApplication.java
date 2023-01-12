package org.lmrl.gifnoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class GifnocApplication {

    public static void main(String[] args) {
        SpringApplication.run(GifnocApplication.class, args);
    }

}
