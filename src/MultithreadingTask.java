

public class MultithreadingTask {

    public static void main(String[] args) {
        //создаем объект для синхронизации потоков
        Test test = new Test();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.hello();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.hello();
            }
        }).start();
    }
}

class Test {
    //в этом месте потоки синхронизируются на объекте test,
    // только один поток в одно время может находиться в методе
    public synchronized void hello() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}