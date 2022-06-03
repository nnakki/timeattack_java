package java0603;

public class NatGateWay extends GateWay {
    private int id;
    private Subnet subnet;

    public NatGateWay(Subnet subnet) {
        this.subnet = subnet;
    }

    @Override
    void send(String message) {
        System.out.println("Nat : " + message);;
    }
}

