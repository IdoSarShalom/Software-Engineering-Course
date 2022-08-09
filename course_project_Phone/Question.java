package project4;

public class Question {

	// fields:
	private String question;
	private String[] answers; // 4 answers
	private int correctAnswer; // 1-4
	// --------------------------------------

	// constructors:
	public Question(String question, String a1, String a2, String a3, String a4, int correctAnswer) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answers = new String[4];
		this.answers[0] = a1;
		this.answers[1] = a2;
		this.answers[2] = a3;
		this.answers[3] = a4;
	}
	// --------------------------------------

	// getters & setters:
	public String getQuestion() {
		return this.question;
	}

	public String[] getAnswers() {
		return this.answers;
	}
	// --------------------------------------

	// general functions:
	public boolean correctChioce(String answer) {
		return answer.equals(this.answers[correctAnswer - 1]);
	}

	@Override
	public String toString() {
		return String.format("%s \n1. %s   2. %s   3. %s   4. %s", this.question, this.answers[0], this.answers[1],
				this.answers[2], this.answers[3]);
	}
	// --------------------------------------
}
