package reactive.programming;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class Main {
    public static final void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        TransformProcessor<String, Integer> transformProcessor = new TransformProcessor<>(Integer::parseInt);
        EndSubscriber<Integer> subscriber = new EndSubscriber<>();
        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);
        List<String> items = List.of("1", "2", "3");
        items.forEach(publisher::submit);
        publisher.close();
        Thread.sleep(1000);
    }
}
