package aws.exp.sqs.service;

import aws.exp.sqs.client.AwsExpSqsClient;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ReceiveMessageCommand implements Runnable {

    private AwsExpSqsClient awsExpSqsClient;

    public ReceiveMessageCommand(AwsExpSqsClient awsExpSqsClient) {

        this.awsExpSqsClient = awsExpSqsClient;
    }

    @Override
    public void run() {
        ReceiveMessageResult result = awsExpSqsClient.getBasicSqs().receiveMessage(awsExpSqsClient.getAwsSqsUrl());
        log.info("Message Received {}", result);
    }


}
