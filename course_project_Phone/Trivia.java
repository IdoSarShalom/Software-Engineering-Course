package project4;

import java.util.Arrays;

public class Trivia {

	// fields:
	private Question[] questions;
	private int[] availableQuestions;
	private int prize;
	private int life; // if life == 0 then the player is out
	private final int rounds = 5;

	// --------------------------------------

	// constructors:
	public Trivia() {
		this.prize = 0;
		this.life = 3;
		this.availableQuestions = new int[16];
		Arrays.fill(this.availableQuestions, 1);
		this.questions = new Question[16];
		this.questions[0] = new Question(
				"How many football players should each team\nhave on the field at the start of each match?", "11", "10",
				"9", "12", 1);
		this.questions[1] = new Question(
				"When Michael Jordan played for the Chicago\nBulls, how many NBA Championships did he win?", "0", "2",
				"6", "10", 3);
		this.questions[2] = new Question("What country won the very first FIFA World\nCup in 1930?", "Spain", "Uruguay",
				"Brazil", "Germany", 2);
		this.questions[3] = new Question("What year was the very first model of the\niPhone released?", "2007", "2005",
				"2010", "2008", 1);
		this.questions[4] = new Question("What’s the shortcut for the “copy” function\non most computers?", "ctrl x",
				"ctrl z", "ctrl v", "ctrl c", 4);
		this.questions[5] = new Question("What part of the atom has no electric charge?", "Proton", "Electron",
				"Neutron", "All of them", 3);
		this.questions[6] = new Question("What is the symbol for potassium?", "L", "K", "P", "T", 2);
		this.questions[7] = new Question("Which planet is the hottest in the solar system?", "Venus", "Jupiter",
				"Mercury", "Mars", 1);
		this.questions[8] = new Question("Which animal can be seen on the Porsche logo?", "Lion", "Horse", "Jaguar",
				"Snake", 2);
		this.questions[9] = new Question("How many parts (screws and bolts included)\ndoes the average car have?",
				"1000000", "500000", "5000", "30000", 4);
		this.questions[10] = new Question("Which country produces the most coffee in\nthe world?", "USA", "Belgium",
				"Switzerland", "Brazil", 4);
		this.questions[11] = new Question("Which kind of alcohol is Russia is\nnotoriously known for?", "Whisky",
				"Wine", "Vodka", "Rum", 3);
		this.questions[12] = new Question("Which bone are babies born without?", "Knee cap", "Teeth", "Fingers",
				"Skull", 1);
		this.questions[13] = new Question("How many times does the heartbeat per day?", "10000", "100000", "1000000",
				"1000", 2);
		this.questions[14] = new Question("Which American state is the largest (by area)?", "USA", "Brazil", "Canada",
				"Alaska", 4);
		this.questions[15] = new Question("What is the smallest country in the world?", "Monaco", "Israel", "Vatican",
				"Nauru", 3);

	}
	// --------------------------------------

	// getters & setters:
	public Question getQuestion(int num) {
		return questions[num];
	}

	public void resetgame() {
		this.prize = 0; // reset variables
		this.life = 3;
		Arrays.fill(this.availableQuestions, 1); // reset available
	}

	public int getlife() {
		return this.life;
	}

	public String getPirze() {
		return Integer.toString(this.prize);
	}

	public int getRounds() {
		return this.rounds;
	}

	// --------------------------------------

	public int generateQuestion() {
		while (true) {
			int questionNum = (int) (Math.random() * 16.0);
			if (this.availableQuestions[questionNum] == 1) {
				this.availableQuestions[questionNum] = 0;
				this.checkLeft();
				return questionNum;
			}
		}
	}

	public boolean isCorrectAnswer(int questionNum, String answer_1) {
		if (this.questions[questionNum].correctChioce(answer_1)) {
			this.prize += 1000;
			return true;
		} else {
			this.life--;
			return false;
		}
	}

	public void checkLeft() {
		boolean b = false;
		for (int i : this.availableQuestions) {
			if (i == 1)
				b = true; // there are questions left
		}
		if (!b) // if no questions left
			Arrays.fill(this.availableQuestions, 1); // reset available
	}
	// --------------------------------------
}
