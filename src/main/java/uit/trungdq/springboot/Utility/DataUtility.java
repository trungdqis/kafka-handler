package uit.trungdq.springboot.Utility;

import uit.trungdq.springboot.payload.CartItem;
import uit.trungdq.springboot.payload.Customer;
import uit.trungdq.springboot.payload.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataUtility {
    public static List<Customer> getListCustomers() {
        return Arrays.asList(new Customer(1L, "Dang", "Trung", "0359904878", "BCON Suoi Tien, Di An, Binh Duong"),
                new Customer(2L, "Nguyen", "Vu", "0939851755 ", "15D Le Thanh Ton, quan 1"),
                new Customer(3L, "Tran", "Vu", "0733878301", "284 An Duong Vuong, phuong 4, quan 5"),
                new Customer(4L, "Nguyen", "Thinh", "0893870093", "29B Nguyen Dinh Chieu, quan 1"),
                new Customer(5L, "Dang", "Nhanh", "0313652394 ", "17 Hang Giao, Dong Da, Ha Noi"),
                new Customer(6L, "Tran", "Lan", "0637870521", "47 Tran Hung Dao, Hoan Kiem, Ha Noi"),
                new Customer(7L, "Doan", "Trang", "0862957535", "01K1 Nguyen Thai Hoc, phuong 7, Vung Tau"),
                new Customer(8L, "Nguyen", "Ngan", "0939694908", "1 Thuy Xuong, phuong Phuong Son, Khanh Hoa"),
                new Customer(9L, "Nguyen", "Thinh", "0651388618", "Tran Quang Dieu, Qui Nhon, Binh Dinh"),
                new Customer(10L, "Phan", "Y", "0432511960", "Nam Tra Khuc, Quang Ngai")
        );
    }

    public static List<Product> getListProducts() {
        return Arrays.asList(new Product(1L, "iPhone 14 Pro Max 128GB", "IP_14_PM_128", 32990000,
                "", "Description", "APPLE"),
                new Product(2L, "iPhone 14 Pro 128GB", "IP_14_P_128", 30390000,
                        "", "Description", "APPLE"),
                new Product(3L, "iPhone 14 Plus 128GB", "IP_14_PS_128", 23590000,
                        "", "Description", "APPLE"),
                new Product(4L, "iPhone 14 256GB", "IP_14_256", 22990000,
                        "", "Description", "APPLE"),
                new Product(5L, "Samsung Galaxy S22 Ultra (8GB - 128GB)", "S22_U_8_128", 22090000,
                        "", "Description", "SAMSUNG"),
                new Product(6L, "Samsung Galaxy Z Flip4 128GB", "Z_FLIP4_128", 20590000,
                        "", "Description", "SAMSUNG"),
                new Product(7L, "Samsung Galaxy Z Fold4", "Z_FOLD4", 35990000,
                        "", "Description", "SAMSUNG"),
                new Product(8L, "Loa Bluetooth JPL PartyBox 310", "JPL_PB_310", 15100000,
                        "", "Description", "JPL"),
                new Product(9L, "Loa Bluetooth JPL Boombox 3", "JPL_BB_3", 10790000,
                        "", "Description", "JPL"),
                new Product(10L, "Tai nghe Sony WH-1000XM5", "WH_1000XM5", 7790000,
                        "", "Description", "SONY"));
    }

    public static List<CartItem> getListCartItems() {
        return Arrays.asList(new CartItem(getListCustomers().get(0), getListProducts().get(1), 1),
                new CartItem(getListCustomers().get(0), getListProducts().get(2), 1),
                new CartItem(getListCustomers().get(0), getListProducts().get(7), 3),
                new CartItem(getListCustomers().get(1), getListProducts().get(3), 2),
                new CartItem(getListCustomers().get(1), getListProducts().get(6), 6),
                new CartItem(getListCustomers().get(1), getListProducts().get(9), 1),
                new CartItem(getListCustomers().get(2), getListProducts().get(4), 6),
                new CartItem(getListCustomers().get(2), getListProducts().get(5), 2),
                new CartItem(getListCustomers().get(2), getListProducts().get(6), 4),
                new CartItem(getListCustomers().get(3), getListProducts().get(1), 5),
                new CartItem(getListCustomers().get(3), getListProducts().get(2), 3),
                new CartItem(getListCustomers().get(3), getListProducts().get(3), 1),
                new CartItem(getListCustomers().get(4), getListProducts().get(3), 4),
                new CartItem(getListCustomers().get(4), getListProducts().get(4), 7),
                new CartItem(getListCustomers().get(4), getListProducts().get(7), 3),
                new CartItem(getListCustomers().get(5), getListProducts().get(7), 3),
                new CartItem(getListCustomers().get(5), getListProducts().get(8), 4),
                new CartItem(getListCustomers().get(5), getListProducts().get(9), 5),
                new CartItem(getListCustomers().get(6), getListProducts().get(2), 1),
                new CartItem(getListCustomers().get(6), getListProducts().get(4), 2),
                new CartItem(getListCustomers().get(6), getListProducts().get(6), 4),
                new CartItem(getListCustomers().get(7), getListProducts().get(2), 6),
                new CartItem(getListCustomers().get(7), getListProducts().get(3), 7),
                new CartItem(getListCustomers().get(7), getListProducts().get(7), 3),
                new CartItem(getListCustomers().get(8), getListProducts().get(4), 4),
                new CartItem(getListCustomers().get(8), getListProducts().get(7), 1),
                new CartItem(getListCustomers().get(8), getListProducts().get(9), 1),
                new CartItem(getListCustomers().get(9), getListProducts().get(1), 2),
                new CartItem(getListCustomers().get(9), getListProducts().get(5), 5),
                new CartItem(getListCustomers().get(9), getListProducts().get(3), 5)
        );
    }

    public static int randomWithRange(int minValue, int maxValue) {
        Random rand = new Random();
        return rand.nextInt((maxValue - minValue) + 1) + minValue;
    }
}
