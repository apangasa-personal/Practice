package scaler.LLD.BuilderDesignPattern;

public class ComputerClient {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                .setCache(8)
                .setHardDisk(2)
                .setHdmiPortCount(2)
                .setMonitorSize(15.6)
                .setCoreCount(8)
                .setOperatingSystem("Windows 11")
                .setRamSize(8)
                .setProcesssor("AMD Ryzen 5 2600")
                .setUsbPortCount(3)
            .build();
        computer.printSpec();

    }
}
