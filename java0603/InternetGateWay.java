package java0603;

public class InternetGateWay extends GateWay{
    private int id;
    @Override
    void send(String message) {
        System.out.println("Internet : " + message);;
    }
}
