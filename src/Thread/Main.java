package Thread;

import PRG.sort.Solution;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //JDK에서 스레드에 관련된 속성 메서드를 스레드 클래스로 압축시켜 놨습니다.

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //어떤 코드를 넣든 운영체제에서 스케쥴링 되면 새 스레드에서 실행된다
                System.out.println("new thread : "+ Thread.currentThread().getName());
                System.out.println("Current thread priority is "+ Thread.currentThread().getPriority());
            }
        });

//        thread.start();
        // start를 호출해서 스레드를 시작시켜줘야 한다
        // JVM 이 새 스레드를 생성해 운영체제에게 전달

        thread.setName("New Thread"); //스레드의 이름을 지정해줄수있다. 추적에 도움
        thread.setPriority(Thread.MAX_PRIORITY); //뜻????

        System.out.println("here is in thread:"+Thread.currentThread().getName()+" before starting a new thread");
        thread.start();
        System.out.println("here is in thread:"+Thread.currentThread().getName()+" after starting a new thread");

        Thread.sleep(10000);
    }
}