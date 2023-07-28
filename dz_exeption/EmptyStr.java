// Разработайте программу, которая 
// выбросит Exception, когда пользователь 
// вводит пустую строку. Пользователю должно 
// показаться сообщение, что пустые строки вводить нельзя.

public class EmptyStr {

    public void ChecForEmpty(String parseInt) throws Exception {
        if (!isEmpty(parseInt)){
            throw new Exception("Вы ввели пустую строку!");
        }
    }

    private boolean isEmpty(String str) {
        if (str.isEmpty() || str.equals("")){
            return false;
        }
        return true;
    }

}
