package com.sitech.paas.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author open_eyes
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan("com.sitech.paas")
public class OpenEyesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenEyesServerApplication.class, args);
        System.out.println(
                        "########                             ###### #\n" +
                        " ##     #                           #     ###\n" +
                        " ##     #    ######      ######     #       #\n" +
                        " ##     #         ##          ##     ####    \n" +
                        " #######     #######     #######         ####\n" +
                        " ##         #     ##    #     ##    #       #\n" +
                        " ##         #     ##    #     ##    ###     #\n" +
                        "#####        ###### #    ###### #   # ###### ");
    }

}
