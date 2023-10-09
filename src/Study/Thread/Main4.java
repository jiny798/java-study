package Study.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4 {
    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for(Thread thread : threads){
            thread.start();
        }

    }

    private static class Vault { //금고 클래스 
        private int password;
        public Vault(int password){
            this.password = password;
        }

        public boolean isCorrectPassword(int guess){
            try{
                Thread.sleep(5); //해커의 속도를 늦추기 위해 5밀리초 지연 응답
            }catch (InterruptedException e){

            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread{ // 스레드를 확장하여 스레드 그룹의 공통적인 기능 캡슐화
        protected Vault vault;

        public HackerThread(Vault vault){
            this.vault = vault;
            this.setName(this.getClass().getSimpleName()); //각각의 해컬 스레드는 클래스 이름을 스레드 이름으로 쓰고
            this.setPriority(Thread.MAX_PRIORITY); //우선 순위도 최대값으로 설정
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread{
        public AscendingHackerThread(Vault vault){
            super(vault);
        }

        @Override
        public void run(){
            for (int guess = 0 ; guess <= MAX_PASSWORD ; guess++){
                if(vault.isCorrectPassword(guess)){
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread{
        public DescendingHackerThread(Vault vault){
            super(vault);
        }

        @Override
        public void run(){
            for (int guess = MAX_PASSWORD ; guess >= 0 ; guess--){
                if(vault.isCorrectPassword(guess)){
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread{
        @Override
        public void run(){
            for (int i = 20 ; i > 0 ; i--){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
                System.out.println(i);
            }

            System.out.println("sucess catch all hackers");
            System.exit(0);
        }
    }
}
