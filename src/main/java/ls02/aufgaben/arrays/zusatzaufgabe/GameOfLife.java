package ls02.aufgaben.arrays.zusatzaufgabe;

import ls02.aufgaben.arrays.zusatzaufgabe.util.swing.CellPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameOfLife extends JFrame {
	private static final long serialVersionUID = 1L;

	private CellPanel cellPanel;
	private JLabel infoLabel1;
	private JLabel infoLabel2;
	private JPanel infoPanel;
	private JPanel mainPanel;

	private boolean play;
	private Timer timer;
	private TimerTask task;

	/**
	 * Start method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GameOfLife g = new GameOfLife(100, 1000);
		g.setVisible(true);
	}

	/**
	 * constructor
	 * 
	 * @param sideLength            the fields width and height
	 * @param aliveCellsOnGameStart the count of cells that should be alive when
	 *                              starting the game
	 */
	public GameOfLife(int sideLength, int aliveCellsOnGameStart) {
		initGui(sideLength, aliveCellsOnGameStart);
	}

	/**
	 * builds the gui
	 * 
	 * @param sideLength            the fields width and height
	 * @param aliveCellsOnGameStart the count of cells that should be alive when
	 *                              starting the game
	 */
	private void initGui(int sideLength, int aliveCellsOnGameStart) {
		infoLabel1 = new JLabel("Press 'e' to show the next generation of cells");
		infoLabel2 = new JLabel("Press 'p' to play or pause the game");

		cellPanel = new CellPanel(sideLength, aliveCellsOnGameStart);

		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0, 1));
		infoPanel.add(infoLabel1);
		infoPanel.add(infoLabel2);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(infoPanel, BorderLayout.NORTH);
		mainPanel.add(cellPanel, BorderLayout.CENTER);

		this.setTitle("Game Of Life");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50, 50, 500, 530);
		this.setResizable(false);
		this.add(mainPanel);
		this.addKeyListener(getKeyListener());
	}

	/**
	 * handles any key-input we have to work with
	 * 
	 * @return the games keylistener
	 */
	private KeyAdapter getKeyListener() {
		return new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == 'e' && !play)
					nextRound();
				if (e.getKeyChar() == 'p')
					playPause();
			}
		};
	}

	/**
	 * plays or pauses the game
	 */
	private void playPause() {
		play = !play;
		if (play) {
			timer = new Timer();
			task = new TimerTask() {
				public void run() {
					nextRound();
				}
			};
			long delay = 500; // 0.5 Sekunden
			timer.schedule(task, 0, delay);
		} else {
			timer.cancel();
			timer = null;
		}
	}

	/**
	 * will show the games next round
	 */
	public void nextRound() {
		cellPanel.updateCells();
		repaint();
	}
}
