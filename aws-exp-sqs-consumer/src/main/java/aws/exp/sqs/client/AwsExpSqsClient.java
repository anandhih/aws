package aws.exp.sqs.client;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import javax.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AwsExpSqsClient {

    @Getter
    @Value("${cloud.aws.region.static}")
    private String awsRegion;

    @Getter
    @Value("${cloud.aws.sqs.url}")
    private String awsSqsUrl;

    @Getter
    private AmazonSQS basicSqs;

    @PostConstruct
    private void init() {

        basicSqs = AmazonSQSAsyncClientBuilder.standard().withRegion(awsRegion).build();

    }
}
