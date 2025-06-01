package java2.network.tcp.autocloseable;

public class ResourceCloseMainV2 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("Call Exception 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("Close Exception 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;
        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            System.out.println("자원 정리"); // 호출 안됨
            // 자원 열었던 순서와 반대로 닫아야한다! (물론 여기에서는 참조가 없긴 하지만)
            if(resource2 != null) {
                resource2.closeEx();
            }
            if(resource1 != null) {
                resource1.closeEx(); // resource2에서 exception 발생하여 이 코드는 호출 안됨
            }
        }
    }
}
