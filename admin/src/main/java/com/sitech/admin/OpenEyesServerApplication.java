package com.sitech.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author open_eyes
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
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
