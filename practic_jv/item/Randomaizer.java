import java.util.Random;

public class Randomaizer {
    Storage<Item> items;
    Integer[] itemNumbers;
    Integer itemChances;
    Random random;

    public Randomaizer(Storage<Item> items){
        this.items = items;
        this.random = new Random();
        fillingItem();
    }


    private void fillingItem(){
        int counter = 0;
        Integer[] chances = new Integer[this.items.getSize() + 1];
        chances[0] = 0;
        int ind = 0;
        for (int i = 0; i < this.items.getSize(); i++) {
            if (this.items.getItem(i).getAmount() > 0) {
                counter += this.items.getItem(i).getProbabilityOfGetting();
                chances[ind + 1] = counter;  
                ind++;
            }
        }
        this.itemChances = counter;
        this.itemNumbers = chances;
    }

    public Item twistRandom(){
        int random = this.random.nextInt(this.itemChances);
        int seatchItem = binarySearch(random, 0, itemNumbers.length);
        if (this.items.getItem(seatchItem).getAmount() > 0){
            return this.items.getItem(seatchItem);
        } else {
            twistRandom();
            return this.items.getItem(seatchItem);
        }
        
    }

    private int binarySearch(int valueToFind, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.itemNumbers[mid] <= valueToFind && this.itemNumbers[mid + 1] <= valueToFind) {
                low = mid + 1;
            } else if (this.itemNumbers[mid] > valueToFind && this.itemNumbers[mid + 1] > valueToFind) {
                high = mid - 1;
            } else if (this.itemNumbers[mid] <= valueToFind && this.itemNumbers[mid + 1] >= valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }
}