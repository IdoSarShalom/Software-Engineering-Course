package project4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Weather {
	String city;
	String month;

	private String[][] cityMonthlyAverageTemputare = {
			{ "9.4", "9.5", "11.9", "17.05", "20.5", "22.8", "24.2", "24.45", "23.4", "20.65", "15.55", "11.5" }, // Jerusalem
			{ "13.55", "13.75", "15.35", "18.6", "21.1", "24.05", "26.2", "26.95", "25.95", "23.2", "19", "15.2" }, // TelAviv
			{ "12.95", "13.1", "15.15", "19.85", "21.7", "24.95", "27.05", "27.5", "25.8", "23.25", "19", "15.05" }, // Haifa
			{ "12.15", "12.5", "14.7", "19.25", "22.2", "24.85", "26.6", "26.85", "25.4", "22.6", "18.05", "13.85" }, // BeerSheva
			{ "15.2", "16.35", "19.55", "31.1", "35.1", "38.7", "39.9", "39.8", "37.3", "33", "27.2", "16.75" } // Eilat
	};

	public Weather() {

		String[] cityString = { "Jerusalem", "TelAviv", "Haifa", "BeerSheva", "Eilat" };

		String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		String[][] optionArr = new String[][] { cityString, monthStrings };

		String[] inputStrings = { "0", "0" };

		String[] titleStrings = { "Enter the city which you want to know the monthly average temperature",
				"Which month do you interest in?" };

		String inputString;

		for (int i = 0; i < inputStrings.length; i++) {

			inputString = (String) JOptionPane.showInputDialog(

					null, titleStrings[i], "Weather", JOptionPane.PLAIN_MESSAGE, null, optionArr[i], optionArr[i][0]);

			inputStrings[i] = inputString;
		}

		city = inputStrings[0];
		month = inputStrings[1];

		String avgTmp = getAverageTemperatureByCityAndMonth((Cities) Cities.valueOf(city),
				(Months) Months.valueOf(month));

		JFrame f = new JFrame("Average Temperature in the Month");
		JLabel l1;
		l1 = new JLabel(
				"The average temperature in the city " + city + " and in the month " + month + " is: " + avgTmp + "°C");
		l1.setBounds(0, 0, 500, 50);
		f.add(l1);
		f.setSize(550, 100);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public enum Months {
		January, February, March, April, May, June, July, August, September, October, November, December;
	}

	public enum Cities {
		Jerusalem, TelAviv, Haifa, BeerSheva, Eilat;
	}

	public String getAverageTemperatureByCityAndMonth(Cities city, Months month) {

		return this.cityMonthlyAverageTemputare[city.ordinal()][month.ordinal()];
	}

}
