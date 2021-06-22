package _12_collectionFramework.excercise;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
//        if (o1.getPrice()>o2.getPrice()) {
//            return 1;
//        }else if (o1.getPrice() < o2.getPrice()) {
//            return -1;
//        }else {
//            return 0;
//        }
        return (int) (o2.getPrice() - o1.getPrice());
    }
}