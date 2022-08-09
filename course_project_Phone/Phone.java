package project4;

/*
 * Made by: 
 * Ido Sar-Shalom		id: 212410146
 * Yonatan Cohen		id: 324842608
 * Tomer Griba			id: 325105625
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Date;

/*
 * Mainframe =  the main frame of the phone
 * contacts_Frame = the frame of the contacts part
 * SMS_frame = the frame of the SMS part
 * Diary_frame = the frame of the Diary part
 * Media_frame = the frame of the media part
 * Trivia_main_frame = the frame of the Trivia part
 * Watch_frame = the frame of the watch
 * All_frame = the frame in which we print all the content
 *
 * 
 */

public class Phone {
	public static void main(String[] args) {

		// All of the frames
		JFrame Main_frame = new JFrame();
		JFrame contacts_Frame = new JFrame();
		JFrame SMS_frame = new JFrame();
		JFrame Diary_frame = new JFrame();
		JFrame Media_frame = new JFrame();
		JFrame Trivia_main_frame = new JFrame();
		JFrame Watch_frame = new JFrame();
		JFrame All_frame = new JFrame();

		Dimension dim_1 = Toolkit.getDefaultToolkit().getScreenSize();

		// Save all frames in arraylist
		ArrayList<JFrame> all_frames = new ArrayList<JFrame>();
		all_frames.add(Main_frame);
		all_frames.add(contacts_Frame);
		all_frames.add(SMS_frame);
		all_frames.add(Diary_frame);
		all_frames.add(Media_frame);
		all_frames.add(Trivia_main_frame);
		all_frames.add(Watch_frame);
		all_frames.add(All_frame);

		Main_frame.setSize(483, 550);
		Main_frame.setLayout(null);
		Main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main_frame.setLocation(dim_1.width / 2 - Main_frame.getSize().width / 2,
				dim_1.height / 2 - Main_frame.getSize().height / 2);

		// Back buttons
		JButton general_back_contacts = new JButton("Back");
		general_back_contacts.setBounds(380, 10, 80, 60);
		JButton general_back_SMS = new JButton("Back");
		general_back_SMS.setBounds(380, 10, 80, 60);
		JButton general_back_Diary = new JButton("Back");
		general_back_Diary.setBounds(380, 10, 80, 60);
		JButton general_back_Media = new JButton("Back");
		general_back_Media.setBounds(380, 10, 80, 60);
		JButton general_back_Trivia = new JButton("Back");
		general_back_Trivia.setBounds(380, 10, 80, 60);
		JButton general_back_Watch = new JButton("Back");
		general_back_Watch.setBounds(380, 10, 80, 60);
		JButton general_back_All = new JButton("Back");
		general_back_All.setBounds(380, 10, 80, 60);

		//

		// contacts frame buttons
		JButton c_b_1 = new JButton("Add contact");
		c_b_1.setBounds(10, 100, 150, 80);
		JButton c_b_2 = new JButton("Delete contact");
		c_b_2.setBounds(160, 100, 150, 80);
		JButton c_b_3 = new JButton("Print contacts");
		c_b_3.setBounds(310, 100, 150, 80);
		JButton c_b_4 = new JButton("Search contact");
		c_b_4.setBounds(10, 180, 150, 80);
		JButton c_b_5 = new JButton("Sort by name");
		c_b_5.setBounds(160, 180, 150, 80);
		JButton c_b_6 = new JButton("Sort by number");
		c_b_6.setBounds(310, 180, 150, 80);
		JButton c_b_7 = new JButton("Remove duplicates");
		c_b_7.setBounds(10, 260, 150, 80);
		JButton c_b_8 = new JButton("Reverse");
		c_b_8.setBounds(160, 260, 150, 80);
		JButton c_b_9 = new JButton("Save in text file");
		c_b_9.setBounds(310, 260, 150, 80);
		JButton c_b_10 = new JButton("Load from text file");
		c_b_10.setBounds(10, 340, 150, 80);

		contacts_Frame.setSize(483, 550);
		contacts_Frame.setLayout(null);
		contacts_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contacts_Frame.setLocationRelativeTo(null);
		// contacts END

		// SMS frame
		SMS_frame.setSize(483, 550);
		SMS_frame.setLayout(null);
		SMS_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SMS_frame.setLocationRelativeTo(null);
		JButton SMS_b_1 = new JButton("new SMS");
		SMS_b_1.setBounds(10, 100, 150, 80);
		JButton SMS_b_2 = new JButton("Delete by person");
		SMS_b_2.setBounds(160, 100, 150, 80);
		JButton SMS_b_3 = new JButton("Print by person");
		SMS_b_3.setBounds(310, 100, 150, 80);
		JButton SMS_b_4 = new JButton("Find string");
		SMS_b_4.setBounds(10, 180, 150, 80);
		JButton SMS_b_5 = new JButton("Print all");
		SMS_b_5.setBounds(160, 180, 150, 80);
		// SMS frame END

		// Diary
		Diary_frame.setSize(483, 550);
		Diary_frame.setLayout(null);
		Diary_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Diary_frame.setLocationRelativeTo(null);

		JButton Diary_b_1 = new JButton("Add event");
		Diary_b_1.setBounds(10, 100, 150, 80);
		JButton Diary_b_2 = new JButton("Delete event");
		Diary_b_2.setBounds(160, 100, 150, 80);
		JButton Diary_b_3 = new JButton("Print by date");
		Diary_b_3.setBounds(310, 100, 150, 80);
		JButton Diary_b_4 = new JButton("Print by contact");
		Diary_b_4.setBounds(10, 180, 150, 80);
		JButton Diary_b_5 = new JButton("Print all events");
		Diary_b_5.setBounds(160, 180, 150, 80);

		// Diary END

		// Media

		Media_frame.setSize(483, 550);
		Media_frame.setLayout(null);
		Media_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Media_frame.setLocationRelativeTo(null);

		JButton Media_b_1 = new JButton("Add music");
		Media_b_1.setBounds(10, 100, 150, 80);
		JButton Media_b_2 = new JButton("Add video");
		Media_b_2.setBounds(160, 100, 150, 80);
		JButton Media_b_3 = new JButton("Turn on media");
		Media_b_3.setBounds(310, 100, 150, 80);
		JButton Media_b_4 = new JButton("Turn on all media");
		Media_b_4.setBounds(10, 180, 150, 80);
		// Media END

		// Trivia
		Trivia_main_frame.setSize(483, 550);
		Trivia_main_frame.setLayout(null);
		Trivia_main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Trivia_main_frame.setLocationRelativeTo(null);
		JButton Trivia_b_1 = new JButton("Start new game");
		Trivia_b_1.setBounds(167, 185, 150, 80);
		// Trivia END
		// Watch
		Watch_frame.setSize(483, 550);
		Watch_frame.setLayout(null);
		Watch_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Watch_frame.setLocationRelativeTo(null);

		// Watch END

		// All
		All_frame.setSize(483, 550);
		/// All_frame.setLayout(null);
		// All_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		All_frame.setLocationRelativeTo(null);

		// All END
		Contacts c = new Contacts();
		SMS sms = new SMS();
		Diary d = new Diary();
		MediaPlayer mp = new MediaPlayer();
		Trivia game_1 = new Trivia();
		ArrayList<Integer> question_number = new ArrayList<Integer>();
		c.addPerson(new Person("a", "1"));
		c.addPerson(new Person("b", "2"));
		c.addPerson(new Person("c", "3"));
		c.addPerson(new Person("Israel Israeli", "5135130"));
		c.addPerson(new Person("Noam Meir", "6285678"));
		c.addPerson(new Person("Jonathan Levi", "3117110"));
		c.addPerson(new Person("Itamar Aharoni", "32372120"));
		Calendar cale_1;
		Date dd_1;
		cale_1 = Calendar.getInstance();
		cale_1.set(2021, 5, 12, 1, 8);
		dd_1 = cale_1.getTime();
		try {
			sms.newTextByPerson(c.retPersonByname("a"), "ma hamatzav?");
			sms.newTextByPerson(c.retPersonByname("b"), "how are you?");
			sms.newTextByPerson(c.retPersonByname("c"), "bla bla bla");
			d.addEvent(new Meeting(dd_1, 10, c.retPersonByname("a")));
			cale_1.set(2021, 5, 13, 1, 8);
			dd_1 = cale_1.getTime();
			d.addEvent(new NotMeeting(dd_1, 10, "this is not a meeting"));
		} catch (Exception e) {

		}

		mp.addMedia(new Music("song 1", "12"));
		mp.addMedia(new Video("video 1", "15"));

		JButton b_1 = new JButton("SMS");
		b_1.setBounds(10, 150, 150, 80);
		JButton b_2 = new JButton("Contacts");
		b_2.setBounds(160, 150, 150, 80);
		JButton b_3 = new JButton("Media");
		b_3.setBounds(310, 150, 150, 80);
		JButton b_4 = new JButton("Watch");
		b_4.setBounds(10, 230, 150, 80);
		JButton b_5 = new JButton("Trivia");
		b_5.setBounds(160, 230, 150, 80);
		JButton b_6 = new JButton("Diary");
		b_6.setBounds(310, 230, 150, 80);
		JButton b_7 = new JButton("Weather");
		b_7.setBounds(10, 310, 150, 80);
		JButton b_8 = new JButton("Print all content");
		b_8.setBounds(160, 310, 150, 80);

		// ____________________________________________________________________________________________________________________
		JFrame frame_Print_contacts = new JFrame(); // Print contacts
		frame_Print_contacts.setSize(400, 550);
		frame_Print_contacts.setLocationRelativeTo(null);

		JButton back_print_pcontacts = new JButton("Back");
		back_print_pcontacts.setBounds(300, 0, 80, 60);
		// ____________________________________________________________________________________________________________________
		// ____________________________________________________________________________________________________________________
		JFrame frame_Print_SMS = new JFrame(); // Print contacts
		frame_Print_SMS.setSize(400, 550);
		frame_Print_SMS.setLocationRelativeTo(null);

		JButton back_print_SMS = new JButton("Back");
		back_print_SMS.setBounds(300, 0, 80, 60);
		// ____________________________________________________________________________________________________________________
		// ____________________________________________________________________________________________________________________
		JFrame frame_Print_Events = new JFrame(); // Print events
		frame_Print_Events.setSize(400, 550);
		frame_Print_Events.setLocationRelativeTo(null);

		JButton back_print_Events = new JButton("Back");
		back_print_Events.setBounds(300, 0, 80, 60);
		// ____________________________________________________________________________________________________________________
		// ____________________________________________________________________________________________________________________
		JFrame frame_Print_Media = new JFrame(); // Print media
		frame_Print_Media.setSize(400, 550);
		frame_Print_Media.setLocationRelativeTo(null);

		JButton back_print_Media = new JButton("Back");
		back_print_Media.setBounds(300, 0, 80, 60);
		// ____________________________________________________________________________________________________________________
		// ____________________________________________________________________________________________________________________
		JFrame frame_Print_Trivia_game = new JFrame(); // Print media
		frame_Print_Trivia_game.setSize(400, 550);
		frame_Print_Trivia_game.setLayout(null);
		frame_Print_Trivia_game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_Print_Trivia_game.setLocationRelativeTo(null);

		JButton back_print_Trivia = new JButton("Back");
		back_print_Trivia.setBounds(300, 10, 80, 60);

		JButton life_1 = new JButton("life : " + "3");
		life_1.setBounds(220, 10, 80, 60);
		JButton prize_b = new JButton("prize : " + "0");
		prize_b.setBounds(100, 10, 120, 60);

		JTextArea question_1 = new JTextArea("hi");
		question_1.setBounds(45, 150, 300, 50);
		question_1.setEditable(false);

		JButton answer_1 = new JButton("answer_1");
		answer_1.setBounds(45, 200, 150, 100);
		JButton answer_2 = new JButton("answer_2");
		answer_2.setBounds(195, 200, 150, 100);
		JButton answer_3 = new JButton("answer_3");
		answer_3.setBounds(45, 300, 150, 100);
		JButton answer_4 = new JButton("answer_4");
		answer_4.setBounds(195, 300, 150, 100);

		// ____________________________________________________________________________________________________________________

		// ____________________________________________________________________________________________________________________
		// JFrame frame_Watch_menu = new JFrame(); // Print watch menu
		// frame_Watch_menu.setSize(400, 550);
		// frame_Watch_menu.setLocationRelativeTo(null);

		JButton back_watch_menu = new JButton("Back");
		back_watch_menu.setBounds(300, 0, 80, 60);
		JButton Timer_1 = new JButton("Timer");
		Timer_1.setBounds(92, 185, 150, 80);
		JButton Stopper_1 = new JButton("Stopper");
		Stopper_1.setBounds(243, 185, 150, 80);

		// _____________________________________________________________________________________________________________________

		ActionListener a_1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abs_b = (AbstractButton) actionEvent.getSource();
				String b_name = abs_b.getText();

				switch (b_name) { // Contacts app
				case "Contacts":
					Main_frame.setVisible(false);
					contacts_Frame.setVisible(true);
					break;
				case "SMS":
					Main_frame.setVisible(false);
					SMS_frame.setVisible(true);
					break;
				case "Diary":
					Main_frame.setVisible(false);
					Diary_frame.setVisible(true);
					break;
				case "Media":
					Main_frame.setVisible(false);
					Media_frame.setVisible(true);
					break;
				case "Trivia":
					Main_frame.setVisible(false);
					Trivia_main_frame.setVisible(true);
					break;
				case "Watch":
					Main_frame.setVisible(false);
					Watch_frame.setVisible(true);
					break;
				case "Weather":
					new Weather();
					break;
				case "Print all content":
					ArrayList<String> all_to_print_1 = new ArrayList<String>();
					ArrayList<String> all_to_print_2 = new ArrayList<String>();
					String[] All_to_print;
					All_to_print = c.print();
					all_to_print_2.addAll(Arrays.asList(All_to_print));
					all_to_print_1.addAll(all_to_print_2);
					all_to_print_2 = sms.printAllTexts();
					all_to_print_1.add(" ");
					all_to_print_1.add("SMS: ");
					all_to_print_1.addAll(all_to_print_2);
					all_to_print_2 = d.printAll();
					all_to_print_1.add(" ");
					all_to_print_1.add("Diary: ");
					all_to_print_1.addAll(all_to_print_2);
					all_to_print_2 = mp.turnOnAllMedia();
					all_to_print_1.add(" ");
					all_to_print_1.add("Media: ");
					all_to_print_1.addAll(all_to_print_2);
					String[] print_all_1 = new String[all_to_print_1.size()];
					print_all_1 = (String[]) all_to_print_1.toArray(print_all_1);
					JScrollPane scroll_p_9; // JScrollPane
					JList<String> list_of_all = new JList<String>(print_all_1);
					scroll_p_9 = new JScrollPane(list_of_all);
					All_frame.add(scroll_p_9);
					Main_frame.setVisible(false);
					All_frame.setVisible(true);
					break;
				}
			}

		};
		ActionListener contacts_listener_1 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				String inst, number;
				int value;
				AbstractButton abs_b = (AbstractButton) actionEvent.getSource();
				String b_name = abs_b.getText();
				String name;
				String contacts_to_print[];
				String messages_to_print[];
				String string_to_find;
				String con_p = "";
				String p_1;
				String fileName = "";
				String name_of_contact;
				String number_of_contact;
				String message;
				String all_media[];
				// Diary variables
				int date, hour, minute, dur;
				Calendar cale;
				Date dd;
				String Events_to_print[];

				//

				switch (b_name) {
				case "Add contact":
					name_of_contact = JOptionPane.showInputDialog("what is the name of the contact?");
					number_of_contact = JOptionPane.showInputDialog("what is the number of the contact?");
					c.addPerson(new Person(name_of_contact, number_of_contact));
					break;

				case "Print contacts":
					JScrollPane scroll_p_1; // JScrollPane
					contacts_to_print = c.print();
					int a = 0;
					for (a = 0; a < contacts_to_print.length; a++) {
						con_p = con_p + contacts_to_print[a] + "\n";
					}
					if (contacts_to_print.length == 1) {
						System.out.println("length = 0");
						contacts_to_print[0] = "no contacts";

					}
					JList<String> list = new JList<String>(contacts_to_print);
					scroll_p_1 = new JScrollPane(list);
					frame_Print_contacts.add(scroll_p_1);
					contacts_Frame.setVisible(false);
					frame_Print_contacts.setVisible(true);
					break;
				case "Delete contact":
					String name_to_del = JOptionPane.showInputDialog("Who do you want to delete?");
					if (c.inContacts(name_to_del)) {
						c.removePerson(name_to_del);
						if (sms.isInTexts(name_to_del))
							sms.deleteTextsByName(name_to_del);
					} else
						JOptionPane.showMessageDialog(null, "Person was not found");
					break;
				case "Search contact":
					String name_to_search = JOptionPane.showInputDialog("Search");
					p_1 = c.searchPersonByName(name_to_search);
					JOptionPane.showMessageDialog(null, p_1);
					break;
				case "Sort by name":
					c.sortPersonsByName();
					JOptionPane.showMessageDialog(null, "contacts are sorted by name");
					break;
				case "Sort by number":
					c.sortPersonsByPhoneNumber();
					JOptionPane.showMessageDialog(null, "contacts are sorted by number");
					break;
				case "Remove duplicates":
					c.removeDup();
					JOptionPane.showMessageDialog(null, "removed  duplicates");
					break;

				case "Reverse":
					c.reverseOrder();
					JOptionPane.showMessageDialog(null, "order is reversed");
					break;
				case "Save in text file":
					fileName = JOptionPane.showInputDialog("Enter name (without .txt):");
					c.writeInFile(fileName);
					JOptionPane.showMessageDialog(null, "Contacts were written to file");
					break;
				case "Load from text file":
					fileName = JOptionPane.showInputDialog("Enter path:");
					c.readFromFile(fileName);
					JOptionPane.showMessageDialog(null, "Contacts were loaded fromm the file");
				case "new SMS":
					name_of_contact = JOptionPane.showInputDialog("what is the name of the contact?");
					if (c.inContacts(name_of_contact)) {
						message = JOptionPane.showInputDialog("enter the messsage");
						try {
							sms.newTextByPerson(c.retPersonByname(name_of_contact), message);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error: " + e.toString());
						}
					} else
						JOptionPane.showMessageDialog(null, "Person was not found");
					break;
				case "Delete by person":
					name_of_contact = JOptionPane.showInputDialog("what is the name of the contact?");
					if (c.inContacts(name_of_contact)) {
						try {
							sms.deleteTextsByName(name_of_contact);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error: " + e.toString());
						}
					} else
						JOptionPane.showMessageDialog(null, "Person was not found");

					break;

				case "Print by person":
					name_of_contact = JOptionPane.showInputDialog("what is the name of the contact?");
					if (c.inContacts(name_of_contact)) {
						if (sms.isInTexts(name_of_contact)) {

							ArrayList<String> text_to_print_SMS = new ArrayList<String>();
							JScrollPane scroll_p_2; // JScrollPane
							text_to_print_SMS = sms.findTxtByPerson(name_of_contact).get_text_list();
							messages_to_print = new String[text_to_print_SMS.size() + 1];
							Iterator<String> it = text_to_print_SMS.iterator();
							int i_sms = 0;
							while (it.hasNext()) {
								messages_to_print[i_sms] = it.next();
								i_sms = i_sms + 1;

							}

							JList<String> list_of_messages = new JList<String>(messages_to_print);
							scroll_p_2 = new JScrollPane(list_of_messages);

							frame_Print_SMS.add(scroll_p_2);
							SMS_frame.setVisible(false);
							frame_Print_SMS.setVisible(true);
						} else
							JOptionPane.showMessageDialog(null, "Person does not have texts");

					} else
						JOptionPane.showMessageDialog(null, "Person was not found");

					break;

				case "Find string":
					JScrollPane scroll_p_3; // JScrollPane
					string_to_find = JOptionPane.showInputDialog("Enter the string to find");
					ArrayList<String> contacts_who_have_string = new ArrayList<String>();
					contacts_who_have_string = sms.searchForStr(string_to_find);
					messages_to_print = new String[contacts_who_have_string.size()];
					messages_to_print = (String[]) contacts_who_have_string.toArray(messages_to_print);

					JList<String> list_of_messages = new JList<String>(messages_to_print);
					scroll_p_3 = new JScrollPane(list_of_messages);
					frame_Print_SMS.add(scroll_p_3);
					SMS_frame.setVisible(false);
					frame_Print_SMS.setVisible(true);

					break;

				case "Print all":
					JScrollPane scroll_p_4; // JScrollPane
					ArrayList<String> all_messages_to_print = new ArrayList<String>();
					all_messages_to_print = sms.printAllTexts();
					messages_to_print = new String[all_messages_to_print.size()];
					messages_to_print = (String[]) all_messages_to_print.toArray(messages_to_print);
					JList<String> list_of_all_messages = new JList<String>(messages_to_print);
					scroll_p_4 = new JScrollPane(list_of_all_messages);
					frame_Print_SMS.add(scroll_p_4);
					SMS_frame.setVisible(false);
					frame_Print_SMS.setVisible(true);
					break;

				case "Add event":
					date = Integer.parseInt(JOptionPane.showInputDialog("Enter date: (1-30)"));
					hour = Integer.parseInt(JOptionPane.showInputDialog("Enter hour: (0-23)"));
					minute = Integer.parseInt(JOptionPane.showInputDialog("Enter minute: (0-59)"));
					if (!d.validDate(date, hour, minute)) {
						JOptionPane.showMessageDialog(null, "Input is not valid");
						break;
					}

					cale = Calendar.getInstance();
					cale.set(2021, 5, date, hour, minute);
					dd = cale.getTime();
					dur = Integer.parseInt(JOptionPane.showInputDialog("Enter duration: (1-60)"));
					if (dur <= 60 && dur >= 1) { // if duration is valid
						while (true) {
							int type = Integer
									.parseInt(JOptionPane.showInputDialog("Enter 1 for meeting, 2 for not meeting"));

							if (type == 1) { // if type is Meeting
								name = JOptionPane.showInputDialog("Enter person name:");
								try {
									if (c.inContacts(name)) {
										d.addEvent(new Meeting(dd, dur, c.retPersonByname(name))); // no need number
										break;
									} else
										JOptionPane.showMessageDialog(null, "Person was not found");
								} catch (CloneNotSupportedException e) {
									JOptionPane.showMessageDialog(null, "An error occurred, try again"); // clone
																											// problem

								}
							}
							if (type == 2) { // if type is NotMeeting
								String des = JOptionPane.showInputDialog("Enter description:");
								try {
									d.addEvent(new NotMeeting(dd, dur, des)); // No need to check if person in the
																				// contacts

									break;
								} catch (CloneNotSupportedException e) {
									JOptionPane.showMessageDialog(null, "An error occurred, try again"); // clone
																											// problem
								}
							} else
								JOptionPane.showMessageDialog(null, "Wrong input! Try again!");
						}
					} else // if duration is invalid
						JOptionPane.showMessageDialog(null, "Error! Duration must be between 1 to 60");
					break;
				case "Delete event":
					date = Integer.parseInt(JOptionPane.showInputDialog("Enter date: (1-30)"));
					if (!d.validDate(date, 1, 1)) {
						JOptionPane.showMessageDialog(null, "Invalid date");
						break;
					}

					cale = Calendar.getInstance();
					cale.set(2021, 5, date);
					d.delLastEvent(cale.getTime());

					break;
				case "Print by date":
					date = Integer.parseInt(JOptionPane.showInputDialog("Enter date: (1-30)"));
					if (!d.validDate(date, 1, 1)) {
						JOptionPane.showMessageDialog(null, "Invalid date");
						break;
					}

					cale = Calendar.getInstance();
					cale.set(2021, 5, date);
					LinkedList<Event> e_1 = new LinkedList<Event>();

					e_1 = d.printAllByDate(cale.getTime());
					if (e_1.isEmpty()) {
						Events_to_print = new String[1];
						Events_to_print[0] = "there are no events that day";

					} else {
						Events_to_print = new String[e_1.size()];
						Iterator<Event> itr_events = e_1.iterator();
						int index_event = 0;
						while (itr_events.hasNext()) {
							Events_to_print[index_event] = itr_events.next().toString();
						}
					}
					JScrollPane scroll_p_5; // JScrollPane
					JList<String> list_of_events = new JList<String>(Events_to_print);
					scroll_p_5 = new JScrollPane(list_of_events);
					frame_Print_Events.add(scroll_p_5);
					Diary_frame.setVisible(false);
					frame_Print_Events.setVisible(true);
					break;
				case "Print by contact":
					ArrayList<String> events_to_print_list = new ArrayList<String>();
					name = JOptionPane.showInputDialog("Enter person name:");
					if (c.inContacts(name)) {
						events_to_print_list = d.printAllByPerson(name);
						Events_to_print = new String[events_to_print_list.size()];
						Events_to_print = (String[]) events_to_print_list.toArray(Events_to_print);
						JScrollPane scroll_p_6; // JScrollPane
						JList<String> list_of_events_1 = new JList<String>(Events_to_print);
						scroll_p_6 = new JScrollPane(list_of_events_1);
						frame_Print_Events.add(scroll_p_6);
						Diary_frame.setVisible(false);
						frame_Print_Events.setVisible(true);
						break;
					}

					else
						JOptionPane.showMessageDialog(null, "Person not found");

					break;

				case "Print all events":
					ArrayList<String> events_to_print_list_1 = new ArrayList<String>();
					events_to_print_list_1 = d.printAll();
					Events_to_print = new String[events_to_print_list_1.size()];
					Events_to_print = (String[]) events_to_print_list_1.toArray(Events_to_print);
					JScrollPane scroll_p_7; // JScrollPane
					JList<String> list_of_events_2 = new JList<String>(Events_to_print);
					scroll_p_7 = new JScrollPane(list_of_events_2);
					frame_Print_Events.add(scroll_p_7);
					Diary_frame.setVisible(false);
					frame_Print_Events.setVisible(true);
					break;
				case "Add music":
					String musicName = JOptionPane.showInputDialog("Enter the name of the music");
					String musicLength = JOptionPane.showInputDialog("Enter the length of the music");
					try {
						value = Integer.parseInt(musicLength);
						mp.addMedia(new Music(musicName, musicLength));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error! Invalid length");
					}
					break;

				case "Add video":
					String videoName = JOptionPane.showInputDialog("Enter the name of the video");
					String videoLength = JOptionPane.showInputDialog("Enter the length of the video");
					try {
						value = Integer.parseInt(videoLength);
						mp.addMedia(new Video(videoName, videoLength));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error! Invalid length");
					}

					break;

				case "Turn on media":
					String mediaName = JOptionPane.showInputDialog("Enter the name of the media");

					String media_to_print = mp.turnOnMediaByName(mediaName);
					JOptionPane.showMessageDialog(null, media_to_print);

					break;
				case "Turn on all media":
					ArrayList<String> All_Media_list = new ArrayList<String>();
					All_Media_list = mp.turnOnAllMedia();
					all_media = new String[All_Media_list.size()];
					all_media = (String[]) All_Media_list.toArray(all_media);
					JScrollPane scroll_p_8; // JScrollPane
					JList<String> list_of_all_media = new JList<String>(all_media);
					scroll_p_8 = new JScrollPane(list_of_all_media);
					frame_Print_Media.add(scroll_p_8);
					Media_frame.setVisible(false);
					frame_Print_Media.setVisible(true);
					break;
				case "Start new game":
					Trivia_main_frame.setVisible(false);
					int questionNum = game_1.generateQuestion();
					question_number.clear();
					question_number.add(questionNum);
					Question q_1 = game_1.getQuestion(questionNum);
					answer_1.setText(q_1.getAnswers()[0]);
					answer_2.setText(q_1.getAnswers()[1]);
					answer_3.setText(q_1.getAnswers()[2]);
					answer_4.setText(q_1.getAnswers()[3]);
					question_1.setText(q_1.getQuestion());
					prize_b.setText("prize : " + game_1.getPirze());
					life_1.setText("life : " + Integer.toString(game_1.getlife()));
					frame_Print_Trivia_game.setVisible(true);
					break;
				case "Timer":
					new TimerLauncher();
					break;
				case "Stopper":
					new StopwatchLauncher();
					break;

				}
			}
		};
		ActionListener Back_contacts = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				frame_Print_contacts.setVisible(false);
				frame_Print_contacts.getContentPane().remove(1);
				contacts_Frame.setVisible(true);

			}
		};

		ActionListener Back_SMS = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				frame_Print_SMS.setVisible(false);
				frame_Print_SMS.getContentPane().remove(1);
				SMS_frame.setVisible(true);

			}
		};
		ActionListener Back_Event = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				frame_Print_Events.setVisible(false);
				frame_Print_Events.getContentPane().remove(1);
				Diary_frame.setVisible(true);

			}
		};
		ActionListener Back_Media = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				frame_Print_Media.setVisible(false);
				frame_Print_Media.getContentPane().remove(1);
				Media_frame.setVisible(true);

			}
		};

		ActionListener Trivia_Game = new ActionListener() {
			int counter = 0;

			public void actionPerformed(ActionEvent actionEvent) {

				AbstractButton abs_b = (AbstractButton) actionEvent.getSource();
				String Answer = abs_b.getText();
				int number_of_question = question_number.get(0);

				if (Answer == "Back") {
					frame_Print_Trivia_game.setVisible(false);
					game_1.resetgame();
					counter = 0;
					Trivia_main_frame.setVisible(true);

				} else {
					if (game_1.isCorrectAnswer(number_of_question, Answer)) {
						prize_b.setText("prize : " + game_1.getPirze());
					} else {
						life_1.setText("life : " + Integer.toString(game_1.getlife()));
					}
					if (game_1.getlife() == 0) {
						JOptionPane.showMessageDialog(null, "You Lost");
						frame_Print_Trivia_game.setVisible(false);
						game_1.resetgame();
						counter = 0;
						Trivia_main_frame.setVisible(true);
					} else {
						int questionNum = game_1.generateQuestion();
						question_number.clear();
						question_number.add(questionNum);
						Question q_1 = game_1.getQuestion(questionNum);
						answer_1.setText(q_1.getAnswers()[0]);
						answer_2.setText(q_1.getAnswers()[1]);
						answer_3.setText(q_1.getAnswers()[2]);
						answer_4.setText(q_1.getAnswers()[3]);
						question_1.setText(q_1.getQuestion());
						counter++;
						if (counter == game_1.getRounds()) {
							JOptionPane.showMessageDialog(null, "You Won " + game_1.getPirze() + "$");
							frame_Print_Trivia_game.setVisible(false);
							game_1.resetgame();
							counter = 0;
							Trivia_main_frame.setVisible(true);
						}

					}
				}

			}
		};

		ActionListener Back_Watch = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				Watch_frame.setVisible(false);
				// frame_Print_Media.getContentPane().remove(1);
				Main_frame.setVisible(true);

			}
		};

		ActionListener general_back_action = new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {
				Iterator<JFrame> it = all_frames.iterator();
				while (it.hasNext()) {
					it.next().setVisible(false);

				}
				Main_frame.setVisible(true);
			}
		};

		// general back button
		general_back_contacts.addActionListener(general_back_action);
		contacts_Frame.add(general_back_contacts);
		general_back_SMS.addActionListener(general_back_action);
		SMS_frame.add(general_back_SMS);
		general_back_Diary.addActionListener(general_back_action);
		Diary_frame.add(general_back_Diary);
		general_back_Media.addActionListener(general_back_action);
		Media_frame.add(general_back_Media);
		general_back_Trivia.addActionListener(general_back_action);
		Trivia_main_frame.add(general_back_Trivia);
		general_back_Watch.addActionListener(general_back_action);
		Watch_frame.add(general_back_Watch);
		general_back_All.addActionListener(general_back_action);
		All_frame.add(general_back_All);

		//

		// main
		b_1.addActionListener(a_1);
		Main_frame.add(b_1);
		b_2.addActionListener(a_1);
		Main_frame.add(b_2);
		b_3.addActionListener(a_1);
		Main_frame.add(b_3);
		b_4.addActionListener(a_1);
		Main_frame.add(b_4);
		b_5.addActionListener(a_1);
		Main_frame.add(b_5);
		b_6.addActionListener(a_1);
		Main_frame.add(b_6);
		b_7.addActionListener(a_1);
		Main_frame.add(b_7);
		b_8.addActionListener(a_1);
		Main_frame.add(b_8);

		// END main

		// Contacts
		c_b_1.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_1);
		c_b_2.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_2);
		c_b_3.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_3);
		c_b_4.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_4);
		c_b_5.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_5);
		c_b_6.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_6);
		c_b_7.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_7);
		c_b_8.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_8);
		c_b_9.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_9);
		c_b_10.addActionListener(contacts_listener_1);
		contacts_Frame.add(c_b_10);
		// END Contacts

		// SMS
		back_print_SMS.addActionListener(Back_SMS);
		frame_Print_SMS.add(back_print_SMS);
		SMS_b_1.addActionListener(contacts_listener_1);
		SMS_frame.add(SMS_b_1);
		SMS_b_2.addActionListener(contacts_listener_1);
		SMS_frame.add(SMS_b_2);
		SMS_b_3.addActionListener(contacts_listener_1);
		SMS_frame.add(SMS_b_3);
		SMS_b_4.addActionListener(contacts_listener_1);
		SMS_frame.add(SMS_b_4);
		SMS_b_5.addActionListener(contacts_listener_1);
		SMS_frame.add(SMS_b_5);

		// END SMS
		// Diary
		Diary_b_1.addActionListener(contacts_listener_1);
		Diary_frame.add(Diary_b_1);
		Diary_b_2.addActionListener(contacts_listener_1);
		Diary_frame.add(Diary_b_2);
		Diary_b_3.addActionListener(contacts_listener_1);
		Diary_frame.add(Diary_b_3);
		Diary_b_4.addActionListener(contacts_listener_1);
		Diary_frame.add(Diary_b_4);
		Diary_b_5.addActionListener(contacts_listener_1);
		Diary_frame.add(Diary_b_5);
		back_print_Events.addActionListener(Back_Event);
		frame_Print_Events.add(back_print_Events);

		// END Diary

		// Media
		Media_b_1.addActionListener(contacts_listener_1);
		Media_frame.add(Media_b_1);
		Media_b_2.addActionListener(contacts_listener_1);
		Media_frame.add(Media_b_2);
		Media_b_3.addActionListener(contacts_listener_1);
		Media_frame.add(Media_b_3);
		Media_b_4.addActionListener(contacts_listener_1);
		Media_frame.add(Media_b_4);
		back_print_Media.addActionListener(Back_Media);
		frame_Print_Media.add(back_print_Media);

		// Media END

		// Trivia
		Trivia_b_1.addActionListener(contacts_listener_1);
		Trivia_main_frame.add(Trivia_b_1);

		back_print_Trivia.addActionListener(Trivia_Game);
		frame_Print_Trivia_game.add(back_print_Trivia);

		answer_1.addActionListener(Trivia_Game);
		answer_2.addActionListener(Trivia_Game);

		answer_3.addActionListener(Trivia_Game);
		answer_4.addActionListener(Trivia_Game);

		frame_Print_Trivia_game.add(life_1);
		frame_Print_Trivia_game.add(question_1);
		frame_Print_Trivia_game.add(prize_b);
		frame_Print_Trivia_game.add(answer_1);
		frame_Print_Trivia_game.add(answer_2);
		frame_Print_Trivia_game.add(answer_3);
		frame_Print_Trivia_game.add(answer_4);

		// Trivia END

		back_print_pcontacts.addActionListener(Back_contacts);
		frame_Print_contacts.add(back_print_pcontacts);

		// Watch
		// back_watch_menu.addActionListener(Back_Watch);
		// Watch_frame.add(back_watch_menu);
		Timer_1.addActionListener(contacts_listener_1);
		Watch_frame.add(Timer_1);
		Stopper_1.addActionListener(contacts_listener_1);
		Watch_frame.add(Stopper_1);

		// Watch END

		Main_frame.setVisible(true);

	}

}
