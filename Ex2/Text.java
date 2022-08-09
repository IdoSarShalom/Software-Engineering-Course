package tar2;

public class Text {
	private Person p;
	private String text;

	public Text(Person p, String text) {
		this.p = p;
		this.text = text;
	}

	public void addText(String text) {
		this.text = this.text + "  new text: " + text;
	}

	public String getPersonName() {
		return this.p.getName();
	}

	public String getText() {
		return this.text;
	}
}
