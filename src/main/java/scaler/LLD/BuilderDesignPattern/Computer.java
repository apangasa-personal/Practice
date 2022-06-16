package scaler.LLD.BuilderDesignPattern;

import java.security.InvalidParameterException;

public class Computer {
    int ramSize, coreCount, hardDisk, cache, usbPortCount, hdmiPortCount;
    double monitorSize;
    String processsor, operatingSystem;

    private Computer(){}

    public void printSpec(){
        System.out.println("Printing specs of computer" +
                "\nRam Size: " + this.ramSize +
                "\nCore Count: " + this.coreCount +
                "\nHard Disk: " + this.hardDisk +
                "\nCache: " + this.cache +
                "\nUSB Port Count: " + this.usbPortCount +
                "\nHDMI Port Count: " + this.hdmiPortCount +
                "\nMonitor Size: " + this.monitorSize +
                "\nProcessor: " + this.processsor +
                "\nOperating System: " + this.operatingSystem);
    }

    public static class ComputerBuilder{
        int ramSize, coreCount, hardDisk, cache, usbPortCount, hdmiPortCount;
        double monitorSize;
        String processsor, operatingSystem;

         public ComputerBuilder setRamSize(int ramSize){
             this.ramSize = ramSize;
             return this;
         }

        public ComputerBuilder setCoreCount(int coreCount){
            this.coreCount = coreCount;
            return this;
        }

        public ComputerBuilder setHardDisk(int hardDisk){
            this.hardDisk = hardDisk;
            return this;
        }

        public ComputerBuilder setCache(int cache){
            this.cache = cache;
            return this;
        }

        public ComputerBuilder setUsbPortCount(int usbPortCount){
            this.usbPortCount = usbPortCount;
            return this;
        }

        public ComputerBuilder setHdmiPortCount(int hdmiPortCount){
            this.hdmiPortCount = hdmiPortCount;
            return this;
        }

        public ComputerBuilder setMonitorSize(double monitorSize){
            this.monitorSize = monitorSize;
            return this;
        }

        public ComputerBuilder setProcesssor(String processsor){
            this.processsor = processsor;
            return this;
        }

        public ComputerBuilder setOperatingSystem(String operatingSystem){
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build(){
             if(this.ramSize == 0)
                 throw new InvalidParameterException("Ram Size should not be 0");

            if(this.coreCount == 0)
                throw new InvalidParameterException("Core count should not be 0");

            if(this.hardDisk == 0)
                throw new InvalidParameterException("Hard Dish size should not be 0");

            Computer computer = new Computer();
            computer.ramSize = this.ramSize;
            computer.usbPortCount = this.usbPortCount;
            computer.hdmiPortCount = this.hdmiPortCount;
            computer.processsor = this.processsor;
            computer.operatingSystem = operatingSystem;
            computer.cache = this.cache;
            computer.coreCount = this.coreCount;
            computer.monitorSize = this.monitorSize;
            computer.hardDisk = this.hardDisk;
            return computer;
        }
    }
}
