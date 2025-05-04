package java1.executor.test;

import java.util.concurrent.ExecutionException;

public class OldOrserServiceTaskMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234";
        MyOldOrderService orderService = new MyOldOrderService();
        orderService.order(orderNo);
    }
}
