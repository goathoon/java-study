package java1.executor.test;

import java.util.List;
import java.util.concurrent.*;

import static java1.util.MyLogger.log;
import static java1.util.ThreadUtils.sleep;

public class MyOldOrderService {
    public void order(String orderNo) throws InterruptedException, ExecutionException {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        // 작업 요청
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<Boolean>> futures = es.invokeAll(List.of(inventoryWork, shippingWork, accountingWork));

        for (Future<Boolean> future : futures) {
            Boolean result = future.get();
            if(!result) {
                log("일부 작업이 실패했습니다");
                return;
            }
        }

        log("모든 주문 처리가 성공적으로 완료되었습니다.");

    }

    private static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() throws Exception {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    private static class ShippingWork implements Callable<Boolean> {
        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }

    }

    private static class AccountingWork implements Callable<Boolean>{
        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }

    }
}
