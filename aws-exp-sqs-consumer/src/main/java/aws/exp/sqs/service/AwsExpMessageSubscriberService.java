package aws.exp.sqs.service;

import aws.exp.sqs.client.AwsExpSqsClient;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AwsExpMessageSubscriberService {

    @Autowired
    private AwsExpSqsClient awsExpSqsClient;

    @Value("${cloud.aws.sqs.pollingThreads}")
    private int pollingThreads;

    @Value("${cloud.aws.sqs.pollingRate}")
    private int pollingRate;

    private ScheduledThreadPoolExecutor executor;

    @PostConstruct
    private void startSqsPoll() {

        executor = new ScheduledThreadPoolExecutor(pollingThreads);

        for (int worker = 0; worker < pollingThreads; worker++) {

            executor.scheduleAtFixedRate(new ReceiveMessageCommand(awsExpSqsClient), 0, pollingRate, TimeUnit.MILLISECONDS);


        }
    }


}
