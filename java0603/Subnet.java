package java0603;

public class Subnet {

    private int id;
    private String region;
    private String ip;
    private RouteTable routeTable;

    public Subnet(int id, String ip, String region) {
        this.id = id;
        this.ip = ip;
        this.region = region;
    }

    public void setRouteTable(RouteTable routeTable){
        this.routeTable = routeTable;
    }

    public void transfer(String message){
        routeTable.getGateWay().send(message);
    }
}
