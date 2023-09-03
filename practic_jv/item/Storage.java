import java.util.ArrayList;
import java.util.List;


public class Storage<E extends Item> {
    private List<E> items;

    public Storage(){
        this.items = new ArrayList<>();
    }

    public int getSize() {
        return items.size();
    }

    public void subtractAnItem(int indexItem){
        if (isSubtractAnItem(indexItem)) {
            items.get(indexItem).depriveAmount(1);
        } else {
            System.out.println("не удалось удалить");
        }
    }

    private boolean isSubtractAnItem(int indexItem){
        if (items.get(indexItem).getAmount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public E getItem(int numberItem){
        return items.get(numberItem);
    }

    public List<E> getItems() {
        return items;
    }

    public void add(E item) {
        items.add(item);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(items.size());
        sb.append(" объектов: \n");
        for (Item item : items) {
            sb.append("\n");
            sb.append(item.print());
            sb.append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }
}
