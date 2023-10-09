package Study.Thread;

public class Main2 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("my thread");
        //스레드 내에서 발생한 에러가 어디에서도 캐치되지 않으면 핸들러가 호출될 겁니다.
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //로그를 남기면 추후 우리가 해결가능
                System.out.println("A critical error happened in thread " + t.getName()
                                +" the error is "+e.getMessage());
            }
        }); //예외 핸들러 지정 가능
        thread.start();
    }
}
