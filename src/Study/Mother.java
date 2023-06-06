package Study;

public class Mother {
    public int force ;
    public Mother(){
        System.out.println("부모 생성");
    }

    public Mother(int a){
        force = a;
        System.out.println("인자로 부모 생성");
    }
}
