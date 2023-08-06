import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Exeptions.BornAbsence;
import Exeptions.ErorNumberOfElement;
import Exeptions.ErorTypeofElement;
import Exeptions.FioAbsence;
import Exeptions.GenderAbsence;
import Exeptions.PhoneAbsence;

// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:

public class GettinngData {
    Scanner scanner;
    VerificationInt isInt;
    String phone;
    String gender;
    String FIO;
    LocalDate born;

    GettinngData() {
        this.scanner = new Scanner(System.in);
        this.isInt = new VerificationInt();
    }

    public boolean creatHuman() {
        System.out.println(
                "ФИО через пробелы, дату рождения 3 числа через проелы, номер телефона только цыфры без +, пол f или m");
        System.out.println(
                "ВВедите данные о вас (ФИО, дату рождения (год, месяц, день), номер телефона, пол), через пробел: ");
        String dataHuman = scanner.nextLine();
        try {
            isSpliting(dataHuman);
        } catch (ErorNumberOfElement e) {
            System.out.println(e.getMessage());
            return false;
        } catch (ErorTypeofElement e) {
            System.out.println(e.getMessage());
            return false;
        } catch (GenderAbsence e) {
            System.out.println(e.getMessage());
            return false;
        } catch (PhoneAbsence e) {
            System.out.println(e.getMessage());
            return false;
        } catch (BornAbsence e) {
            System.out.println(e.getMessage());
            return false;
        } catch (FioAbsence e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }

    private void isSpliting(String dataHuman) throws ErorNumberOfElement, ErorTypeofElement, GenderAbsence, PhoneAbsence, BornAbsence, FioAbsence {
        // проверка на правильность ввода количества данных
        ArrayList<String> parseDataHuman = new ArrayList<>();

        String[] parseDataHumanArr = dataHuman.split(" ");
        if (!(parseDataHumanArr.length == 8)) {
            throw new ErorNumberOfElement(8);
        }

        // проверка на правильность ввода типа данных
        ArrayList<Boolean> isNum = new ArrayList<>();
        int countInt = 0;
        for (int i = 0; i < parseDataHumanArr.length; i++) {
            isNum.add(isInt.isNumeric(parseDataHumanArr[i]));
            if (isNum.get(i) == true) {
                countInt++;
            }
        }
        if (!(countInt == 3)) {
            throw new ErorTypeofElement();
        }

        // перевод массив в более удобный тип
        for (int i = 0; i < parseDataHumanArr.length; i++) {
            parseDataHuman.add(parseDataHumanArr[i]);
        }

        // добавление и удаление пола и телефона
        int delIndexFone = 0;
        int delIndexGender = 0;
        for (int i = 0; i < isNum.size(); i++) {
            if (isNum.get(i) == false && parseDataHuman.get(i).length() == 11) {
                if (isPhone(parseDataHuman.get(i))) {
                    this.phone = parseDataHuman.get(i);
                    delIndexFone = i;
                }
            }
            if (isNum.get(i) == false && (parseDataHuman.get(i).equals("f") || parseDataHuman.get(i).equals("m"))) {
                this.gender = parseDataHuman.get(i);
                delIndexGender = i;
            }
        }
        if (checkingForPhone() == false) {
            throw new PhoneAbsence();
        }
        if (checkingForGender() == false) {
            throw new GenderAbsence();
        }

        if (delIndexGender > delIndexFone) {
            isNum.remove(delIndexGender);
            isNum.remove(delIndexFone);

            parseDataHuman.remove(delIndexGender);
            parseDataHuman.remove(delIndexFone);

        } else {
            isNum.remove(delIndexFone);
            isNum.remove(delIndexGender);

            parseDataHuman.remove(delIndexFone);
            parseDataHuman.remove(delIndexGender);
        }

        // проверка правильности порядка типов
        int countStringInRow = 1;
        int maxStr = 0;
        int countIntInRow = 1;
        int maxInt = 0;
        for (int i = 1; i < isNum.size(); i++) {

            if (isNum.get(i) == false && isNum.get(i - 1) == false) {
                countStringInRow++;
            } else if (isNum.get(i) == false && isNum.get(i - 1) == true) {
                countStringInRow = 1;
            }
            if (maxStr < countStringInRow) {
                maxStr = countStringInRow;
            }
            if (isNum.get(i) == true && isNum.get(i - 1) == true) {
                countIntInRow++;
            } else if (isNum.get(i) == true && isNum.get(i - 1) == false) {

                countIntInRow = 1;
            }
            if (maxInt < countIntInRow) {
                maxInt = countIntInRow;
            }
        }

        if (maxInt != 3) {
            throw new BornAbsence();
        }

        if (maxStr != 3) {
            throw new FioAbsence();
        }

        // заполнение ФИО
        for (int i = 2; i < isNum.size(); i++) {
            if ((isNum.get(i - 2) == false && isNum.get(i - 1) == false && isNum.get(i) == false)) {
                // проверк на имя
                if (isFio(parseDataHuman.get(i - 2), parseDataHuman.get(i - 1), parseDataHuman.get(i))) {

                    this.FIO = parseDataHuman.get(i - 2) + " " + parseDataHuman.get(i - 1) + " "
                            + parseDataHuman.get(i);
                }
            }
        }

        if (checkingForFIO() == false) {
            throw new FioAbsence();
        }
        // заполнение Даты рождения
        for (int i = 2; i < isNum.size(); i++) {
            if ((isNum.get(i - 2) == true && isNum.get(i - 1) == true && isNum.get(i) == true)) {
                int yearInt = isInt.translationStringIntoInteger(parseDataHuman.get(i - 2));
                int monthInt = isInt.translationStringIntoInteger(parseDataHuman.get(i - 1));
                int dayInt = isInt.translationStringIntoInteger(parseDataHuman.get(i));
                try {
                    this.born = LocalDate.of(yearInt, monthInt, dayInt);
                } catch (Exception e) {
                    throw new BornAbsence();
                }
            }
        }

        if (checkingForBorn() == false) {
            throw new BornAbsence();
        }
    }

    private boolean checkingForBorn() {
        if (this.born != null) {
            return true;
        }
        return false;
    }

    private boolean checkingForFIO() {
        if (this.FIO != null) {
            return true;
        }
        return false;
    }

    private boolean checkingForPhone() {
        if (this.phone != null) {
            return true;
        }
        return false;
    }

    private boolean checkingForGender() {
        if (this.gender != null) {
            return true;
        }
        return false;
    }

    private boolean isFio(String name, String firstName, String lastName) {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                return false;
            }
        }
        for (int i = 0; i < firstName.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                return false;
            }
        }
        for (int i = 0; i < lastName.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPhone(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String getLastName() {
        return this.FIO.split(" ")[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ФИО : ");
        sb.append(FIO);
        sb.append("; ");
        sb.append("Телефон : ");
        sb.append(phone);
        sb.append("; ");
        sb.append("Пол : ");
        sb.append(gender);
        sb.append("; ");
        sb.append("Дата рождения : ");
        sb.append(born);
        return sb.toString();
    }
}
