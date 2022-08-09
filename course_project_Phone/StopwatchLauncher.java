package project4;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class StopwatchLauncher implements ActionListener {
	JFrame frame = new JFrame("STOPWATCH");
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();

	int elapsedTime = 0;
	int hours = 0;
	int minutes = 0;
	int seconds = 0;

	boolean started = false;

	String hours_string = String.format("%02d", hours);
	String minutes_string = String.format("%02d", minutes);
	String seconds_string = String.format("%02d", seconds);

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			elapsedTime = elapsedTime + 1000;
			hours = (elapsedTime / 3600000);
			minutes = (elapsedTime / 60000) % 60;
			seconds = (elapsedTime / 1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		}

	});

	StopwatchLauncher() {
		ImageIcon imageIcon = new ImageIcon("timer.png");

		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale the image
		imageIcon = new ImageIcon(newimg); // transform it back

		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLabel.setBounds(100, 100, 200, 100);
		timeLabel.setFont(new Font("Ariel", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);

		startButton.setBounds(100, 200, 100, 50);
		startButton.setFont(new Font("Ariel", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);

		resetButton.setBounds(200, 200, 100, 50);
		resetButton.setFont(new Font("Ariel", Font.PLAIN, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);

		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);

		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setIconImage(newimg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startButton) {

			if (started == false) {
				started = true;
				startButton.setText("STOP");
				start();
			} else {
				started = false;
				startButton.setText("START");
				stop();
			}

		}
		if (e.getSource() == resetButton) {
			started = false;
			startButton.setText("START");
			reset();
		}

	}

	void start() {
		timer.start();
	}

	void stop() {
		timer.stop();
	}

	void reset() {
		timer.stop();
		elapsedTime = hours = minutes = seconds = 0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	}

}
