class Computer {
    private String cpu;
    private int ram;
    private int storage;

    private Computer(Builder b) {
        cpu = b.cpu;
        ram = b.ram;
        storage = b.storage;
    }

    public void display() {
        System.out.println(cpu + " " + ram + "GB " + storage + "GB");
    }

    static class Builder {
        private String cpu;
        private int ram;
        private int storage;

        Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        Builder setRAM(int ram) {
            this.ram = ram;
            return this;
        }

        Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Computer c = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM(16)
                .setStorage(512)
                .build();

        c.display();
    }
}
