package com.aws.exp.sqs.service;


import com.amazonaws.services.sqs.model.SendMessageResult;
import com.aws.exp.sqs.client.AwsExpSqsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AwsMessagePublisherService {

    @Autowired
    private AwsExpSqsClient awsExpSqsClient;

    private int inc = 0;


    @Scheduled(fixedRate = 1000)
    private void sendMessage() {

        SendMessageResult result = awsExpSqsClient.getBasicSqs().sendMessage(awsExpSqsClient.getAwsSqsUrl(),
            "SQSMessage" + inc);

        log.info("Message id is {}", result.getMessageId());
    }

}
