/**
 * @author cphovo
 */
public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        String message = "Hello, world!";
        for (char ch : message.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(100);
        }
        System.out.println();
    }
}
