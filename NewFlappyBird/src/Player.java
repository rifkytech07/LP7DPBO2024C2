//Saya Muhammad Rifky Afandi dengan NIM 2202346 mengerjakan LP7 dalam mata kuliah Desain Pemrograman Berbasis Objek
// untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Image image;
    private int velocityY;

    // Konstruktor untuk kelas Player
    public Player(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;
        this.velocityY = 0; // Nilai awal kecepatan Y
    }

    // Metode setter untuk posisi X
    public void setPosX(int posX) {
        this.posX = posX;
    }

    // Metode setter untuk posisi Y
    public void setPosY(int posY) {
        this.posY = posY;
    }

    // Metode setter untuk lebar
    public void setWidth(int width) {
        this.width = width;
    }

    // Metode setter untuk tinggi
    public void setHeight(int height) {
        this.height = height;
    }

    // Metode setter untuk gambar
    public void setImage(Image image) {
        this.image = image;
    }

    // Metode setter untuk kecepatan Y
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    // Metode getter untuk posisi X
    public int getPosX() {
        return this.posX;
    }

    // Metode getter untuk posisi Y
    public int getPosY() {
        return this.posY;
    }

    // Metode getter untuk lebar
    public int getWidth() {
        return this.width;
    }

    // Metode getter untuk tinggi
    public int getHeight() {
        return this.height;
    }

    // Metode getter untuk gambar
    public Image getImage() {
        return this.image;
    }

    // Metode getter untuk kecepatan Y
    public int getVelocityY() {
        return this.velocityY;
    }

    // Metode untuk mendapatkan batas pemain (untuk deteksi tabrakan)
    public Rectangle2D.Double getBounds() {
        // Mengembalikan objek Rectangle2D.Double yang merepresentasikan batas pemain
        return new Rectangle2D.Double(posX, posY, width, height);
    }
}
