package uit.trungdq.springboot.Utility;

import java.text.DecimalFormat;

public class ConvertUtility {
    public static String priceToString(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(price);
    }
}
