import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
	public static <Strings, strings> void main(String[] args) throws IOException, InvalidInput, WrongPassword,
			TicketDoesntExist, IndexOutofBound, NullValueException, InputDoesntExist {
		
		// Displaying Menu to the User
		System.out.println("\n");
		System.out.println(
				"               ------------------------------------------------------------------            ");
		System.out.println(
				"               |              WELCOME TO AIRLINE RESERVATION SYSTEM             |            ");
		System.out.println(
				"               ------------------------------------------------------------------            ");
		System.out.println("\n");

		// ==============================================Saving
		// State=======================================
		String data3 = " ";

		int counter = 0;
		try {
			
			File myObj = new File("src\\flights.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				data3 = myReader.nextLine();
				counter++;
				
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		Flight[] fly = new Flight[counter];
		for (int i = 0; i < counter; i++) {
			fly[i] = new Flight(" ", " ", " ", " ", " ", " ", " ", " ", " ");
		}

		if (counter > fly.length) {
			throw new IndexOutofBound("Index out of Bound");
		}
		
		int counter4 = 0;
		data3 = " ";
		int count4 = 0;
		String[] store3 = new String[9];
		try {
			File myObj = new File("src\\flights.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				data3 = myReader.nextLine();
				String[] words = data3.split("\\.");
				count4 = 0;

				for (String w : words) {
					store3[count4] = w;
					count4++;
				}

				fly[counter4].setPlane_no(store3[0]);
				fly[counter4].setOrigin(store3[1]);
				fly[counter4].setDest(store3[2]);
				fly[counter4].setDate(store3[3]);
				fly[counter4].setTime(store3[4]);
				fly[counter4].setTraveleclass(store3[5]);
				fly[counter4].setTravelbclass(store3[6]);
				fly[counter4].setType(store3[7]);
				fly[counter4].setFlighttype(store3[8]);
				counter4++;

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		String data5 = " ";
		int count5 = 0;
		String[] store2 = new String[10];

		try {
			File myObj = new File("src\\Ticket.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				data5 = myReader.nextLine();
				String[] words = data5.split("\\.");
				count5 = 0;

				for (String w : words) {
					store2[count5] = w;
					count5++;
				}
				for(int i = 0; i < counter4; i++)
				{
					
					if(store2[1].equals(fly[i].getPlane_no()))
					{

						fly[i].setReservationIndex(Integer.parseInt(store2[8]),1);
					}

				}
				
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		// =====================================================================================================

		while (true) {
			System.out.println("Press 1 Admin Log in.");
			System.out.println("Press 2 User Log in.");
			System.out.println("Press 3 Create Account");
			System.out.println("Press 4 View Flight Calender");
			System.out.println("Press 5 To Exit");

			Scanner opt = new Scanner(System.in);
			int option = opt.nextInt();
			Customer cust = new Customer(" ", " ", " ", " ", " ", " ", " ");
			int sysPass = 123456;

			// --------------------------Admin Menu--------------------------------------

			if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
				throw new InvalidInput("Entered input is invalid.");
			}
			if (option == 1) {
				System.out.println("ADMIN");
				System.out.println("Enter System Password: ");
				Scanner sc = new Scanner(System.in);
				int pass = sc.nextInt();

				// ---------------------------------------------Admin Log in
				// options------------------------------

				Boolean ex = false;
				while (pass == sysPass && ex == false) {
					System.out.println("Logged In Successfully\n");
					System.out.println("Press 1 to add Admin Details.");
					System.out.println("Press 2 to view Customer Details.");
					System.out.println("Press 3 to add Flights.");
					System.out.println("Press 4 to cancel Reservation.");
					System.out.println("Press 5 to Exit.");

					Scanner sc1 = new Scanner(System.in);
					int opt1 = sc1.nextInt();
					// ---------------------------------------------Admin
					// Details------------------------------

					if (opt1 != 1 && opt1 != 2 && opt1 != 3 && opt1 != 4 && opt1 != 5) {
						throw new InvalidInput("Entered input is invalid.");
					}

					if (opt1 == 1) {
						Admin admin = new Admin(" ", " ", " ", " ", " ");
						System.out.println("Enter Assigned ID");
						Scanner adm = new Scanner(System.in);
						String ID = adm.nextLine();
						admin.setID(ID);
						System.out.println("Enter your Full name");
						String name = adm.nextLine();
						admin.setName(name);
						System.out.println("Enter your Age");
						String age = adm.nextLine();
						admin.setAge(age);
						System.out.println("Enter your Gender");
						String gender = adm.nextLine();
						admin.setGender(gender);
						System.out.println("Enter your Address");
						String address = adm.nextLine();
						admin.setAddress(address);

						try {

							File f = new File("Admin.txt");
							String absolute = f.getAbsolutePath();
							Files.write(Paths.get("src\\Admin.txt"), "\r\n".getBytes(),
									StandardOpenOption.APPEND);
							Files.write(Paths.get("src\\Admin.txt"),
									(ID + "," + name + "," + age + "," + gender + "," + address).getBytes(),
									StandardOpenOption.APPEND);
							System.out.println("Details Entered Successfully");
						} catch (IOException e) {
							System.out.println("An error occurred.");
						}
					}

					// ---------------------------------------------Customer
					// Details------------------------------
					if (opt1 == 2) {

						int counter2 = 1;
						try {
							File myObj = new File("src\\Customer.txt");
							Scanner myReader = new Scanner(myObj);
							while (myReader.hasNextLine()) {
								String data = myReader.nextLine();
								System.out.println(counter2 + "." + data);
								counter2++;
							}
							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					}

					// ---------------------------------------------Entering Flight
					// Details------------------------------
					if (opt1 == 3) {

						System.out.println("Enter Plane ID (PKRXXXX)");
						Scanner fl = new Scanner(System.in);
						String ID = fl.nextLine();
						System.out.println("Enter Origin");
						String orig = fl.nextLine();
						System.out.println("Enter Destination");
						String dest = fl.nextLine();
						System.out.println("Enter Date (dd-mm-yy)");
						String date = fl.nextLine();
						System.out.println("Enter Time (00:00 am/pm)");
						String time = fl.nextLine();
						System.out.println("Enter Economy class Fair");
						String eclass = fl.nextLine();
						System.out.println("Enter Business class Fair");
						String bclass = fl.nextLine();
						System.out.println("Enter Plane Type");
						String type = fl.nextLine();
						System.out.println("Enter Flight Type (National/International)");
						String flighttype = fl.nextLine();

						try {
							Files.write(Paths.get("src\\flights.txt"), "\r\n".getBytes(),
									StandardOpenOption.APPEND);
							Files.write(Paths.get("src\\flights.txt"),
									(ID + "." + orig + "." + dest + "." + date + "." + time + "." + eclass + "."
											+ bclass + "." + type + "." + flighttype).getBytes(),
									StandardOpenOption.APPEND);
						} catch (IOException e) {
							System.out.println("An error occurred.");
						}

						System.out.println("Flight Added Sucessfully");
					}

					// ---------------------------------------------Cancelling
					// Reservation------------------------------
					if (opt1 == 4) {

						System.out.println("Enter Plane ID (PKRXXXX)");
						Scanner res = new Scanner(System.in);
						String ID = res.nextLine();
						System.out.println("Enter Ticket Number");
						String tick = res.nextLine();
						String data;
						int counterTicket = 0;
					
						for (int i = 0; i < counter; i++) {
							fly[i] = new Flight(" ", " ", " ", " ", " ", " ", " ", " ", " ");
						}
						if (counter > fly.length) {
							throw new IndexOutofBound("Index Out of Bound");
						}
						int count = 0;
						String[] store = new String[11];
						String[] store1 = new String[50];

						int count2 = 0;
						data = " ";
						String lineToRemove = " ";
						Boolean check = false;
						try {
							File myObj = new File("src\\Ticket.txt");
							Scanner myReader = new Scanner(myObj);

							while (myReader.hasNextLine()) {
								data = myReader.nextLine();
								String[] words = data.split("\\,");

								store1[count2] = data;
								count2++;

								count = 0;

								for (String w : words) {
									store[count] = w;
									count++;
								}

								if (store[0].equals(null)) {
									throw new NullValueException("Null value Found");
								}
								if (store[0].equals(tick)) {

									lineToRemove = store[0] + "." + store[1] + "." + store[2] + "." + store[3] + "."
											+ store[4] + "." + store[5] + "." + store[6] + "." + store[7] + "."
											+ store[8] + "." + store[9];
									check = true;
								}
							}

							if (check != true) {
								throw new TicketDoesntExist("Ticket Number Doesn't Exist");
							}

							PrintWriter writer = new PrintWriter("src\\Ticket.txt");
							writer.print("");
							writer.close();

							for (int i = 0; i < count2; i++) {

								if (store1[i].equals(lineToRemove)) {

								} else {
									try {

										Files.write(Paths.get("D:\\Assignment2\\Assignment02\\src\\Ticket.txt"),
												(store1[i]).getBytes(), StandardOpenOption.APPEND);
										Files.write(Paths.get("D:\\Assignment2\\Assignment02\\src\\Ticket.txt"),
												"\r\n".getBytes(), StandardOpenOption.APPEND);
									} catch (IOException e) {
										System.out.println("An error occurred.");
									}
								}
							}

							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					}
					if (opt1 == 5) {
						ex = true;
						break;
					}

				}
				if (pass != sysPass) {
					throw new WrongPassword("Entered input is invalid.");
				}
			}

			// ---------------------------------------------Menu option 2 Customer Log
			// in------------------------------
			if (option == 2) {
				System.out.println("Enter your Name: ");
				Scanner sc = new Scanner(System.in);
				String name = sc.nextLine();
				cust.setName(name);
				System.out.println("Enter your Passport Number (XXX-XXX-XXX): ");
				Scanner sc6 = new Scanner(System.in);
				String passport = sc6.nextLine();
				cust.setPassport(passport);
				String data1;
				int count1 = 0;
				String[] store1 = new String[2];
				Boolean next = false;

				try {
					File myObj = new File("src\\logs.txt");
					Scanner myReader = new Scanner(myObj);

					while (myReader.hasNextLine()) {
						data1 = myReader.nextLine();
						String[] words = data1.split("\\,");
						count1 = 0;

						for (String w : words) {
							store1[count1] = w;
							count1++;
						}

						// ---------------------------------------------Confirming
						// Details------------------------------
						if (store1[0].equals(name) && store1[1].equals(passport)) {
							System.out.println("You have Been successfully logged in");
							next = true;
						}

					}
					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				// ---------------------------------------------Customer Log in
				// Menu------------------------------
				if (next != true) {
					throw new InvalidInput("Name or Password Invalid");
				}
				while (next == true) {
					System.out.println("\n");
					System.out.println("Press 1 To Book Your Ticket");
					System.out.println("Press 2 To view Your Ticket");
					System.out.println("Press 3 To cancel your Reservation");
					System.out.println("Press 4 to Exit");
					Scanner ch = new Scanner(System.in);
					int choice = ch.nextInt();

					// ---------------------------------------------Booking
					// Ticket------------------------------
					if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
						throw new InvalidInput("Option does not Exist");
					}
					if (choice == 1) {
						System.out.println("Enter your Full name");
						Scanner sc8 = new Scanner(System.in);
						String name1 = sc8.nextLine();
						cust.setName(name1);
						System.out.println("Enter your Age");
						Scanner sc1 = new Scanner(System.in);
						String age = sc1.nextLine();
						cust.setAge(age);
						System.out.println("Enter your Gender");
						Scanner sc2 = new Scanner(System.in);
						String gender = sc2.nextLine();
						cust.setGender(gender);
						System.out.println("Enter your Address");
						Scanner sc3 = new Scanner(System.in);
						String address = sc3.nextLine();
						cust.setAddress(address);
						System.out.println("Enter your Plane type (AirBus,Boeing,Beluga,Jet)");
						Scanner sc4 = new Scanner(System.in);
						String planetype = sc4.nextLine();
						if (!planetype.equals("AirBus") && !planetype.equals("Boeing") && !planetype.equals("Beluga")
								&& !planetype.equals("Jet")) {
							throw new InvalidInput("Fomat not Followed");
						}
						cust.setPlane(planetype);
						System.out.println("Enter your Destination");
						Scanner sc5 = new Scanner(System.in);
						String dest = sc5.nextLine();
						cust.setDest(dest);
						System.out.println("Enter your Passport Number (XXX-XXX-XXX)");
						Scanner sc7 = new Scanner(System.in);
						String passport1 = sc7.nextLine();
						cust.setPassport(passport1);

						try {
							Files.write(Paths.get("src\\Customer.txt"),
									"\r\n".getBytes(), StandardOpenOption.APPEND);
							Files.write(Paths.get("src\\Customer.txt"),
									(name + "," + age + "," + gender + "," + address + "," + planetype + "," + dest
											+ "," + passport).getBytes(),
									StandardOpenOption.APPEND);
						} catch (IOException e) {
							System.out.println("An error occurred.");
						}

						System.out.println("\nPlease wait while we Process Your Information.... \n");
						String data = " ";
						String[] store = new String[20];
						int index = 0;
						int count = 0;

						for (int i = 0; i < counter; i++) {
							fly[i] = new Flight(" ", " ", " ", " ", " ", " ", " ", " ", " ");
						}

						if (counter > fly.length) {
							throw new IndexOutofBound("Index out of Bound");
						}

						int counter1 = 0;
						try {
							File myObj = new File("src\\flights.txt");
							Scanner myReader = new Scanner(myObj);

							while (myReader.hasNextLine()) {
								data = myReader.nextLine();
								String[] words = data.split("\\.");
								count = 0;

								for (String w : words) {
									store[count] = w;
									count++;
								}

								fly[counter1].setPlane_no(store[0]);
								fly[counter1].setOrigin(store[1]);
								fly[counter1].setDest(store[2]);
								fly[counter1].setDate(store[3]);
								fly[counter1].setTime(store[4]);
								fly[counter1].setTraveleclass(store[5]);
								fly[counter1].setTravelbclass(store[6]);
								fly[counter1].setType(store[7]);
								fly[counter1].setFlighttype(store[8]);
								counter1++;

							}
							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

						System.out.println("Searching For Available flights......");

						count = 1;
						Boolean check = false;
						for (int i = 0; i < counter1; i++) {
							// System.out.println(fly[i].getDest());
							if ((fly[i].getDest()).equals(cust.getDest())
									&& (fly[i].getType()).equals(cust.getPlane())) {
								System.out.println(count + ".Plane Number: " + fly[i].getPlane_no());
								System.out.println("Origin: " + fly[i].getOrigin());
								System.out.println("Destination: " + fly[i].getDest());
								System.out.println("Date: " + fly[i].getDate());
								System.out.println("Time: " + fly[i].getTime());
								System.out.println("EconomyClass Price: " + fly[i].getTraveleclass());
								System.out.println("BusinessClass Price: " + fly[i].getTravelbclass());
								System.out.println("Plane Type: " + fly[i].getType());
								System.out.println("Flight: Direct");
								System.out.println("\n");
								count++;
								check = true;

							}
						}
						if (check == false) {
							throw new InputDoesntExist("Input Doesnt Exist");
						}

						System.out.println("Proceeding to Booking...");

						System.out.println("Please Enter Plane Number");
						Scanner no = new Scanner(System.in);
						String number = no.nextLine();
						System.out.println("Please Enter you desired Class(Economy/Business)");
						Scanner clss = new Scanner(System.in);
						String inpclass = clss.nextLine();
						if (!inpclass.equals("Economy") && !inpclass.equals("Business") && !inpclass.equals("economy")
								&& !inpclass.equals("business")) {
							throw new InvalidInput("Invalid Input");
						}
						int[] res_array = new int[80];

						for (int i = 0; i < 80; i++) {
							res_array[i] = 0;
						}
						for (int i = 0; i < counter1; i++) {
							fly[i].setReservation(res_array);
						}

						Boolean check1 = false;
						if ((inpclass.equals("Economy") || inpclass.equals("economy"))) {

							for (int j = 0; j < counter1; j++) {
								if (number.equals(fly[j].getPlane_no())) {
									check1 = true;
									for (int i = 0; i < 50; i++) {
										if (fly[j].getReservation()[i] == 0) {
											System.out.println("Available seats are: " + i);

										}
									}
								}
							}
							if (check1 == false) {
								throw new InputDoesntExist("Number Entered Doesnt Exist");
							}

							Boolean corrnum = false;
							System.out.println("\nPlease Enter the Seat Number to be Reserved.");
							Scanner seat = new Scanner(System.in);
							int res_seat = seat.nextInt();
							for (int j = 0; j < counter1; j++) {
								if (number.equals(fly[j].getPlane_no())) {
									for (int i = 0; i < 50; i++) {
										if (i == res_seat) {
											fly[j].setReservationIndex(i, 1);
											System.out.println("\nYour Seat has been Successfully Reserved");
											corrnum = true;

										}
									}
								}
							}
							if (corrnum == false) {
								throw new InputDoesntExist("Seat Doesnt Exist or Is already Reserved");
							}

							System.out.println("\nProceed To Payment...");
							for (int i = 0; i < counter1; i++) {
								if (number.equals(fly[i].getPlane_no()) && inpclass.equals("Economy")) {
									System.out.println("Plane Selected: " + fly[i].getPlane_no());
									System.out.println("Class: " + inpclass);
									System.out.println("Seat Number: " + res_seat);
									System.out.println("Total Price: " + fly[i].getTraveleclass());
									System.out.println("Please Enter your Card Pin.");
									Scanner pin = new Scanner(System.in);
									int card_pin = pin.nextInt();
									System.out.println("Payment Recieved");

									System.out.println("\nGenerating Ticket...");
									System.out.println("Please Wait...");
									int min = 100;
									int max = 999;
									int ticket_no = (int) (Math.random() * (max - min + 1) + min);
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
									LocalDateTime now = LocalDateTime.now();

									System.out.println("\n");
									System.out.println(
											"                    ---------------------------------------------------------------------------------");
									System.out.println(
											"                    |                         SEAT RESERVATION TICKET                               |");
									System.out.println("                    | Ticket_No: " + ticket_no
											+ "                                          Plane_No: "
											+ fly[i].getPlane_no() + "     |");
									System.out.println("                    | " + dtf.format(now)
											+ "                                  Passport_No: " + cust.getPassport()
											+ " |");
									System.out.println(
											"                    |                                                                               |");
									System.out.println("                    | Name: " + cust.getName()
											+ "                                                Price "
											+ fly[i].getTraveleclass() + "     |");
									System.out.println("                    | Origin: " + fly[i].getOrigin()
											+ "                                     Destination: " + fly[i].getDest()
											+ "     |");
									System.out.println("                    | Seat_No: " + res_seat
											+ "                                                Class: " + inpclass
											+ "     |");
									System.out.println(
											"                    ---------------------------------------------------------------------------------");
									System.out.println("\n");
									System.out.println("\n");
									
									try {
										Files.write(Paths.get("src\\Ticket.txt"),
												"\r\n".getBytes(), StandardOpenOption.APPEND);
										Files.write(Paths.get("src\\Ticket.txt"),
												(ticket_no + "." + fly[i].getPlane_no() + "." + dtf.format(now)
												+ "." + cust.getPassport() + "." + cust.getName() + "."
												+ fly[i].getTraveleclass() + "." + fly[i].getOrigin() + "."
												+ fly[i].getDest() + "." + res_seat + "." + inpclass).getBytes(),
												StandardOpenOption.APPEND);
									} catch (IOException e) {
										System.out.println("An error occurred.");
									}

								}
							}

						} else if (((inpclass.equals("Business") || inpclass.equals("business")))) {

							Boolean check2 = false;
							for (int j = 0; j < counter1; j++) {
								if (number.equals(fly[j].getPlane_no())) {
									check2 = true;
									for (int i = 50; i < 80; i++) {
										if (fly[j].getReservation()[i] == 0) {
											System.out.println("Available seats are: " + i);

										}
									}
								}
							}
							if (check2 == false) {
								throw new InputDoesntExist("Number Entered Doesnt Exist");
							}

							Boolean chcknum = false;
							System.out.println("\nPlease Enter the Seat Number to be Reserved.");
							Scanner seat = new Scanner(System.in);
							int res_seat = seat.nextInt();

							for (int j = 0; j < counter1; j++) {
								if (number.equals(fly[j].getPlane_no())) {
									for (int i = 50; i < 80; i++) {
										if (i == res_seat) {
											fly[j].setReservationIndex(i, 1);
											System.out.println("\nYour Seat has been Successfully Reserved");
											chcknum = true;

										}
									}
								}
							}
							if (chcknum == false) {
								throw new InputDoesntExist("Seat Doesnt Exist or Is already Reserved");
							}

							System.out.println("\nProceed To Payment...");
							for (int i = 0; i < counter1; i++) {
								if (number.equals(fly[i].getPlane_no()) && inpclass.equals("Business")) {
									System.out.println("Plane Selected: " + fly[i].getPlane_no());
									System.out.println("Class: " + inpclass);
									System.out.println("Seat Number: " + res_seat);
									System.out.println("Total Price: " + fly[i].getTravelbclass());
									System.out.println("Please Enter your Card Pin.");
									Scanner pin = new Scanner(System.in);
									int card_pin = pin.nextInt();
									System.out.println("Payment Recieved");

									System.out.println("\nGenerating Ticket...");
									System.out.println("Please Wait...");
									int min = 100;
									int max = 999;
									int ticket_no = (int) (Math.random() * (max - min + 1) + min);
									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
									LocalDateTime now = LocalDateTime.now();

									System.out.println("\n");
									System.out.println(
											"                    ---------------------------------------------------------------------------------");
									System.out.println(
											"                    |                         SEAT RESERVATION TICKET                               |");
									System.out.println("                    | Ticket_No: " + ticket_no
											+ "                                          Plane_No: "
											+ fly[i].getPlane_no() + "     |");
									System.out.println("                    | " + dtf.format(now)
											+ "                                  Passport_No: " + cust.getPassport()
											+ " |");
									System.out.println(
											"                    |                                                                               |");
									System.out.println("                    | Name: " + cust.getName()
											+ "                                                Price "
											+ fly[i].getTraveleclass() + "     |");
									System.out.println("                    | Origin: " + fly[i].getOrigin()
											+ "                                     Destination: " + fly[i].getDest()
											+ "     |");
									System.out.println("                    | Seat_No: " + res_seat
											+ "                                                Class: " + inpclass
											+ "     |");
									System.out.println(
											"                    ---------------------------------------------------------------------------------");
									System.out.println("\n");
									System.out.println("\n");
									
									try {
										Files.write(Paths.get("src\\Ticket.txt"),
												"\r\n".getBytes(), StandardOpenOption.APPEND);
										Files.write(Paths.get("src\\Ticket.txt"),
												(ticket_no + "." + fly[i].getPlane_no() + "." + dtf.format(now)
												+ "." + cust.getPassport() + "." + cust.getName() + "."
												+ fly[i].getTraveleclass() + "." + fly[i].getOrigin() + "."
												+ fly[i].getDest() + "." + res_seat + "." + inpclass).getBytes(),
												StandardOpenOption.APPEND);
									} catch (IOException e) {
										System.out.println("An error occurred.");
									}
								}
							}

						}
					}

					// ---------------------------------------------Viewing
					// Ticket------------------------------
					if (choice == 2) {
						System.out.println("Please Enter your Ticket Number: ");
						Scanner n = new Scanner(System.in);
						String num = n.nextLine();
						String[] store11 = new String[10];
						data1 = " ";
						Boolean ticknum = false;
						try {
							File myObj = new File("src\\Ticket.txt");
							Scanner myReader = new Scanner(myObj);

							while (myReader.hasNextLine()) {
								data1 = myReader.nextLine();
								String[] words = data1.split("\\.");
								count1 = 0;

								for (String w : words) {
									store11[count1] = w;
									count1++;

								}

								if (store11[0].equals(num)) {
									ticknum = true;
									System.out.println("\n");
									System.out.println(
											"                    ---------------------------------------------------------------------------------");
									System.out.println(
											"                    |                         SEAT RESERVATION TICKET                               |");
									System.out.println("                    | Ticket_No: " + store11[0]
											+ "                                          Plane_No: " + store11[1]
											+ "     |");
									System.out.println("                    | " + store11[2]
											+ "                                  Passport_No: " + store11[3] + " |");
									System.out.println(
											"                    |                                                                               |");
									System.out.println("                    | Name: " + store11[4]
											+ "                                              Price: " + store11[5]
											+ "     |");
									System.out.println("                    | Origin: " + store11[6]
											+ "                                     Destination: " + store11[7]
											+ "     |");
									System.out.println("                    | Seat_No: " + store11[8]
											+ "                                                Class: " + store11[9]
											+ "     |");
									System.out.println(
											"                    ---------------------------------------------------------------------------------");
									System.out.println("\n");
									System.out.println("\n");
								}

							}
							if (ticknum == false) {
								throw new TicketDoesntExist("Ticket Number doesnt Exist Or Reservation was Cancelled");
							}
							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}
					// ---------------------------------------------Cancelling
					// Reservation------------------------------
					if (choice == 3) {
						System.out.println("Enter Plane ID (PKRXXXX)");
						Scanner res = new Scanner(System.in);
						String ID = res.nextLine();
						System.out.println("Enter Ticket Number");
						String tick = res.nextLine();
						String data;
						

						if (counter > fly.length) {
							throw new IndexOutofBound("Index out of Bound");
						}
						int count = 0;
						String[] store = new String[11];
						String[] store11 = new String[50];
						int count2 = 0;
						data = " ";
						String lineToRemove = " ";
						Boolean ticknum = false;
						try {
							File myObj = new File("src\\Ticket.txt");
							Scanner myReader = new Scanner(myObj);

							while (myReader.hasNextLine()) {
								data = myReader.nextLine();
								String[] words = data.split("\\,");

								store11[count2] = data;
								count2++;

								count = 0;

								for (String w : words) {
									store[count] = w;
									count++;
								}
								if (store[0].equals(tick)) {
									ticknum = true;
									lineToRemove = store[0] + "," + store[1] + "," + store[2] + "," + store[3] + ","
											+ store[4] + "," + store[5] + "," + store[6] + "," + store[7] + ","
											+ store[8] + "," + store[9];
								}
							}
							if (ticknum == false) {
								throw new TicketDoesntExist("Ticket Number doesnt Exist");
							}

							PrintWriter writer = new PrintWriter("src\\Ticket.txt");
							writer.print("");
							writer.close();

							for (int i = 0; i < count2; i++) {

								if (store11[i].equals(lineToRemove)) {

								} else {
									try {

										Files.write(Paths.get("src\\Ticket.txt"),
												(store11[i]).getBytes(), StandardOpenOption.APPEND);
										Files.write(Paths.get("src\\Ticket.txt"),
												"\r\n".getBytes(), StandardOpenOption.APPEND);
									} catch (IOException e) {
										System.out.println("An error occurred.");
									}
								}
							}

							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}

					}
					if (choice == 4) {
						next = false;
						break;
					}

				}
			}
			// ---------------------------------------------Creating new User
			// Account------------------------------
			if (option == 3) {

				System.out.println("Enter your Full name");
				Scanner sc8 = new Scanner(System.in);
				String name = sc8.nextLine();
				System.out.println("Enter your Passport Number (XXX-XXX-XXX)");
				Scanner sc1 = new Scanner(System.in);
				String passport = sc1.nextLine();

				try {
					Files.write(Paths.get("src\\logs.txt"), "\r\n".getBytes(),
							StandardOpenOption.APPEND);
					Files.write(Paths.get("src\\logs.txt"),
							(name + "," + passport).getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
					System.out.println("An error occurred.");
				}

				System.out.println("ThankYou for Choosing Us! Please Log in.");
			}
			// ---------------------------------------------FLIGHT
			// CALENDER-------------------------

			if (option == 4) {
				String data = " ";
				String[] store = new String[20];

			
				if (counter > fly.length) {
					throw new IndexOutofBound("Index out of Bound");
				}
				int counter1 = 0;
				try {
					File myObj = new File("src\\flights.txt");
					Scanner myReader = new Scanner(myObj);

					System.out.println(
							"Plane_ID.Origin.Destination.Date.Time.EconomyClass Fair.BusinessClass Fair.Plane Type.Flight Type ");
					while (myReader.hasNextLine()) {
						data = myReader.nextLine();
						System.out.println(data);

						if (data == " ") {
							throw new NullValueException("Null Value");
						}
					}

					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			}
			// ---------------------------------------------Exiting
			// Code------------------------------
			if (option == 5) {
				System.out.println("Exiting From Code ");
				System.exit(0);
			}
		}
	}
}