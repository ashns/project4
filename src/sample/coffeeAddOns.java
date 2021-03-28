package sample;

import java.util.ArrayList;

public class coffeeAddOns extends MenuItem{
    final int CREAM = 1;
    final int SYRUP = 2;
    final int MILK = 3;
    final int CARAMEL = 4;
    final int WHIPPED_CREME = 5;

    int type;
    public coffeeAddOns(double price, int number, int type) {
        super(price, number);
        this.type = type;
    }

    public String getType() {
        switch (this.type) {
            case 1:
                return "cream";
            case 2:
                return "syrup";
            case 3:
                return "milk";
            case 4:
                return "caramel";
            case 5:
                return "whipped creme";
            default:
                return null;
        }
    }
}
