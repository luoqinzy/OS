package ProducerConsumerModel;

class Consumer implements Runnable {
    private String name;
    private Basket basket;

    Consumer(String name, Basket basket) {
        this.name = name;
        this.basket = basket;
    }


    @Override
    public void run() {
        while (true) {
            try {
                basket.full.acquire();
                Thread.sleep((long) (Math.random() % 100));
                basket.mutex.acquire();
                Thread.sleep(100);
                basket.appleBasket.remove(0);
                System.out.println("我是" + this.name + "，我消费了一个苹果，篮子里还有" + basket.appleBasket.size() + "个苹果。");
                basket.mutex.release();
                basket.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
