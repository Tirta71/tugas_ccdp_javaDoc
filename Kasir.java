import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Item mewakili item yang akan dibeli, termasuk nama, harga, dan jumlah.
 */
class Item {
    private String name;
    private double price;
    private int quantity;

    /**
     * Konstruktor untuk membuat sebuah item.
     * 
     * @param name     Nama item.
     * @param price    Harga per satuan item.
     * @param quantity Jumlah item yang dibeli.
     */
    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Menghitung total harga dari item berdasarkan jumlah.
     * 
     * @return Total harga dari item.
     */
    public double getTotalPrice() {
        return price * quantity;
    }

    /**
     * Mendapatkan nama item.
     * 
     * @return Nama item.
     */
    public String getName() {
        return name;
    }

    /**
     * Mendapatkan harga satuan dari item.
     * 
     * @return Harga satuan dari item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Mendapatkan jumlah item yang dibeli.
     * 
     * @return Jumlah item yang dibeli.
     */
    public int getQuantity() {
        return quantity;
    }
}

/**
 * Kelas Kasir digunakan untuk mengelola daftar item yang dibeli dan menghitung
 * total pembayaran.
 */
public class Kasir {
    private ArrayList<Item> itemList;

    /**
     * Konstruktor untuk membuat kasir baru dengan daftar item kosong.
     */
    public Kasir() {
        itemList = new ArrayList<>();
    }

    /**
     * Menambahkan item baru ke daftar belanja.
     * 
     * @param item Item yang akan ditambahkan.
     */
    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * Menghitung total harga dari semua item yang ada di daftar belanja.
     * 
     * @return Total harga dari semua item.
     */
    public double calculateTotal() {
        double total = 0;
        for (Item item : itemList) {
            total += item.getTotalPrice();
        }
        return total;
    }

    /**
     * Menampilkan rincian dari setiap item yang dibeli.
     */
    public void displayItems() {
        System.out.println("Daftar Item yang Dibeli:");
        for (Item item : itemList) {
            System.out.printf("%s - Rp%.2f x %d = Rp%.2f\n", item.getName(), item.getPrice(), item.getQuantity(),
                    item.getTotalPrice());
        }
    }

    /**
     * Program utama yang digunakan untuk menjalankan kasir sederhana.
     * 
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kasir kasir = new Kasir();

        System.out.println("Program Kasir Sederhana");
        boolean tambahItem = true;

        while (tambahItem) {
            System.out.print("Masukkan nama item: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan harga item: ");
            double price = scanner.nextDouble();
            System.out.print("Masukkan jumlah item: ");
            int quantity = scanner.nextInt();

            // Membuat item baru dan menambahkannya ke daftar belanja
            Item item = new Item(name, price, quantity);
            kasir.addItem(item);

            // Membersihkan scanner buffer
            scanner.nextLine();

            System.out.print("Apakah Anda ingin menambah item lain? (y/n): ");
            String response = scanner.nextLine();
            tambahItem = response.equalsIgnoreCase("y");
        }

        // Menampilkan daftar item dan total harga
        kasir.displayItems();
        System.out.printf("Total Pembayaran: Rp%.2f\n", kasir.calculateTotal());

        scanner.close();
    }
}
