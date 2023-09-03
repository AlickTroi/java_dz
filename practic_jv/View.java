import java.util.Scanner;

public class View {
    Item item;
    Storage<Item> storage;
    StorageBuyer sb;
    Randomaizer rb;
    boolean work;
    Scanner scanner;
    VerificationInt isInt;

    public View() {
        this.item = new Item(null, null);
        this.storage = new Storage<Item>();
        this.sb = new StorageBuyer();

        this.work = true;
        scanner = new Scanner(System.in);
        this.isInt = new VerificationInt();
    }

    private void greeting() {
        System.out.println("Здравствуйте, добро пожаловать в эту программу!");
    }

    public void start() {
        greeting();
        firstChoice();
        while (this.work == true) {
            secondChoice();
        }
    }

    private void firstChoice() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - добавить предмет");
        System.out.println("2 - выход");
        String line = scanner.nextLine();
        if (line.equals("1")) {
            addItem();
        } else if (line.equals("2")) {
            this.work = false;
        } else {
            System.out.println("Вы ввели не доступную команду, попробуйте еще");
            firstChoice();
        }
    }

    private void secondChoice() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - действия с рулеткой");
        System.out.println("2 - действия с инвентарем");
        System.out.println("3 - крутить рулетку");
        System.out.println("4 - выход");
        String line = scanner.nextLine();
        if (line.equals("1")) {
            rouletteAction();
        } else if (line.equals("2")) {
            inventoryAction();
        } else if (line.equals("3")) {
            twist();
        } else if (line.equals("4")) {
            this.work = false;
        } else {
            System.out.println("Вы ввели не доступную команду, попробуйте еще");
            secondChoice();
        }
    }

    public void twist() {
        this.rb = new Randomaizer(this.storage);
        item = rb.twistRandom();
        item.setAmount(1);
        sb.addItem(item);
    }

    

    private void rouletteAction() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - вывести предметы");
        System.out.println("2 - изменить количество предметов");
        System.out.println("3 - добавить предмет");
        System.out.println("4 - назад");
        System.out.println("5 - выход");
        String line = scanner.nextLine();
        if (line.equals("1")) {
            System.out.println(storage.getInfo());
        } else if (line.equals("2")) {
            changeTheNumberOfItem();
        } else if (line.equals("3")) {
            addItem();
        } else if (line.equals("4")) {
            secondChoice();
        } else if (line.equals("5")) {
            this.work = false;
        } else {
            System.out.println("Вы ввели не доступную команду, попробуйте еще");
            secondChoice();
        }
    }

    private void addItem() {
        System.out.println("Введитк название: ");
        String name = scanner.nextLine();
        System.out.println("Введитк описание: ");
        String description = scanner.nextLine();
        System.out.println("Введитк количество: ");
        String amount = scanner.nextLine();
        int amountInt = isInt.verificationInt(amount, 99999);
        this.item = new Item(name, description, amountInt);
        System.out.println("Введитк шанс выпадения: ");
        String chanse = scanner.nextLine();
        int chanseInt = isInt.verificationInt(chanse, 100);
        item.setProbabilityOfGetting(chanseInt);
        System.out.println(this.item.print());
        storage.add(item);
    }

    private void changeTheNumberOfItem() {
        System.out.println("Выберите предмет для измененния(по id)");
        System.out.println(storage.getInfo());
        String line = scanner.nextLine();
        Integer lineInt = isInt.verificationIntOfZero(line, storage.getSize());
        System.out.println(storage.getItem(lineInt).print());
        System.out.println("Выберите действие: ");
        System.out.println("1 - добавить предмет");
        System.out.println("2 - убрать предмет"); //TODO added funcion corect item
        System.out.println("3 - назад");
        line = scanner.nextLine();
        if (line.equals("1")) {
            addItemAmount(lineInt);
        } else if (line.equals("2")) {
            minusItem(lineInt);
        } else if (line.equals("3")) {
            rouletteAction();
        } else {
            System.out.println("Вы ввели не доступную команду, попробуйте еще");
            changeTheNumberOfItem();
        }

    }

    private void addItemAmount(int numberItem) {
        System.out.println("введите количество элементов для добавления: ");
        String line = scanner.nextLine();
        Integer LineInt = isInt.verificationInt(line, 99999);
        storage.getItem(numberItem).addAmount(LineInt);
    }

    private void minusItem(int numberItem) {
        System.out.println("введите количество элементов для убавления: ");
        String line = scanner.nextLine();
        Integer lineInt = isInt.verificationInt(line, storage.getItem(numberItem).getAmount());
        storage.getItem(numberItem).depriveAmount(lineInt);
    }

    private void inventoryAction() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - вывести предметы");
        System.out.println("2 - отчистить");
        System.out.println("3 - назад");
        System.out.println("4 - выход");
        String line = scanner.nextLine();
        if (line.equals("1")) {
            System.out.println(sb.getInfo());
        } else if (line.equals("2")) {
            sb.clearItem();
        } else if (line.equals("3")) {
            secondChoice();
        } else if (line.equals("4")){
            work = false;
        } else {
           System.out.println("Вы ввели не доступную команду, попробуйте еще"); 
           inventoryAction();
        }
    }

}
