package sample;

import java.util.ArrayList;

public class coffeeAddOns extends MenuItem{
    final int CREAM = 0;
    final int SYRUP = 1;
    final int MILK = 2;
    final int CARAMEL = 3;
    final int WHIPPED_CREME = 4;

    int type;
    public coffeeAddOns(double price, int number, int type) {
        super(number);
        this.type = type;
    }

    public String getTypeString() {
        switch (this.type) {
            case CREAM:
                return "cream";
            case SYRUP:
                return "syrup";
            case MILK:
                return "milk";
            case CARAMEL:
                return "caramel";
            case WHIPPED_CREME:
                return "whipped creme";
            default:
                return null;
        }
    }

    public int getType(){
        return this.type;
    }
}
