package java2.network.tcp.chatting;

public abstract class CommandUtils {

    public static String parseJoinName(String message) {
        return validateJoinMessage(message, "/join");
    }

    private static String validateJoinMessage(String message, String command) {
        String[] split = message.split("\\|");
        if(split.length != 2 || !split[0].equals(command)) {
            throw new RuntimeException("잘못된 입력! 다시 입력하세요");
        }
        return split[1];
    }
    public static void validateAfterMessage(String message) {
        String[] split = message.split("\\|");
        if(split.length == 1 &&
                (split[0].equals("/exit")) || split[0].equals("/users")) return;

        if(split.length == 2 &&
                (split[0].equals("/message") || split[0].equals("/change"))) return;

        throw new RuntimeException("잘못된 입력 ! 다시 입력하세요");
    }
}
