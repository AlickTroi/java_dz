import java.util.Scanner;

import Exeptions.NotFile;
import savinaAnLoad.Interf;
import savinaAnLoad.SavingFile;

public class Assembly {
    private GettinngData gt;
    private boolean flag;
    private Interf<GettinngData> sv;
    Scanner sc;

    public Assembly() {
        this.gt = new GettinngData();
        this.flag = true;
        this.sv = new SavingFile<GettinngData>();
        this.sc = new Scanner(System.in);
    }

    public void complat() {
        String s;
        this.flag = true;
        while (this.flag) {
            if (gt.creatHuman() && sv.saveFile(gt, gt.getLastName())) {
                System.out.println("человек добавлен");
            }
            System.out.println("хотите вывести список людей ?(y/n)");
            s = this.sc.nextLine();
            if (s.equals("y")) {
                System.out.println("введите фамилию человека: ");
                String name = this.sc.nextLine();
                try {
                    sv.loadFile(name);
                } catch (NotFile e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("хотите продолжить ?(y/n)");
            s = this.sc.nextLine();
            if (!s.equals("y")) {
                this.flag = false;
            }
        }
    }

    public static void main(String[] args) {
        Assembly n = new Assembly();
        n.complat();
    }

}
