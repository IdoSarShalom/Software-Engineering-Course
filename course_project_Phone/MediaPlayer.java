package project4;

import java.util.*;

public class MediaPlayer {
	// fields:
	private LinkedList<Media> mediaList;

	// constructors:
	public MediaPlayer() {
		this.mediaList = new LinkedList<Media>();
	}
	// general functions:

	// add new media to mediaList
	public void addMedia(Media m) {
		this.mediaList.add(m);
	}

	// turn on media by name, if exists several medias with the same name turn on
	// the one that appears at the beginning
	public String turnOnMediaByName(String name) {

		Iterator<Media> itr = this.mediaList.iterator();
		while (itr.hasNext()) {
			Media m = itr.next();
			if (name.equals(m.getName())) {
				return m.turnOn();

			}
		}
		return ("no media with the name " + name + " was found\n");
	}

	public ArrayList<String> turnOnAllMedia() {
		ArrayList<String> media_to_print = new ArrayList<String>();
		if (this.mediaList.isEmpty())
			media_to_print.add("No media in the Media app");
		else {
			Iterator<Media> itr = this.mediaList.iterator();
			while (itr.hasNext())
				media_to_print.add(itr.next().turnOn());
		}
		return media_to_print;
	}
}
