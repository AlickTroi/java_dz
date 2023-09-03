
public class Item implements Comparable<Item> {

    private Integer amount;
    private String name;
    private String description;
    private Integer probabilityOfGetting;
    private Integer id;
    private static Integer count;


    public Item(String name, String description, Integer amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.probabilityOfGetting = 10;
        if (Item.count == null) {
            Item.count = 0; 
        } else {
            Item.count++;
        }
        this.id = Item.count;
    }

    public Item(String name, String description) { //переписать чрез this()
        this.name = name;
        this.description = description;
        this.amount = 0;
        this.probabilityOfGetting = 10;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id + "\n");
        sb.append("имя: " + this.name + "\n");
        sb.append("описание: " + this.description+ "\n");
        sb.append("количество: " + this.amount+ "\n");
        sb.append("шанс выпадения: " + this.probabilityOfGetting);
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProbabilityOfGetting() {
        return probabilityOfGetting;
    }

     public void setProbabilityOfGetting(Integer probabilityOfGetting) {
        if (bidProtection(probabilityOfGetting)) {
            this.probabilityOfGetting = probabilityOfGetting;
        }    
    }

    private boolean bidProtection(Integer probabilityOfGetting) {
        if (probabilityOfGetting > 100 || probabilityOfGetting < 0) {
           return false; 
        } else {
            return true;
        }
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void addAmount(Integer add) {
        this.amount += add;
    }

    public void depriveAmount(Integer remove){
        if (opportunityToDeprive(remove)) {
            this.amount -= remove;
        } 
    }
    
    public boolean opportunityToDeprive(Integer remove){
        if (this.amount - remove >= 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean similar(Item o){
        if (this.getId() == o.getId()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Item o) {
        return this.getId() - o.getId();
    }
    

}