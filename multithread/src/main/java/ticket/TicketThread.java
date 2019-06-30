package ticket;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-06-30 11:55
 *
 * reference:
 * https://blog.csdn.net/qq_34996727/article/details/80416277
 **/
public class TicketThread extends Thread {

    private static final Integer TOTAL = 100;
    private static Integer quantity = TOTAL;

    /** 有一个疑问：为什么不能直接对quantity加锁呢？我尝试了对quantity加锁，结果会出现多台机器同时卖同一张票的情况，
        但是既然是锁住了票对数量，为什么还会出现这种情况呢？
     */
    // 该字段相当与一个锁，因为在run方法中对这个锁同步，所以只有获得该锁的线程才能执行同步代码块
    private static String lock = "lock";

    public TicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (quantity > 0) {
            synchronized (quantity) {
                if (quantity > 0) {
                    System.out.println("通过" + getName() + "卖出了第" + quantity + "张票");
                    quantity--;
                } else {
                    System.out.println("票已经卖完");
                }
            }
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread1 = new TicketThread("ticketThread1");
        ticketThread1.setPriority(2);
        TicketThread ticketThread2 = new TicketThread("ticketThread2");
        ticketThread2.setPriority(1);
        TicketThread ticketThread3 = new TicketThread("ticketThread3");
        ticketThread3.setPriority(3);
        ticketThread1.start();
        ticketThread2.start();
        ticketThread3.start();
    }
}