package life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LifePanel extends JPanel {

    private int squareLen = 12;
    private int sizeX = 80;
    private int sizeY = 30;
    private LifeGrid lg = new LifeGrid(sizeX, sizeY);
    private LifeGrid savedGrid = lg;
    private LifeClip clipOverlay = null;
    private GridClickListener gcl = new GridClickListener();

    public LifePanel() {
        setPreferredSize(new Dimension(squareLen * sizeX, squareLen * sizeY));
        setMouse(true);
    }

    final public void setMouse(boolean state) {
        if (state) {
            addMouseListener(gcl);
            addMouseMotionListener(gcl);
        } else {
            removeMouseListener(gcl);
            removeMouseMotionListener(gcl);
        }
    }

    public void iterate() {
        lg.iterate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, lg.dimX * squareLen, lg.dimY * squareLen);

        // draw filled squares
        g2.setColor(Color.BLUE);
        for (int x = 0; x < lg.dimX; x++) {
            for (int y = 0; y < lg.dimY; y++) {
                if (lg.getSquare(x, y)) {
                    g2.fillRect(x * squareLen, y * squareLen, squareLen, squareLen);
                }
            }
        }
        if (gcl.isMouseInPanel && clipOverlay != null) {
            addOverlays(g2);
        }
    }

    private void addOverlays(Graphics2D g2) {
        g2.setColor(new Color(255, 50, 50, 150));
        for (int x = 0; x < clipOverlay.dimX; x++) {
            for (int y = 0; y < clipOverlay.dimY; y++) {
                if (clipOverlay.getSquare(x, y)) {
                    g2.fillRect((gcl.gridX + x) * squareLen, (gcl.gridY + y) * squareLen, squareLen, squareLen);
                }
            }
        }
    }

    void setOverlay(LifeClip lc) {
        clipOverlay = lc;
    }

    public void clear() {
        lg = new LifeGrid(sizeX, sizeY);
        repaint();
    }

    public void save() {
        try {
            savedGrid = (LifeGrid) lg.clone();
        } catch (Exception e) {
            System.out.println("Unable to clone");
        }
    }

    public void restore() {
        try {
            lg = (LifeGrid) savedGrid.clone();
        } catch (Exception e) {
            System.out.println("Unable to clone");
        }
        repaint();
    }

    class GridClickListener extends MouseAdapter {

        private int lastUpdatedX = 0;
        private int lastUpdatedY = 0;
        private int gridX;
        private int gridY;
        private boolean adding = true;
        private boolean isMouseInPanel = false;

        @Override
        public void mousePressed(MouseEvent e) {
            setGridXY(e);
            if (clipOverlay == null) {
                adding = toggleSquare(e);
                lastUpdatedX = gridX;
                lastUpdatedY = gridY;
            } else {
                lg.addClip(clipOverlay, gridX, gridY);
                clipOverlay = null;
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            setGridXY(e);
            if (!(gridX == lastUpdatedX && gridY == lastUpdatedY) && lg.getSquare(gridX, gridY) != adding) {
                toggleSquare(e);
                lastUpdatedX = gridX;
                lastUpdatedY = gridY;
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            setGridXY(e);
            if (clipOverlay != null) {
                repaint();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            isMouseInPanel = true;
        }

        @Override
        public void mouseExited(MouseEvent e) {
            isMouseInPanel = false;
        }

        private boolean toggleSquare(MouseEvent e) {
            boolean newState = !lg.getSquare(gridX, gridY);
            lg.setSquare(gridX, gridY, newState);
            repaint();
            return newState;
        }

        private void setGridXY(MouseEvent e) {
            int x = e.getX() / squareLen;
            int y = e.getY() / squareLen;
            if ((x >= 0) && (x <= sizeX - 1) && (y >= 0) && (y <= sizeY - 1)) {
                gridX = x;
                gridY = y;
            }
        }
    }
}

class InputFrame extends JFrame {

    private JTextArea ta = new JTextArea("Paste characters here, \".\" for false, \"O\" for true", 20, 60);
    private JScrollPane sp = new JScrollPane(ta);
    private JPanel ctrlPanel = new JPanel();
    private JButton btnDone = new JButton("Done");
    private JButton btnCancel = new JButton("Cancel");
    private LifeApp la;

    public InputFrame(LifeApp main) {
        la = main;
        setTitle("Shape composer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ctrlPanel.add(btnDone);
        ctrlPanel.add(btnCancel);
        add(sp, BorderLayout.CENTER);
        add(ctrlPanel, BorderLayout.SOUTH);
        ta.selectAll();
        ta.setFont(new Font("Monospaced", Font.PLAIN, 12));
        btnDone.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                la.lp.setOverlay(getLifeClip());
                la.lp.setMouse(true);
                setVisible(false);
            }
        });
        pack();
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

    }

    public void display() {
        setVisible(true);
    }

    private LifeClip getLifeClip() {
        //need to add error handling
        String[] lines = ta.getText().split("\n");
        int maxLen = 0;
        for (String s : lines) {
            s = s.trim();
            maxLen = Math.max(maxLen, s.length());
        }
        boolean[][] grid = new boolean[maxLen][lines.length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                char c = lines[i].trim().toCharArray()[j];
                if(c == 'O' || c == '*'){
                    grid[j][i] = true;
                }
                else {
                    grid[j][i] = false;
                }
            }
        }
        return new LifeClip(grid);
    }
}
