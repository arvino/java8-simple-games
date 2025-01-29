Berikut adalah kode untuk game sederhana berbasis teks menggunakan Java 8. Game ini adalah Tebak Angka di mana pemain harus menebak angka acak antara 1 hingga 100, dan program akan memberi petunjuk apakah angka yang ditebak terlalu besar atau kecil.

Kode Java (Game Tebak Angka)
java
Copy
Edit
import java.util.Random;
import java.util.Scanner;

public class TebakAngka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int angkaBenar = random.nextInt(100) + 1; // Angka acak antara 1 - 100
        int tebakan;
        int percobaan = 0;

        System.out.println("Selamat datang di Game Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 hingga 100.");
        System.out.println("Coba tebak angkanya!");

        do {
            System.out.print("Masukkan tebakan Anda: ");
            tebakan = scanner.nextInt();
            percobaan++;

            if (tebakan > angkaBenar) {
                System.out.println("Terlalu besar! Coba lagi.");
            } else if (tebakan < angkaBenar) {
                System.out.println("Terlalu kecil! Coba lagi.");
            } else {
                System.out.println("Selamat! Anda berhasil menebak angka " + angkaBenar + " dalam " + percobaan + " percobaan.");
            }
        } while (tebakan != angkaBenar);

        scanner.close();
    }
}
Cara Menjalankan Program
Simpan kode ini sebagai file TebakAngka.java.
Buka CMD atau Terminal di direktori tempat file disimpan.
Kompilasi program dengan perintah:
cmd
Copy
Edit
javac TebakAngka.java
Jalankan program dengan perintah:
cmd
Copy
Edit
java TebakAngka
Cara Bermain
Program akan memilih angka acak antara 1 hingga 100.
Pemain harus menebak angka tersebut.
Program akan memberikan petunjuk apakah angka yang ditebak terlalu besar atau terlalu kecil.
Jika pemain menebak angka yang benar, program akan menampilkan jumlah percobaan yang diperlukan.
Game ini cocok untuk dipelajari bagi pemula yang ingin memahami dasar-dasar logika perulangan (do-while), input pengguna (Scanner), dan bilangan acak (Random) di Java 8.

Coba jalankan dan beri tahu jika ingin ditambahkan fitur baru! 🎮🚀


----------
Berikut adalah game 2D sederhana berbasis Java 8 menggunakan Java Swing dan AWT. Game ini adalah "Kotak Bergerak", di mana pemain dapat menggerakkan kotak menggunakan tombol panah (← ↑ → ↓) pada keyboard.

Fitur Game
✅ Pemain menggerakkan kotak menggunakan tombol panah
✅ Kotak tetap berada dalam area layar (tidak keluar dari batas)
✅ Tampilan menggunakan Java Swing

Kode Java (Game 2D - Kotak Bergerak)
java
Copy
Edit
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
Cara Menjalankan Game
Simpan kode ini sebagai file KotakBergerak.java
Buka Command Prompt (CMD) di folder tempat file disimpan
Kompilasi program dengan perintah:
cmd
Copy
Edit
javac KotakBergerak.java
Jalankan game dengan perintah:
cmd
Copy
Edit
java KotakBergerak
Cara Bermain
🎮 Gunakan tombol panah (← ↑ → ↓) untuk menggerakkan kotak biru.
🔲 Kotak akan bergerak dalam batas area layar.
❌ Kotak tidak bisa keluar dari batas layar.

Pengembangan Lebih Lanjut
Jika ingin menambahkan fitur lain, berikut beberapa ide:
✨ Tambahkan rintangan atau target yang harus dikumpulkan.
🚀 Tambahkan kecepatan atau animasi pada gerakan kotak.
🎨 Ganti warna atau bentuk objek.

Silakan coba dan beri tahu jika ingin fitur tambahan! 🚀🎮

---------
Berikut adalah game 2D sederhana lainnya menggunakan Java 8, yaitu "Game Bola Pantul". Dalam game ini, bola akan memantul ke segala arah dalam batas jendela.

Fitur Game
✅ Bola bergerak dan memantul dari dinding jendela
✅ Menggunakan Java Swing dan AWT
✅ Update animasi menggunakan Thread.sleep() untuk membuat bola bergerak mulus

Kode Java (Game Bola Pantul)
java
Copy
Edit
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
Cara Menjalankan Game
Simpan kode ini sebagai file BolaPantul.java
Buka Command Prompt (CMD) di folder tempat file disimpan
Kompilasi program dengan perintah:
cmd
Copy
Edit
javac BolaPantul.java
Jalankan game dengan perintah:
cmd
Copy
Edit
java BolaPantul
Cara Bermain
Bola akan mulai bergerak secara otomatis.
Bola akan memantul jika menyentuh dinding.
Pengembangan Lebih Lanjut
✨ Tambahkan objek lain yang bisa berinteraksi dengan bola
🎮 Buat pemain bisa mengontrol bola dengan keyboard
🎨 Tambahkan efek suara saat bola memantul

Silakan coba dan beri tahu jika ingin fitur tambahan! 🚀🎮


==============
Berikut adalah versi yang lebih interaktif dari Game Bola Pantul, dengan tambahan:
✅ Balok sebagai rintangan yang bisa memantulkan bola
✅ Pemain bisa mengontrol bola menggunakan tombol panah (← ↑ → ↓)
✅ Efek suara saat bola memantul

