import javax.swing.*;
import java.awt.*;

public class BolaPantul extends JPanel implements Runnable {
    private int x = 50, y = 50; // Posisi awal bola
    private int diameter = 30; // Ukuran bola
    private int dx = 5, dy = 5; // Kecepatan bola

    public BolaPantul() {
        Thread thread = new Thread(this);
        thread.start(); // Memulai thread animasi
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;

            // Jika bola menyentuh batas jendela, pantulkan
            if (x <= 0 || x >= getWidth() - diameter) {
                dx = -dx;
            }
            if (y <= 0 || y >= getHeight() - diameter) {
                dy = -dy;
            }

            repaint(); // Gambar ulang layar

            try {
                Thread.sleep(20); // Kontrol kecepatan bola
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Bola Pantul");
        BolaPantul gamePanel = new BolaPantul();
        frame.add(gamePanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
