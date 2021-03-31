package sample;

public class Coffee extends MenuItem implements Customizable{

    final int SIZE_SHORT = 1;
    final int SIZE_TALL = 2;
    final int SIZE_GRANDE = 3;
    final int SIZE_VENTI = 4;
    final double SHORT_PRICE = 1.99;
    final double TALL_PRICE = 2.49;
    final double GRANDE_PRICE = 2.99;
    final double VENTI_PRICE = 3.49;
    final double ADDON_COST = .20;
    boolean hasAddOns = false;
    final int CREAM = 0;
    final int SYRUP = 1;
    final int MILK = 2;
    final int CARAMEL = 3;
    final int WHIPPED_CREME = 4;

    int size;
    String[] addOns;

    public Coffee(int size, int quantity, String addOns[]) {
        super(quantity);
        this.size = size;
        this.addOns = addOns;
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof String){
            String temp = (String)obj;
            if(temp.equals("cream")){
                addOns[CREAM] = "cream";
                return true;
            }
            else if(temp.equals("syrup")){
                addOns[SYRUP] = "syrup";
                return true;
            }
            else if(temp.equals("milk")){
                addOns[MILK] = "milk";
                return true;
            }
            else if(temp.equals("caramel")){
                addOns[CARAMEL] = "caramel";
                return true;
            }
            else{
                addOns[WHIPPED_CREME] = "whipped creme";
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof String){
            String temp = (String)obj;
            for(int i = 0; i<addOns.length; i++){
                if(addOns[i].equals(temp)){
                    addOns[i]=null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String message = "(" + quantity + ") " + " " ;
        switch (size){
            case SIZE_SHORT:
                message += "short coffee";
                break;
            case SIZE_TALL:
                message += "tall coffee";
                break;
            case SIZE_GRANDE:
                message += "grande coffee";
                break;
                case SIZE_VENTI:
                message += "venti coffee";
                break;
            default:
                message += "bagel";
        }

        if(quantity > 1 || quantity <= 0) message += "s";
        for(int i = 0; i < 5; i++) {
            String tempMessage = "";
            if ((addOns[i] == null)) {
                continue;
            } else {
                if (hasAddOns == false) {
                    tempMessage += " with " + addOns[i];
                } else {
                    tempMessage += ", " + addOns[i];
                }
            }
           message += tempMessage;
        }
        return message + "\n";
    }
}

