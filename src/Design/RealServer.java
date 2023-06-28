package Design;

public class RealServer implements Server {

    @Override
    public String play() {
        System.out.println("동영상 불러오기 시작");
        sleep(3000);
        return "세미나 동영상";
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
