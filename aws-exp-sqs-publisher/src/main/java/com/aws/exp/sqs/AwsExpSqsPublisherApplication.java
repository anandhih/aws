package com.aws.exp.sqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwsExpSqsPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsExpSqsPublisherApplication.class, args);
    }

}
