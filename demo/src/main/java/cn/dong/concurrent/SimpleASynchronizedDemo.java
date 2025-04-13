package cn.dong.concurrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dongzhenxun
 * @date 2025/4/1 下午3:13
 * @description 群友面腾讯时的面试题：ABCDEFGH8个线程，当ABC中有一个成功后，开始并发执行DEFG，当DEFG全部成功后执行H
 */
public class SimpleASynchronizedDemo {

    public void countDownLatchSolution() throws InterruptedException {
        CountDownLatch countDownLatchABC = new CountDownLatch(1);
        CountDownLatch countDownLatchDEFG = new CountDownLatch(4);

        Runnable taskABC = () -> {
            try {
                System.out.println("其中一个taskABC 执行成功");
                countDownLatchABC.countDown();
            } catch (Exception e) {
                System.out.println("其中一个taskABC 执行失败");
                throw new RuntimeException();
            }
        };

        Runnable taskDEFG = () -> {
            try {
                System.out.println("其中一个taskDEFG 执行成功");
                countDownLatchDEFG.countDown();
            } catch (Exception e) {
                System.out.println("其中一个taskABC 执行失败");
                throw new RuntimeException();
            }
        };

        Runnable taskH = () -> {
            try {
                System.out.println("taskH 执行成功");
            } catch (Exception e) {
                System.out.println("taskH 执行失败");
                throw new RuntimeException();
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for (int i = 1; i <= 3; i++) {
            threadPoolExecutor.submit(taskABC);
        }
        countDownLatchABC.await();
        for (int i = 1; i <= 4; i++) {
            threadPoolExecutor.submit(taskDEFG);
        }
        countDownLatchDEFG.await();

        threadPoolExecutor.submit(taskH);
    }

    public void completableFutureSolution() throws InterruptedException {

    }


    public static void main(String[] args) throws InterruptedException {

    }

}
