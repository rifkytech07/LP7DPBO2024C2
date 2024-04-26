//Saya Muhammad Rifky Afandi dengan NIM 2202346 mengerjakan LP7 dalam mata kuliah Desain Pemrograman Berbasis Objek
// untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    // Dimensi frame
    int frameWidth = 360;
    int frameHeight = 640;
    // Gambar latar belakang, burung, dan pipa
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;
    // Label untuk skor
    JLabel scoreLabel;
    // Player
    int playerStartPosX = frameWidth / 8;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;
    Player player;
    // Atribut pipa
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeheight = 512;
    ArrayList<Pipe> pipes;
    // Timer untuk mengatur pergerakan dan penempatan pipa
    Timer gameloop;
    Timer pipesCooldown;
    // Gravitasi
    int gravity = 1;
    // Skor
    int score = 0;
    // Status permainan
    boolean gameOver = false;

    // Konstruktor
    public FlappyBird() {
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        addKeyListener(this);

        // Load gambar-gambar
        backgroundImage = new ImageIcon(getClass().getResource("Assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("Assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("Assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("Assets/upperPipe.png")).getImage();

        // Inisialisasi player dan arraylist untuk pipa
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<>();

        // Timer untuk menempatkan pipa
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        pipesCooldown.start();

        // Timer utama untuk pergerakan dan penggambaran
        gameloop = new Timer(1000/60, this);
        gameloop.start();

        // Label skor
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setBounds(10, 10, 100, 30);
        add(scoreLabel);
    }

    // Metode untuk menggerakkan player dan pipa
    public void move() {
        if (!gameOver) {
            // Pergerakan player
            player.setVelocityY(player.getVelocityY() + gravity);
            player.setPosY(player.getPosY() + player.getVelocityY());
            player.setPosY(Math.max(player.getPosY(), 0));

            // Pergerakan pipa
            for (int i = 0; i < pipes.size(); i++) {
                Pipe pipe = pipes.get(i);
                pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());

                // Deteksi tabrakan dengan pipa
                if (player.getBounds().intersects(pipe.getBounds())) {
                    gameOver = true;
                }

                // Jika melewati pipa, tambahkan skor
                if (pipe.getPosX() + pipe.getWidth() < player.getPosX() && !pipe.isPassed()) {
                    pipe.setPassed(true);
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
            }

            // Deteksi jika player menyentuh dasar layar
            if (player.getPosY() + player.getHeight() >= frameHeight) {
                gameOver = true;
            }
        }
    }

    // Metode untuk menempatkan pipa baru
    public void placePipes() {
        int randomPosY = (int) (pipeStartPosY - pipeheight / 4 - Math.random() * (pipeheight / 2));
        int openingSpace = frameHeight / 4;

        // Pipa atas
        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeheight, upperPipeImage);
        pipes.add(upperPipe);

        // Pipa bawah
        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeheight), pipeWidth, pipeheight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    // Metode untuk menggambar komponen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

        // Gambar teks "Game Over" jika permainan berakhir
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", frameWidth / 2 - 100, frameHeight / 2 - 15);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press 'R' to Restart", frameWidth / 2 - 120, frameHeight / 2 + 15);
        }
    }

    // Metode untuk menggambar komponen permainan
    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);

        // Gambar player
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        // Gambar pipa-pipa
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setVelocityY(-10);
        }
        if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // Metode untuk me-restart permainan setelah game over
    public void restartGame() {
        player.setPosY(playerStartPosY);
        pipes.clear();
        score = 0;
        scoreLabel.setText("Score: " + score);
        gameOver = false;
    }


}
