//Saya Muhammad Rifky Afandi dengan NIM 2202346 mengerjakan LP7 dalam mata kuliah Desain Pemrograman Berbasis Objek
// untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Pipe {
    private int posX;           // Posisi X pipa
    private int posY;           // Posisi Y pipa
    private int width;          // Lebar pipa
    private int height;         // Tinggi pipa
    private Image image;       // Gambar pipa
    private int velocityX;      // Kecepatan pipa bergerak ke kiri
    private boolean passed;     // Status apakah burung telah melewati pipa atau belum

    // Konstruktor untuk menginisialisasi objek Pipa
    public Pipe(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;
        this.velocityX = -3;    // Kecepatan awal pipa bergerak ke kiri
        this.passed = false;    // Awalnya burung belum melewati pipa
    }

    // Setter dan Getter untuk masing-masing atribut

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Image getImage() {
        return this.image;
    }

    public int getVelocityX() {
        return this.velocityX;
    }

    public boolean isPassed() {
        return this.passed;
    }

    // Mendapatkan batas persegi panjang untuk deteksi tabrakan
    public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double(posX, posY, width, height);
    }
}