Kode Java (Game Bola Pantul dengan Interaksi & Kontrol Pemain)
java
Copy
Edit
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
                playSound("bounce.wav");
            }
            if (y <= 0 || y >= getHeight() - diameter) {
                dy = -dy;
                playSound("bounce.wav");
            }

            // Deteksi tabrakan dengan balok (rintangan)
            if (x + diameter > blockX && x < blockX + blockWidth && 
                y + diameter > blockY && y < blockY + blockHeight) {
                dy = -dy; // Pantulkan bola ke arah berlawanan
                playSound("bounce.wav");
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
Cara Menjalankan Game
Simpan kode ini sebagai file BolaPantulInteraktif.java
Tambahkan file suara (bounce.wav) ke direktori yang sama.
Gunakan suara pantulan bola (bisa cari di internet atau buat sendiri).
Buka Command Prompt (CMD) di folder tempat file disimpan
Kompilasi program dengan perintah:
cmd
Copy
Edit
javac BolaPantulInteraktif.java
Jalankan game dengan perintah:
cmd
Copy
Edit
java BolaPantulInteraktif
Cara Bermain
🎮 Gunakan tombol panah (← ↑ → ↓) untuk mengontrol bola secara manual.
🟦 Bola akan memantul jika menyentuh dinding atau balok biru.
🔊 Setiap kali bola memantul, akan terdengar efek suara "bounce".

Pengembangan Lebih Lanjut
✨ Tambahkan lebih banyak balok sebagai rintangan.
🎨 Buat tampilan lebih menarik dengan gambar atau animasi.
🚀 Ubah game menjadi Brick Breaker, di mana pemain menghancurkan balok dengan bola.

Coba jalankan dan beri tahu jika ingin fitur tambahan! 🚀🎮


---------

Secara default, Java tidak mendukung file MP3 untuk pemutaran audio. Java Sound API hanya mendukung format WAV, AU, dan AIFF. Namun, jika ingin menggunakan MP3, kita bisa memakai pustaka tambahan seperti JavaZoom JLayer (jl1.0.1.jar).

🔹 Cara Memainkan Suara MP3 di Java (Menggunakan JLayer)
1️⃣ Download Library JLayer
Unduh file jl1.0.1.jar dari: 🔗 https://github.com/umjammer/jlayer
Atau langsung cari jl1.0.1.jar di Google dan unduh dari repository Maven.

2️⃣ Tambahkan JAR ke Classpath
Simpan file jl1.0.1.jar di folder yang sama dengan kode Java.
Saat menjalankan program, gunakan:

cmd
Copy
Edit
javac -cp .;jl1.0.1.jar BolaPantulInteraktif.java
java -cp .;jl1.0.1.jar BolaPantulInteraktif
(Gunakan : di Linux/Mac, bukan ;.)

🔹 Contoh Kode Java dengan MP3
Berikut adalah kode Game Bola Pantul yang memainkan suara MP3 saat bola memantul.

java
Copy
Edit
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class BolaPantulMP3 extends JPanel implements Runnable, KeyListener {
    private int x = 100, y = 100; // Posisi awal bola
    private int diameter = 30; // Ukuran bola
    private int dx = 5, dy = 5; // Kecepatan bola otomatis
    private int playerSpeed = 10; // Kecepatan gerak bola saat dikontrol pemain

    private int blockX = 200, blockY = 200, blockWidth = 100, blockHeight = 20; // Balok rintangan

    public BolaPantulMP3() {
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
                playMP3("bounce.mp3");
            }
            if (y <= 0 || y >= getHeight() - diameter) {
                dy = -dy;
                playMP3("bounce.mp3");
            }

            // Deteksi tabrakan dengan balok (rintangan)
            if (x + diameter > blockX && x < blockX + blockWidth && 
                y + diameter > blockY && y < blockY + blockHeight) {
                dy = -dy;
                playMP3("bounce.mp3");
            }

            repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Fungsi untuk memainkan file MP3
    private void playMP3(String filePath) {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(filePath);
                Player player = new Player(fis);
                player.play();
            } catch (Exception e) {
                System.out.println("Gagal memainkan suara: " + e.getMessage());
            }
        }).start();
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
        JFrame frame = new JFrame("Game Bola Pantul MP3");
        BolaPantulMP3 gamePanel = new BolaPantulMP3();
        frame.add(gamePanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
🔹 Cara Menjalankan Program dengan MP3
Unduh file suara 🎵

Simpan file bounce.mp3 di folder yang sama dengan kode.
Download jl1.0.1.jar

Simpan di folder yang sama dengan file Java.
Kompilasi Program dengan JLayer JAR

cmd
Copy
Edit
javac -cp .;jl1.0.1.jar BolaPantulMP3.java
Jalankan Game dengan JLayer JAR

cmd
Copy
Edit
java -cp .;jl1.0.1.jar BolaPantulMP3
🔹 Fitur yang Ditambahkan
✅ Bola memantul dari dinding dan balok
✅ Efek suara MP3 saat bola memantul
✅ Bola bisa dikontrol pemain dengan tombol panah

🔹 Apa yang Bisa Ditambahkan Lagi?
🚀 Tambahkan lebih banyak rintangan atau objek interaktif
🏆 Buat sistem skor untuk menghitung jumlah pantulan
🎨 Gunakan gambar sprite untuk bola dan rintangan

Coba jalankan game ini dan beri tahu jika ingin fitur tambahan! 🚀🎮