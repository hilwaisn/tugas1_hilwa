import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> namaList = new ArrayList<>();
        ArrayList<Integer> nilaiList = new ArrayList<>();    
        System.out.println("Data Nilai Mahasiswa Mata Kuliah Perpajakan");

        while (true) {
            System.out.println(
                    "Menu : \n1. Tambah data mahasiswa\n2. Update data mahasiswa\n3. Delete data mahasiswa\n4. Lihat semua data mahasiswa\n5. Cari data mahasiswa berdasarkan nama\n6. Keluar dari program");
            System.out.print("Pilih opsi : ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) {
                System.out.print("Nama : ");
                String nama = input.nextLine();
                boolean check = false;
                for (int i = 0; i < namaList.size(); i++) {
                    if (namaList.get(i).equalsIgnoreCase(nama)) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    System.out.println("Nama mahasiswa sudah ada");
                } else {
                    namaList.add(nama);
                    System.out.print("Nilai : ");
                    int nilai = input.nextInt();
                    input.nextLine();
                    nilaiList.add(nilai);
                    System.out.println("Data mahasiswa berhasil ditambahkan");
                }
            } else if (pilih == 2) {
                System.out.print("Nama : ");
                String nama = input.nextLine();
                if (namaList.contains(nama)) {
                    int index = namaList.indexOf(nama);
                    System.out.print("Nilai baru : ");
                    int nilaiBaru = input.nextInt();
                    input.nextLine();
                    nilaiList.set(index, nilaiBaru);
                    System.out.println("Data mahasiswa berhasil diupdate");
                } else {
                    System.out.println("Nama mahasiswa tidak ditemukan");
                }
            } else if (pilih == 3) {
                System.out.print("Nama : ");
                String nama = input.nextLine();
                if (namaList.contains(nama)) {
                    int index = namaList.indexOf(nama);
                    namaList.remove(index);
                    nilaiList.remove(index);
                    System.out.println("Data mahasiswa berhasil dihapus");
                } else {
                    System.out.println("Nama mahasiswa tidak ditemukan");
                }
            } else if (pilih == 4) {
                if (namaList.isEmpty()) {
                    System.out.println("Data mahasiswa kosong");
                } else {
                    for (int i = 0; i < namaList.size(); i++) {
                        String nama = namaList.get(i);
                        int nilai = nilaiList.get(i);
                        String grade = calculateGrade(nilai);
                        System.out.println("Nama: " + nama + ", Nilai: " + nilai + " (" + grade + ")");
                    }
                }
            } else if (pilih == 5) {
                System.out.print("Nama: ");
                String namaCari = input.nextLine();
                if (namaList.contains(namaCari)) {
                    int index = namaList.indexOf(namaCari);
                    int nilai = nilaiList.get(index);
                    String grade = calculateGrade(nilai);
                    System.out.println("Nama: " + namaCari + ", Nilai: " + nilai + " (" + grade + ")");
                } else {
                    System.out.println("Nama mahasiswa tidak ditemukan");
                }
            } else if (pilih == 6) {
                System.out.println("Keluar dari program");
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }
        }
        input.close();
    }

    private static String calculateGrade(int nilai) {
        if (nilai >= 85 && nilai <= 100) {
            return "A";
        } else if (nilai >= 70 && nilai <= 84) {
            return "B";
        } else if (nilai >= 55 && nilai <= 69) {
            return "C";
        } else if (nilai >= 40 && nilai <= 54) {
            return "D";
        } else {
            return "E";
        }
    }
}