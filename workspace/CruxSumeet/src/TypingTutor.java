import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;


public class TypingTutor extends JFrame implements ActionListener {

	private JLabel lblscore;
	private JLabel lbltimer;
	private JLabel lblWord;
	private JButton lblStart;
	private JButton lblStop;
	private JTextField txt;
	
	private int timeleft;
	private int score;
	private boolean running;
	private String[] data;
	private Timer timer;

	public TypingTutor(String feeder) {
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);
		Font font = new Font("Cominc Sans MS", 1, 100);

		this.lblscore = new JLabel("Score:");
		lblscore.setFont(font);
		super.add(lblscore);

		this.lbltimer = new JLabel("timer:");
		lbltimer.setFont(font);
		super.add(lbltimer);

		this.lblWord = new JLabel("Hello");
		lblWord.setForeground(Color.BLACK);
		lblWord.setBackground(Color.CYAN);
		lblWord.setOpaque(true);
		lblWord.setFont(font);
		super.add(lblWord);

		this.txt = new JTextField("");
		txt.setFont(font);
		super.add(txt);

		this.lblStart = new JButton("Start");
		lblStart.setFont(font);
		lblStart.addActionListener(this);
		super.add(lblStart);

		this.lblStop = new JButton("Stop");
		lblStop.addActionListener(this);
		lblStop.setFont(font);
		super.add(lblStop);

		super.setSize(1000, 1500);
		super.setTitle("Typing Tutor");
		super.setVisible(true);
		
		data = feeder.split(" ");
		initgame();
	}
	
	public void initgame(){
		timer = new Timer(3000,this);
		running = false;
		timeleft = 50;
		score = 0;
		timeleft =50;
		lblStop.setEnabled(false);
		lblscore.setText("Score- "+score);
		lblWord.setText("");
		lbltimer.setText("Timer- "+timeleft);
		lblStart.setText("Start");
		//timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lblStart) {
			handleStart();
		} else if(e.getSource()==lblStop){
			handleStop();
		}else{
			handleTimer();
		}
	}

	private void handleStart() {
		if(running){
			running = false;
			txt.setEnabled(false);
			lblWord.setText("resume");
			timer.stop();
		}else{
			running = true;
			timer.start();
			lblWord.setText("Pause");
			txt.setEnabled(true);
			lblStop.setEnabled(true);
		}
	}

	private void handleStop() {
		timer.stop();
		int choice = JOptionPane.showConfirmDialog(this, "Game Over. Score is " + score+ ". Restart?");
		if(choice== JOptionPane.YES_OPTION){
			initgame();
		}else{
			super.dispose();
		}
	}
	private void handleTimer(){
		if(timeleft>0){
			timeleft--;
			if(txt.getText().equals(lblWord.getText()) && txt.getText().length()>0){
				score++;
				lblscore.setText("Score- "+score);
			}
			lbltimer.setText("Timer- "+timeleft);
			lblWord.setText(data[(int)(Math.random()*data.length)]);
			txt.setText("");
			txt.setFocusable(true);
		}else{
			handleStop();
		}
	}
}
