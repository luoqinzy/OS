package ProducerConsumerModel;

class Producer implements Runnable {
    private String name;
    private Basket basket;

    Producer(String name, Basket basket) {
        this.name = name;
        this.basket = basket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                basket.empty.acquire();
                Thread.sleep((long) (Math.random() % 100));
                basket.mutex.acquire();
                Thread.sleep(100);
                Apple apple = new Apple();
                basket.appleBasket.add(apple);
                System.out.println("我是" + this.name + "，我生产了一个苹果，篮子里共有" + basket.appleBasket.size() + "个苹果。");
                basket.mutex.release();
                basket.full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
