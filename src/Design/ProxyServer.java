package Design;

public class ProxyServer implements Server{

    private Server target;
    private String cacheData;

    public ProxyServer(Server target){
        this.target = target;
    }

    @Override
    public String play() {
        System.out.println("프록시서버 응답");
        if(cacheData == null){
            cacheData = target.play();
        }
        return cacheData;
    }
}
