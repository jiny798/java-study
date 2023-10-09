package Study.Thread;

public class Main3 {
    public static void main(String[] args) {
        //새로운 스레드에서 코드를 스케줄링하는 두번째 방법
        //Runnable 객체를 만드는 대신 스레드를 확장하는 새 클래스를 만드는 것
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread{ // 스레드 클래스에 Runnable 인터페이스 자체가 구현되어 있다.. 오버라이드만 해주면됩니다

        @Override
        public void run() {
//            System.out.println("NewThread from "+Study.Thread.currentThread().getName());
                // 정적 메서드를 호출하는대신
            System.out.println("NewThread from "+this.getName());
//            this.setPriority(); //우선순위 정보등 직접 접근 가능
        }
    }
}
