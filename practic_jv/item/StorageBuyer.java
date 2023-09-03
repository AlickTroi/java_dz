

import java.util.PriorityQueue;

public class StorageBuyer {
    PriorityQueue<Item> priorityQueue;

    public StorageBuyer(){
        priorityQueue = new PriorityQueue<>();
    }

    public void addItem(Item item){
        priorityQueue.add(item);
    }

    public void clearItem(){
        priorityQueue.clear();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(priorityQueue.size());
        sb.append(" объектов: \n");
        for (Item item : priorityQueue) {
            sb.append("\n");
            sb.append(item.print());
            sb.append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }

    
}
