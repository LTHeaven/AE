import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class GameOfLife {
    private int horizontalCells = 30;
    private int verticalCells = 30;
    private int cellPixelSize = 40;
    private boolean[][] gameState;
    private JFrame frame;
    private Canvas canvasGameBoard;
    private Thread animationThread;

    public GameOfLife(){
        init();
        show();
    }

    private void show() {
        frame.setVisible(true);
    }

    private void init() {
        frame = new JFrame("GameOfLife");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setUndecorated(true);
        gameState = new boolean[horizontalCells][verticalCells];
        gameState[5][10] = true;
        canvasGameBoard = new GameBoard(horizontalCells*cellPixelSize, verticalCells*cellPixelSize);
        frame.add(BorderLayout.CENTER, canvasGameBoard);
        JButton buttonStart = new JButton("Start");
        buttonStart.setSize(400,200);
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!animationThread.isAlive()){
                    animationThread.start();
                }
            }
        });
        JButton buttonPause = new JButton("Pause");
        buttonPause.setSize(400,200);
        buttonPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (animationThread.isAlive()){
                    animationThread.interrupt();
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonPause);
        BoxLayout boxLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(boxLayout);
        frame.add(BorderLayout.EAST, buttonPanel);
    }


    class GameBoard extends Canvas {
        public GameBoard(int width, int height){
            setSize(width, height);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int x = 0; x< horizontalCells; x++){
                for (int y = 0; y<verticalCells; y++) {
                    int yCoordinate = y * cellPixelSize;
                    int xCoordinate = x * cellPixelSize;
                    if (gameState[x][y]){
                        g.fillRect(xCoordinate, yCoordinate, cellPixelSize, cellPixelSize);
                    }else{
                        g.drawRect(xCoordinate, yCoordinate, cellPixelSize, cellPixelSize);
                    }
                }
            }
        }
    }
}
