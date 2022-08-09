package project4;

import java.util.ArrayList;

public class Text {
	private Person p;
	private String text;
	private ArrayList<String> texts;

	public Text(Person p_1, String text_1) {
		texts = new ArrayList<String>();
		this.p = p_1;
		this.text = text_1;
		texts.add(text_1);

	}

	public void addText(String text_1) {
		this.text = this.text + "  new text: " + text_1;
		texts.add(text_1);

	}

	public String getPersonName() {
		return this.p.getName();
	}

	public String getText() {
		return this.text;
	}

	public ArrayList<String> get_text_list() {
		return this.texts;
	}

}
