//Saya Muhammad Rifky Afandi dengan NIM 2202346 mengerjakan LP7 dalam mata kuliah Desain Pemrograman Berbasis Objek
// untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

import javax.swing.*;

public class App {
    // Metode main
    public static void main(String[] args){
        // Membuat objek JFrame untuk menampung permainan Flappy Bird
        JFrame frame = new JFrame("Flappy Bird");

        // Mengatur operasi default saat tombol close di JFrame ditekan
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur ukuran frame
        frame.setSize(360, 640);

        // Mengatur frame agar muncul di tengah layar
        frame.setLocationRelativeTo(null);

        // Mengatur frame agar tidak dapat diubah ukurannya
        frame.setResizable(false);

        //frame.setVisible(true);

        // Membuat objek FlappyBird (kelas yang menggambar dan mengontrol permainan)
        FlappyBird flappyBird = new FlappyBird();

        // Menambahkan objek FlappyBird ke dalam frame
        frame.add(flappyBird);

        // Memastikan semua komponen telah ditambahkan ke frame
        frame.pack();

        // Mengatur fokus ke objek FlappyBird sehingga pengguna dapat langsung berinteraksi dengan permainan
        flappyBird.requestFocus();

        // Menampilkan frame ke layar
        frame.setVisible(true);
    }
}

