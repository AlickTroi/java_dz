// 1) Дана строка sql-запроса "select * from students WHERE ".
//  Сформируйте часть WHERE этого запроса, используя StringBuilder.
//   Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// String input_str = "{"name":"Ivanov",
//  "country":"Russia", "city":"Moscow", "age":"null"}"
// Ввод данных: {"name":"Ivanov",
//  "country":"Russia", "city":"Moscow", "age":"null"}
// вывод: select * from students WHERE name=Ivanov
//  AND country=Russia AND city=Moscow


public class dz {
    public static void main(String[] args) {
        String str = "select * from students ";
        String where = "WHERE";
        String and = " AND";
        String[] input_str = { "name : Ivanov", "country : Russia", "city : Moscow", "age : null" };
        String[] part;
        StringBuilder resOne = new StringBuilder(str);
        Integer count = 0;
        for (int i = 0; i < input_str.length; i++) {
            part = input_str[i].split(" : ");
            if (!part[1].equals("null")) {
                if (count == 0) {
                    resOne.append(where);
                    count++;
                } else {
                    resOne.append(and);
                }
                resOne.append(" " + part[0] + "=" + part[1]);
            }
        }
        resOne.toString();
        System.out.println(resOne);
    }

}
