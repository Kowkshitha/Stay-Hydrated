package om.example.stayhydrated;

import java.sql.Timestamp;
import java.util.Date;

public class WaterQuantity{
    private enum QtyEnum {QTY_50, QTY_200, QTY_350};
    private final Timestamp timestamp;
    private QtyEnum qty;

    private WaterQuantity(QtyEnum qty){
        this.timestamp = new Timestamp(new Date().getTime());
        this.qty = qty;
    }

    static WaterQuantity getQty50()
    {
        return new WaterQuantity(QtyEnum.QTY_50);
    }

    static WaterQuantity getQty200(){
        return new WaterQuantity(QtyEnum.QTY_200);
    }

    static WaterQuantity getQty350(){
        return new WaterQuantity(QtyEnum.QTY_350);
    }

    int getImageId(){
        switch (this.qty) {
            case QTY_50:
                return R.drawable.icons8_water_droplet;
            case QTY_200:
                return R.drawable.icons8_water_glass;
            case QTY_350:
                return R.drawable.icons8_water_bottle;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String toString(){
        switch (this.qty){
            case QTY_50:
                return "50ml";
            case QTY_200:
                return "200ml";
            case QTY_350:
                return "350ml";
            default:
                throw new IllegalArgumentException();
        }
    }

    String getTime(){

        return "[4:56:02]";
    }

}