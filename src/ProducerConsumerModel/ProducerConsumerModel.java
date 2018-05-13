package ProducerConsumerModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerModel {
    public static void main(String args[]){

        Basket basket = new Basket();

        Producer producer1 = new Producer("Producer1", basket);
        Producer producer2 = new Producer("Producer2", basket);
        Producer producer3 = new Producer("Producer3", basket);

        Consumer consumer1 = new Consumer("Consumer1", basket);
        Consumer consumer2 = new Consumer("Consumer2", basket);
        Consumer consumer3 = new Consumer("Consumer3", basket);
        Consumer consumer4 = new Consumer("Consumer4", basket);
        Consumer consumer5 = new Consumer("Consumer5", basket);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        service.execute(consumer4);
        service.execute(consumer5);

    }

}
