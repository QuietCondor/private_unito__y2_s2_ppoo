public class SmartDeviceTest {
    public static void main(String[] args) {
        SmartDevice dev1 = new SmartDevice("Termostato", true);
        SmartDevice dev2 = new SmartDevice("Telecamera", false);
        SmartDevice dev3 = new SmartDevice();

        System.out.println("Dev1: " + dev1);
        System.out.println("Dev2: " + dev2);
        System.out.println("Dev3: " + dev3);

        System.out.println("Dev1 equals Dev2: " + dev1.equals(dev2));
        System.out.println("Dev1 equals Dev1: " + dev1.equals(dev1));

        dev1.toggleStatus();
        System.out.println("Dev1 after toggle: " + dev1);

        System.out.println("Total smart devices created: " + SmartDevice.getTotalDevices());

        SmartLight light = new SmartLight("Lampada Studio", true, 80);
        System.out.println("SmartLight before toggle: " + light);
        light.toggleStatus();
        System.out.println("SmartLight after toggle: " + light);
    }
}