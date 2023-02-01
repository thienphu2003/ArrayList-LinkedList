import java.util.*;
public class Product2 {
    private int id;
    private String name;

    public Product2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static class ProductManager {
        List<Product> storage;

        public ProductManager() {
            storage = new LinkedList<>();
        }

        private void add(Product product) {
            storage.add(product);
        }

        private void changeNameByID(int id, String name) {
            for (Product p : storage) {
                if (p.id == id) {
                    p.name = name;
                }
            }
        }

        private void delete(int id) {
            for (Product p : storage) {
                if (p.id == id) {
                    storage.remove(p);
                }
            }
        }

        private void show() {
            for (Product s : storage) {
                System.out.println(s.name);
            }
        }

        private int find(String name) {
            for (Product p : storage) {
                if (p.name == name)
                    return p.id;
            }
            return -1;
        }

        private void sort() {
            for (int i = 0; i < storage.size() - 1; i++) {
                for (int j = i + 1; j < storage.size(); j++) {
                    if (storage.get(i).id > storage.get(j).id) {
                        String temp = storage.get(i).name;
                        storage.get(i).name = storage.get(j).name;
                        storage.get(j).name = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Product one = new Product(1, "Khăn tắm");
        Product two = new Product(2, "Bóp");
        ProductManager pm = new ProductManager();
        pm.add(one);
        pm.add(two);
        pm.changeNameByID(2, "Bình nước");
        pm.delete(1);
        Product three = new Product(3, "Ghế");
        Product four = new Product(4, "Bàn");
        pm.add(one);
        pm.add(three);
        pm.add(four);
        pm.sort();
        pm.show();


    }

}
