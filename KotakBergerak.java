import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KotakBergerak extends JPanel implements KeyListener {
    private int x = 100, y = 100; // Posisi awal kotak
    private final int SIZE = 50; // Ukuran kotak
    private final int STEP = 10; // Langkah gerakan

    public KotakBergerak() {
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, SIZE, SIZE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && x > 0) {
            x -= STEP; // Geser ke kiri
        } else if (key == KeyEvent.VK_RIGHT && x < getWidth() - SIZE) {
            x += STEP; // Geser ke kanan
        } else if (key == KeyEvent.VK_UP && y > 0) {
            y -= STEP; // Geser ke atas
        } else if (key == KeyEvent.VK_DOWN && y < getHeight() - SIZE) {
            y += STEP; // Geser ke bawah
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Kotak Bergerak");
        KotakBergerak gamePanel = new KotakBergerak();
        frame.add(gamePanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
