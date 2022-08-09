package tar2;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Phone {

	public Phone() {
	}

	public void handlePhoneUser() throws CloneNotSupportedException {
		Scanner reader = new Scanner(System.in);
		boolean[] gameFlag = { true, true, true, true, true };
		String inst, name, number, fileName, message;
		int date, hour, minute, dur, value;
		Calendar cale;
		Date dd;

		Contacts c = new Contacts();
		SMS sms = new SMS();
		Diary d = new Diary();
		MediaPlayer mp = new MediaPlayer();

		while (gameFlag[0]) {
			printPhoneMenu();
			inst = reader.nextLine();

			switch (inst) {

			// Contacts app
			case "1":
				while (gameFlag[1]) {
					c.printContactsMenu();
					inst = reader.nextLine();

					switch (inst) {

					case "1":
						System.out.println("Enter name:");
						name = reader.nextLine();
						System.out.println("Enter number:");
						number = reader.nextLine();
						c.addPerson(new Person(name, number));
						break;

					// need to remove the SMS AND THE APPOINTMENTS IN THE DIARY WITH THE CONTACT
					case "2":
						System.out.println("Enter name:");
						name = reader.nextLine();
						if (c.inContacts(name)) {
							d.delEventByName(name);
							c.removePerson(name);
							if (sms.isInTexts(name))
								sms.deleteTextsByName(name);
						} else
							System.out.println("Person was not found");
						break;

					case "3":
						c.print();
						break;

					case "4":
						System.out.println("Enter name:");
						name = reader.nextLine();
						c.searchPersonByName(name);
						break;

					case "5":
						c.sortPersonsByName();
						System.out.println("Sorted\n");
						break;

					case "6":
						c.sortPersonsByPhoneNumber();
						System.out.println("Sorted\n");
						break;

					// need to remove the SMS AND THE APPOINTMENTS IN THE DIARY WITH THE CONTACT
					case "7":
						c.removeDup();
						System.out.println("Removed");
						break;

					case "8":
						c.reverseOrder();
						break;

					case "9":
						System.out.println("Enter name (without .txt):");
						fileName = reader.nextLine();
						c.writeInFile(fileName);
						break;

					case "10":
						System.out.println("Enter path:");
						fileName = reader.nextLine();
						c.readFromFile(fileName);
						break;

					case "11":
						System.out.println("Exited from the contacts app");
						gameFlag[1] = false;
						break;

					default:
						System.out.println("Wrong input! Try again!\n");
					}
				}
				break;

			// SMS app
			case "2":

				while (gameFlag[2]) {
					sms.printSMSMenu();
					inst = reader.nextLine();
					switch (inst) {

					case "1":
						System.out.println("Enter the person name:");
						name = reader.nextLine();
						if (c.inContacts(name)) {
							System.out.println("Enter the message:");
							message = reader.nextLine();
							sms.newTextByPerson(c.retPersonByname(name), message);
						} else
							System.out.println("Person not found");
						break;
					case "2":
						System.out.println("Enter the person name:");
						name = reader.nextLine();
						if (c.inContacts(name)) {
							sms.deleteTextsByName(name);
						} else
							System.out.println("Person not found");
						break;
					case "3":
						System.out.println("Enter the person name:");
						name = reader.nextLine();
						if (c.inContacts(name)) {
							sms.printTxtByName(name);
						} else
							System.out.println("Person not found");
						break;
					case "4":
						System.out.println("Enter the string you want to find:");
						message = reader.nextLine();
						sms.searchForStr(message);
						break;
					case "5":
						sms.printAllTexts();
						break;
					case "6":
						System.out.print("Exited from SMS app\n");
						gameFlag[2] = false;
						break;
					default:
						System.out.println("Wrong input! Try again!");
					}
				}
				break;

			// Diary app
			case "3":
				while (gameFlag[3]) {
					d.printDiaryMenu();
					inst = reader.nextLine();
					switch (inst) {
					case "1":
						System.out.println("Enter date: (1-30)");
						date = reader.nextInt();
						reader.nextLine();
						System.out.println("Enter hour: (0-23)");
						hour = reader.nextInt();
						reader.nextLine();
						System.out.println("Enter minute: (0-59)");
						minute = reader.nextInt();
						reader.nextLine();
						if (!d.validDate(date, hour, minute))
							break;
						cale = Calendar.getInstance();
						cale.set(2021, 5, date, hour, minute);
						dd = cale.getTime();
						System.out.println("Enter duration: (1-60)");
						dur = reader.nextInt();
						reader.nextLine();

						if (dur <= 60 || dur >= 1) { // if duration is valid
							while (true) {
								System.out.println("Enter 1 for meeting, 2 for not meeting");
								int type = reader.nextInt();
								reader.nextLine();
								if (type == 1) { // if type is Meeting
									System.out.println("Enter person name:");
									name = reader.nextLine();
									try {
										if (c.inContacts(name)) {
											d.addEvent(new Meeting(dd, dur, c.retPersonByname(name))); // no need number
											break;
										}
										else
											System.out.println("Person was not found\n");
									} catch (CloneNotSupportedException e) {
										System.out.println("An error occurred, try again"); // clone problem
									}
								}
								if (type == 2) { // if type is NotMeeting
									System.out.println("Enter description:");
									String des = reader.nextLine();
									try {
										d.addEvent(new NotMeeting(dd, dur, des)); // No need to check if person in the
																					// contacts
										break;
									} catch (CloneNotSupportedException e) {
										System.out.println("An error occurred, try again"); // clone problem
									}
								} else
									System.out.println("Wrong input! Try again!");
							}
						} else // if duration is invalid
							System.out.println("Error! Duration must be between 1 to 60");

						break;
					case "2":
						System.out.println("Enter date: (1-30)");
						date = reader.nextInt();
						reader.nextLine();
						if (!d.validDate(date, 1, 1))
							break;
						cale = Calendar.getInstance();
						cale.set(2021, 5, date);
						d.delLastEvent(cale.getTime());

						break;
					case "3":
						System.out.println("Enter date: (1-30)");
						date = reader.nextInt();
						reader.nextLine();
						if (!d.validDate(date, 1, 1))
							break;
						cale = Calendar.getInstance();
						cale.set(2021, 5, date);
						d.printAllByDate(cale.getTime());

						break;
					case "4":
						System.out.println("Enter person name:");
						name = reader.nextLine();
						if (c.inContacts(name))
							d.printAllByPerson(name);
						else
							System.out.println("Person not found");
						break;
					case "5":
						d.printAll();
						break;
					case "6":
						System.out.print("Exited from Diary app\n");
						gameFlag[3] = false;
						break;

					default:
						System.out.println("Wrong input! Try again!");
					}
				}
				break;

			// Media app
			case "4":
				while (gameFlag[4]) {
					mp.printMPMenu();
					inst = reader.nextLine();
					switch (inst) {
					case "1":
						System.out.println("Enter the name of the music:");
						String musicName = reader.nextLine();
						System.out.println("Enter the length of the music:");
						String musicLength = reader.nextLine();
						try {
							value = Integer.parseInt(musicLength);
							mp.addMedia(new Music(musicName, musicLength));
						} catch (NumberFormatException e) {
							System.out.println("Error! Invalid length");
						}
						break;
					case "2":
						System.out.println("Enter the name of the video:");
						String videoName = reader.nextLine();
						System.out.println("Enter the length of the video:");
						String videoLength = reader.nextLine();
						try {
							value = Integer.parseInt(videoLength);
							mp.addMedia(new Video(videoName, videoLength));
						} catch (NumberFormatException e) {
							System.out.println("Error! Invalid length");
						}
						break;
					case "3":
						System.out.println("Enter the name of the media:");
						String mediaName = reader.nextLine();
						mp.turnOnMediaByName(mediaName);
						break;
					case "4":
						mp.turnOnAllMedia();
						break;
					case "5":
						System.out.println("Exited from media app");
						gameFlag[4] = false;
						break;
					default:
						System.out.println("Wrong input! Try again!\n");
					}
				}
				break;

			case "5":
				System.out.println("Contacts app:");
				c.print();
				System.out.println("\nSMS app:");
				sms.printAllTexts();
				System.out.println("\nDiary app:");
				d.printAll();
				System.out.println("\nMedia app:");
				mp.turnOnAllMedia();
				break;

			case "6":
				System.out.print("Exited from phone\n");
				gameFlag[0] = false;
				break;

			default:
				System.out.println("Wrong input! Try again!");
			}

			gameFlag[1] = gameFlag[2] = gameFlag[3] = gameFlag[4] = true; // reset the gameFlag of the apps
			System.out.println();
		}
		reader.close();
	}

	public void printPhoneMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1.	Contacts app");
		System.out.println("2.	SMS app");
		System.out.println("3.	Diary app");
		System.out.println("4.	Media app");
		System.out.println("5.	Print the content of all apps");
		System.out.println("6.	Exit");
	}

}
