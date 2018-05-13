package ProducerConsumerModel;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class Basket {

    Semaphore mutex = new Semaphore(1);
    Semaphore full = new Semaphore(0);
    Semaphore empty = new Semaphore(20);

    ArrayList<Apple> appleBasket;

    Basket(){
        appleBasket = new ArrayList<Apple>();
    }
}
