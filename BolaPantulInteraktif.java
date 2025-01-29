import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BolaPantulInteraktif extends JPanel implements Runnable, KeyListener {
    private int x = 100, y = 100; // Posisi awal bola
    private int diameter = 30; // Ukuran bola
    private int dx = 5, dy = 5; // Kecepatan bola otomatis
    private int playerSpeed = 10; // Kecepatan gerak bola saat dikontrol pemain

    private int blockX = 200, blockY = 200, blockWidth = 100, blockHeight = 20; // Posisi & ukuran balok

    public BolaPantulInteraktif() {
        setFocusable(true);
        addKeyListener(this);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gambar bola
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);

        // Gambar balok (rintangan)
        g.setColor(Color.BLUE);
        g.fillRect(blockX, blockY, blockWidth, blockHeight);
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;

            // Jika bola menyentuh batas jendela, pantulkan dan mainkan suara
            if (x <= 0 || x >= getWidth() - diameter) {
                dx = -dx;
                playSound("bounce.WAV");
            }
            if (y <= 0 || y >= getHeight() - diameter) {
                dy = -dy;
                playSound("bounce.WAV");
            }

            // Deteksi tabrakan dengan balok (rintangan)
            if (x + diameter > blockX && x < blockX + blockWidth && 
                y + diameter > blockY && y < blockY + blockHeight) {
                dy = -dy; // Pantulkan bola ke arah berlawanan
                playSound("bounce.WAV");
            }

            repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Fungsi untuk memainkan suara saat bola memantul
    private void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception e) {
            System.out.println("Gagal memainkan suara: " + e.getMessage());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && x > 0) {
            x -= playerSpeed;
        } else if (key == KeyEvent.VK_RIGHT && x < getWidth() - diameter) {
            x += playerSpeed;
        } else if (key == KeyEvent.VK_UP && y > 0) {
            y -= playerSpeed;
        } else if (key == KeyEvent.VK_DOWN && y < getHeight() - diameter) {
            y += playerSpeed;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Bola Pantul Interaktif");
        BolaPantulInteraktif gamePanel = new BolaPantulInteraktif();
        frame.add(gamePanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
