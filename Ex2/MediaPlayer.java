package tar2;

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
	public void turnOnMediaByName(String name) {
		boolean flag = false;
		Iterator<Media> itr = this.mediaList.iterator();
		while (itr.hasNext()) {
			Media m = itr.next();
			if (name.equals(m.getName())) {
				m.turnOn();
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.print("no media with the name " + name + " was found\n");
	}

	public void turnOnAllMedia() {
		if (this.mediaList.isEmpty())
			System.out.println("No media in the Media app");
		else {
			Iterator<Media> itr = this.mediaList.iterator();
			while (itr.hasNext())
				itr.next().turnOn();
		}
	}
	
	public void printMPMenu() {
		System.out.println("\nWhat do you want to do?");
		System.out.println("1.	Add music");
		System.out.println("2.	Add video");
		System.out.println("3.	Turn on media by name");
		System.out.println("4.	Turn on all media");
		System.out.println("5.	Exit");
	}
}
