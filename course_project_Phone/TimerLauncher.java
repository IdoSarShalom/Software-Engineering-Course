package project4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class TimerLauncher implements ActionListener {
	JFrame frame = new JFrame("TIMER");
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();

	int countTime = 0;
	int hours = 0;
	int minutes = 0;
	int seconds = 0;

	int[] saveInputTime;

	boolean started = false;

	String hours_string = String.format("%02d", hours);
	String minutes_string = String.format("%02d", minutes);
	String seconds_string = String.format("%02d", seconds);

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			if (countTime >= 1000) {
				countTime = countTime - 1000;
				hours = (countTime / 3600000);
				minutes = (countTime / 60000) % 60;
				seconds = (countTime / 1000) % 60;
				seconds_string = String.format("%02d", seconds);
				minutes_string = String.format("%02d", minutes);
				hours_string = String.format("%02d", hours);
				timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			}

		}

	});

	TimerLauncher() {

		String[] hourString = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23" };

		String[] minuteStrings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
				"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
				"50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };

		String[][] optionArr = new String[][] { hourString, minuteStrings, minuteStrings };

		String[] inputStrings = { "0", "0", "0" };

		String[] titleStrings = { "hours", "minutes", "seconds" };

		String inputString;

		ImageIcon imageIcon = new ImageIcon("timer.png");

		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale the image
		imageIcon = new ImageIcon(newimg); // transform it back
		boolean flag_1 = false;
		for (int i = 0; i < inputStrings.length; i++) {
			
			inputString = (String) JOptionPane.showInputDialog(

					null, "Enter the number of " + titleStrings[i] + ":", "Timer", JOptionPane.PLAIN_MESSAGE, imageIcon,
					optionArr[i], optionArr[i][0]);
			if (inputString == null) {
				flag_1 = true;
				break;
			}

			inputStrings[i] = inputString;
		}
		if(flag_1)
		{
			frame.setVisible(false);
			hours = 0;
			minutes = 0;
			seconds = 0;
			
			
			
		}
		else
		{
		hours = Integer.parseInt(inputStrings[0]);
		minutes = Integer.parseInt(inputStrings[1]);
		seconds = Integer.parseInt(inputStrings[2]);
		}
		countTime = hours * 3600000 + minutes * 60000 + seconds * 1000;

		saveInputTime = new int[] { hours, minutes, seconds, countTime };

		String hours_string = String.format("%02d", hours);
		String minutes_string = String.format("%02d", minutes);
		String seconds_string = String.format("%02d", seconds);

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
		if(flag_1)
		{
			frame.setVisible(false);
		}
		else
		frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		hours = saveInputTime[0];
		minutes = saveInputTime[1];
		seconds = saveInputTime[2];
		countTime = saveInputTime[3];
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	}

}
