import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfLife {
    private int horizontalCells = 50;
    private int verticalCells = 50;
    private int cellPixelSize = 30;
    private boolean[][] gameState;
    private boolean[][] nextGameState;
    private JFrame frame;
    private Canvas canvasGameBoard;
    private Thread animationThread;
    private boolean paused;
    private JTextField textFieldTimerDelay;
    private JTextArea textAreaImportString;

    public GameOfLife(){
        init();
        show();
    }

    private void show() {
        frame.setVisible(true);
    }

    private void init() {
        frame = new JFrame("GameOfLife");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setUndecorated(true);
        gameState = new boolean[horizontalCells][verticalCells];
        canvasGameBoard = new GameBoard(horizontalCells*cellPixelSize, verticalCells*cellPixelSize);
        frame.add(BorderLayout.WEST, canvasGameBoard);
        JButton buttonStart = new JButton("Start");
        buttonStart.setSize(500,200);
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (paused){
                    animationThread = new AnimationThread();
                    paused = false;
                    animationThread.start();
                }
            }
        });
        JButton buttonPause = new JButton("Pause");
        buttonPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paused = true;
            }
        });
        JButton buttonClear = new JButton("Clear");
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        textFieldTimerDelay = new JTextField();
        textFieldTimerDelay.setText("50");
        textAreaImportString = new JTextArea();
        textAreaImportString.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    parseImportString(textAreaImportString.getText());
                    textAreaImportString.setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonPause);
        buttonPanel.add(buttonClear);
        buttonPanel.add(textFieldTimerDelay);
        buttonPanel.add(textAreaImportString);
        GridLayout gridLayout = new GridLayout(10,1);
        buttonPanel.setLayout(gridLayout);
        buttonPanel.setPreferredSize(new Dimension(500,600));
        frame.add(BorderLayout.EAST, buttonPanel);
        frame.pack();
        paused = true;
    }

    private void clear() {
        gameState = new boolean[horizontalCells][verticalCells];
        canvasGameBoard.repaint();
    }

    private void parseImportString(String text) {
        clear();
        String metadata = "";
        String figure = "";
        for (String currentLine : text.split("\n")){
            System.out.println(currentLine);
            if (!(currentLine.charAt(0) == '#')){
                if (metadata.equals("")){
                    metadata = currentLine;
                }
                figure += currentLine;
            }
        }
        System.out.println("metadata: " + metadata + "\nfigure: " + figure);
    }

    private void generateNextGameState(){
        nextGameState = new boolean[horizontalCells][verticalCells];
        for (int x = 0; x< horizontalCells; x++){
            for (int y = 0; y<verticalCells; y++) {
                boolean currentState = gameState[x][y];
                int neighbourCount = getNeighbourCount(x,y);
                if (!currentState){
                    if (neighbourCount == 3){
                        nextGameState[x][y] = true;
                    }
                }else{
                    if (!(neighbourCount == 2 ||neighbourCount == 3)){
                        nextGameState[x][y] = false;
                    }else{
                        nextGameState[x][y] = true;
                    }
                }
            }
        }
    }

    private int getNeighbourCount(int x, int y){
        int ret = 0;
        ret += checkIfAlive(x+1,y) ? 1 : 0;
        ret += checkIfAlive(x+1,y-1) ? 1 : 0;
        ret += checkIfAlive(x+1,y+1) ? 1 : 0;
        ret += checkIfAlive(x,y-1) ? 1 : 0;
        ret += checkIfAlive(x,y+1) ? 1 : 0;
        ret += checkIfAlive(x-1,y+1) ? 1 : 0;
        ret += checkIfAlive(x-1,y) ? 1 : 0;
        ret += checkIfAlive(x-1,y-1) ? 1 : 0;
        return ret;
    }

    private boolean checkIfAlive(int x, int y){
        int actualX = x;
        int actualY = y;
        if (x == horizontalCells){
            actualX = 0;
        }else if(x < 0){
            actualX = horizontalCells-1;
        }
        if (y == verticalCells){
            actualY = 0;
        }else if(y < 0){
            actualY = verticalCells-1;
        }
        return gameState[actualX][actualY];
    }


    class GameBoard extends Canvas {
        private int currentX;
        private int currentY;

        public GameBoard(int width, int height){
            setSize(width, height);
            addMouseMotionListener(new MouseMotionListener() {
                public void mouseDragged(MouseEvent e) {
                    int x = e.getX() / cellPixelSize;
                    int y = e.getY() / cellPixelSize;
                    if ((x != currentX || y!=currentY) && (0<=x && x<horizontalCells&& 0<=y && y<verticalCells)){
                        gameState[x][y] = !gameState[x][y];
                        canvasGameBoard.repaint();
                        currentX = x;
                        currentY = y;
                    }
                }

                public void mouseMoved(MouseEvent e) {
                }
            });
            addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX() / cellPixelSize;
                    int y = e.getY() / cellPixelSize;
                    if(0<=x && x<horizontalCells&& 0<=y && y<verticalCells){
                        gameState[x][y] = !gameState[x][y];
                        canvasGameBoard.repaint();
                    }
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.drawRect(0,0,horizontalCells*cellPixelSize, verticalCells*cellPixelSize);
            for (int x = 0; x< horizontalCells; x++){
                for (int y = 0; y<verticalCells; y++) {
                    int yCoordinate = y * cellPixelSize;
                    int xCoordinate = x * cellPixelSize;
                    if (gameState[x][y]) {
                        g.fillRect(xCoordinate, yCoordinate, cellPixelSize, cellPixelSize);
                    }
                }
            }
        }
    }

    class AnimationThread extends Thread{
        @Override
        public void run(){
            int timerdelay = Integer.parseInt(textFieldTimerDelay.getText());
            while (!paused) {
                generateNextGameState();
                gameState = nextGameState;
                canvasGameBoard.repaint();
                try {
                    this.sleep(timerdelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
