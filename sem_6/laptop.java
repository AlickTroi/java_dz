package sem_6;

// 1 - ОЗУ
// 2 - Объем ЖД hd hdd
// 3 - Операционная система
// 4 - Цвет

public class laptop {

    String name;
    String ram;
    String memoryCapacity;
    String workingSystem;
    String color;

    public void laptop(String name, String ram, String memoryCapacity, String workingSystem, String color) {
        this.name = name;
        this.ram = ram;
        this.memoryCapacity = memoryCapacity;
        this.workingSystem = workingSystem;
        this.color = color;
    }

    public String getRam() {
        return this.ram;
    }

    public String getMemoryCapacity() {
        return this.memoryCapacity;
    }

    public String getWorkingSystem() {
        return this.workingSystem;
    }

    public String getColor() {
        return this.color;
    }

    public String setMemoryCapacity(String memoryCapacity) {
        return this.memoryCapacity = memoryCapacity;
    }

    public String setColor(String color) {
        return this.color = color;
    }

    public String setWorkingSystem(String workingSystem) {
        return this.workingSystem = workingSystem;
    }

    public String setRam(String ram) {
        return this.ram = ram;
    }

    public void printLaptop() {
        System.out.println("Название ПК: " + this.name + "\n" + "ОЗУ: " + this.ram + "\n" + "Объем ЖД: " + this.memoryCapacity + "\n" + "Операционная система: " + this.workingSystem + "\n" + "Цвет: " + this.color);
    }

        public boolean filter(String character, String filter) {
            switch (character) {
                case "ram":
                    if (filter == this.ram) {
                        return true;
                    }
                    break;
                case "memoryCapacity":
                    if (filter == this.memoryCapacity) {
                        return true;
                    }
                break;

                case "workingSystem":
                    if (filter == this.workingSystem) {
                        return true;
                    }
                break;
        
                case "color":
                    if (filter == this.color) {
                        return true;
                    }
                break;

                default:
                    break;
            }

            return false;
    }
}
