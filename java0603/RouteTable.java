package java0603;

import java.util.ArrayList;
import java.util.List;

public class RouteTable {

    private int id;
    GateWay gateWay;
    List<Subnet> subnetList = new ArrayList<>();

    public void addSubnet(Subnet subnet) {
        this.subnetList.add(subnet);
        subnet.setRouteTable(this);
    }

    public void setGateWay(GateWay gateWay) {
        this.gateWay = gateWay;
    }

    public GateWay getGateWay() {
        return gateWay;
    }
}
