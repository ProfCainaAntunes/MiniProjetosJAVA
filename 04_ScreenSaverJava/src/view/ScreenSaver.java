package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSaver extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DELAY_MS = 16; 

    private ScreenSaverPanel canvas;

    public ScreenSaver() {
        super("Protetor de Tela - Demonstração de POO");

        this.canvas = new ScreenSaverPanel();

        // 1. Define o encerramento da aplicação
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // 2. Adiciona o painel
        this.setContentPane(canvas);

        // 3. Força a dimensão diretamente na janela com setSize
        // Somamos uma margem para compensar a barra de título do SO
        this.setSize(WIDTH, HEIGHT);

        // 4. Centraliza na tela do monitor
        this.setLocationRelativeTo(null);
    }

    public void start() {
        this.setVisible(true);
        this.canvas.startAnimation();
    }

    private class ScreenSaverPanel extends JPanel implements ActionListener {

        private Timer timer;


        /*********************************
        ** ↓ Declare suas formas aqui ↓ **
        *********************************/




        public ScreenSaverPanel() {
            // Garante tamanho no painel
            this.setSize(WIDTH, HEIGHT);
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setBackground(Color.BLACK);


            /***********************************
            ** ↓ Instancie suas formas aqui ↓ **
            ***********************************/




            this.timer = new Timer(DELAY_MS, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        public void startAnimation() {
            this.timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            

            /******************************
            ** ↓ Mova suas formas aqui ↓ **
            ******************************/




            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


            /*********************************
            ** ↓ Desenhe suas formas aqui ↓ **
            *********************************/



            
        }
    }
}