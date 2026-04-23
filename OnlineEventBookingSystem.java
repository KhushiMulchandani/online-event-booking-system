import java.util.*;
class Events{
	Scanner sc = new Scanner(System.in);
	static String userFirstName;
    static String userLastName;
	static String bookingID;
    String phn;
    String email;
	double pricePerTkt;
    double totalPrice;
	int showTime;
	int seat;
	static int bookingCount;
	String s;
    static final int MAX_BOOKINGS = 100;
    static String[][] bookings = new String[MAX_BOOKINGS][4];
	static int idCount;
	int choice, dateChoice,noOfTickets;
	void createBookingID(){
		idCount++;
		bookingID = userFirstName.toUpperCase().charAt(0) + "" + userFirstName.toUpperCase().charAt(1)+ phn.charAt(0) + phn.charAt(1) + userLastName.toUpperCase().charAt(0) + userLastName.toUpperCase().charAt(1) + phn.charAt(7) + phn.charAt(8) + idCount;
	}
	

	void viewBooking(){
		System.out.println();
        if (bookingCount == 0) {
            System.out.println("No bookings found.");
        }
		
		else {
            System.out.println("Booking Details:");
			
            for (int i = 0; i < bookingCount; i++) {
				if(bookings[i][0].equals("")){}
				else{
				    System.out.println("BookingID: " + bookings[i][0]  + " | show : " + bookings[i][2]+" | No. of Tickets: "+bookings[i][3] );
				}
			}
        }
	}
	void bookEvent(){
		System.out.println("Oops!...no event selected.");
		System.out.println("Booking Details:");
		System.out.println("NA");
	}
	
	void displayBookingDetails(){
		System.out.println();
        System.out.println("BOOKING CONFIRMED");
        System.out.println();
        System.out.println("-----BOOKING DETAILS-----");
		System.out.println("Your Name : " + userFirstName+" "+userLastName);
	    System.out.println("Booking ID: "+bookingID);
        System.out.println("Price per Ticket: Rs." + pricePerTkt+"/-");
        System.out.println("Total Ticket Price(including GST): Rs." + totalPrice+"/-");
	}
	
	void seatSelection(int rows,int row,int cols,int col,boolean[][] seats,boolean flag1,boolean flag2){
		displaySeats(seats, rows, cols);
		boolean flag=true;
		for(int i=1;i<=noOfTickets;i++){
			do{
				System.out.println("Enter seat no. for ticket "+i);
				do{
					System.out.print("Enter row: ");
					row=sc.nextInt();
					flag1=(row>=1 && row<=rows)?false:true;
					if(flag1){
						System.out.println("Invalid");
					}
				}while(flag1);
				do{
					System.out.print("Enter col: ");
					col=sc.nextInt();
					flag2=(col>=1 && col<=cols)?false:true;
					if(flag2){
						System.out.println("Invalid");
					}
				}while(flag2);
				if(seats[row-1][col-1]==false){
					System.out.println("Seat not available");
					flag=true;
				}
				else{
					seats[row-1][col-1]=false;
					flag=false;
				}
			}while(flag);
		}
		displaySeats(seats, rows, cols);
	}
	void displaySeats(boolean[][] seats, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j]) {
                    System.out.print("\u001B[32m[O]\u001B[0m ");
                } else {
                    System.out.print("\u001B[31m[X]\u001B[0m ");
                }
            }
            System.out.println();
        }
    }
	
	void cancelbooking() {
    if (bookingCount == 0) {
        System.out.println("No bookings found.");
        return;
    }
    boolean found = false;
    int Attempts = 0; 
    do {
        System.out.print("Enter Booking ID for Canceling Ticket (or type 'exit' to cancel): ");
        String cs = sc.nextLine().toUpperCase().trim(); 

        if (cs.equalsIgnoreCase("exit")) {
            System.out.println("Cancellation process terminated by user.");
            return;
        }

        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i][0].equals(cs)) { 
                found = true;
                
                for (int j = i; j < bookingCount - 1; j++) {
                    bookings[j] = bookings[j + 1];
                }
            
                bookings[bookingCount - 1] = new String[4];
                bookingCount--;
                System.out.println("\nBooking Canceled Successfully!");
                break; 
            }
        }

        if (!found) {
            Attempts++;
            if (Attempts<3) {
                System.out.println("Booking ID not found. Please try again.");
            } else {
                System.out.println("Maximum attempts reached. Cancellation process terminated.");
                return; 
            }
        }
    } while (!found && (Attempts<3));
}

	
	
	 boolean check() {
        boolean flag = true;
        sc.nextLine();
		while (flag) {
            System.out.print("Enter 16-digit Credit/Debit Card Number: ");
            boolean validCard = true;
            while (validCard) {
                String no = sc.nextLine();
                if (no.length() == 16){
                    for (int i = 0; i < no.length(); i++){
                        if(no.charAt(i) >= '0' && no.charAt(i) <= '9'){
                            validCard = false;
                        } else {
                            System.out.print("Invalid Card Number! Enter a 16-digit numeric value. : ");
                            validCard = true;
                            break;
                        }
                    }
                } else {
                    System.out.print("Invalid Card Number! Enter a 16-digit numeric value. : ");
                }
            }
            
            System.out.print("Enter CVV: ");
            validCard = true;
            while (validCard) {
                String cvv = sc.nextLine();
                if (cvv.length() == 3){
                    for (int i = 0; i < cvv.length(); i++){
                        if(cvv.charAt(i) >= '0' && cvv.charAt(i) <= '9'){
                            validCard = false;
                            flag = false;
                        } else {
                            System.out.print("Invalid CVV Number! Enter a 3-digit numeric value. : ");
                            validCard = true;
                            break;
                        }
                    }
                } else {
                    System.out.print("Invalid CVV Number! Enter a 3-digit numeric value. :");
                }
            }
        }
        return true;
    }
	
	void payment(){
		boolean flag = true;
		int choice =0;
		
		do{
			System.out.println("Payment option \n1. Cash \n2. Credit/Debit \n3. Upi");
			System.out.print("Enter Choice (1-3) : ");
			choice = sc.nextInt();
			if(choice>=1 && choice<=3){
				break;
			}
			else{
				System.out.print("Enter Valid Choice ");
			}
		}while(flag);
		
		while(flag){
			
			switch(choice){
			case 1 :
			System.out.println("Total Amount to be paid : "+(int)totalPrice);
			System.out.print("Enter Amount : ");
			double cashpay =  sc.nextDouble();
			if(cashpay == (int)totalPrice){
				System.out.print("Payment done Successfully ");
				flag = false;
			}
			else{
				System.out.println("Incorrect Amount! Please enter the exact amount.");
			}
			break;
			case 2 : 
			if(check()){
				System.out.println("Payment Done Successfully via Credit/Debit Card!");
				flag = false;
			}
			break;
			case 3 :
			    sc.nextLine();
			    while (flag) {
                    System.out.print("Enter UPI ID (example@bankupi): ");
                    String upiId = sc.nextLine();

                    if (upiId.endsWith("@bankupi")) {
                        System.out.println("Payment Done Successfully via UPI!");
                        flag = false;
                    } else {
                        System.out.println("Invalid UPI ID! Please enter a valid format (e.g., user@bankupi).");
                    }
                }
			break;
		}
		System.out.println();
		}
	}
}
class Sports extends Events{
	double basePrice;
	static double cricketBasePrice = 3000;
    static double footballBasePrice = 2500;
    static double kabaddiBasePrice = 2000;
	static String[] sport=new String[]{"Cricket","Kabaddi","Football"};
    String[] sportSeat=new String[]{"VIP","Upper","Lower"};
	static String sportVenue = "abc stadium";
	static String sportTiming = "Timing of match is 4:00 PM / 16:00";
	
	static int rows = 10;
	int row=-1;
	static int cols = 10;
	int col=-1;
	boolean flag1=true;
	boolean flag2=true;
	static boolean[][] seats = new boolean[rows][cols];
	static{
		for(int i=0;i<seats.length;i++){
			for(int j=0;j<seats[i].length;j++){
				seats[i][j]=true;
			}
		}
	}
	
	Sports() {
        boolean flag = true;
        
        do {
            int i = 1;
            for (String x : sport) {
                System.out.println(i++ + ". " + x);
            }
            System.out.println("Select sport (1-3): ");
            choice = sc.nextInt();
            if (choice >= 1 && choice <= 3) {
                flag = false;
            } else {
                System.out.println(" === Invalid Selection === ");
                System.out.println(" === Enter valid Selection === ");
            }
        } while (flag);
        do {
            System.out.print("Enter no. of tickets: ");
            noOfTickets = sc.nextInt();
            if (noOfTickets <= 0) {
                System.out.println("---Invalid no. of tickets---");
            }
        } while (noOfTickets <= 0);
		
		
		do {
            flag = true;
            System.out.println("Select Seat");
            int i = 1;
            for (String x : sportSeat) {
                System.out.println(i++ + ". " + x);
            }
            System.out.println("Select seat type (1-3): ");
            seat = sc.nextInt();
            if (seat >= 1 && seat <= 3) {
                flag = false;
            } else {
                System.out.println(" === Invalid Selection === ");
                System.out.println(" === Enter valid Selection === ");
            }
        } while (flag);
		
		switch (choice) {
            case 1: {
				basePrice=cricketBasePrice;
                switch (seat) {
                    case 1:
						pricePerTkt=basePrice+(basePrice*0.25);
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                    case 2:
						pricePerTkt=basePrice+(basePrice*0.10);
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                    case 3:
      					pricePerTkt=basePrice;
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                }
                break;
            }
            case 2: {
				basePrice=kabaddiBasePrice;
                switch (seat) {
                    case 1:
						pricePerTkt=basePrice+(basePrice*0.25);
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                    case 2:
						pricePerTkt=basePrice+(basePrice*0.10);
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                    case 3:
      					pricePerTkt=basePrice;
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                }
                break;
            }
            case 3: {
				basePrice=footballBasePrice;
                switch (seat) {
                    case 1:
						pricePerTkt=basePrice+(basePrice*0.25);
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                    case 2:
						pricePerTkt=basePrice+(basePrice*0.10);
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                    case 3:
      					pricePerTkt=basePrice;
						totalPrice=pricePerTkt*noOfTickets;
                        break;
                }
                break;
            }
		}
        totalPrice += totalPrice * 0.18;
		seatSelection(rows,row,cols,col,seats,flag1,flag2);
		bookings[bookingCount][0] = bookingID;
        bookings[bookingCount][1] = sport[choice-1];
		bookings[bookingCount][2] = sportVenue;
		bookings[bookingCount][3] = Integer.toString(noOfTickets);
		payment();
    }
	void display(){
			System.out.println("Your Show: " + sport[choice - 1]);
			System.out.println("Your ShowSeat: " + sportSeat[seat - 1]);
			System.out.println("Venue Address: " + sportVenue);
			System.out.println(sportTiming);
			bookingCount++;
		}
}
class Concerts extends Events{
	String[] concerts=new String[]{"Arjit Singh", "Yo Yo Honey Singh", "Diljit Dosanjh", "Ed Sheeran", "Coldplay"};
    String[] concertSeat=new String[]{"Lower Stand", "Upper Stand", "South Premium", "Presidential Gallery"};
	static String concertVenue = "Narendra Modi Stadium";
	static String concertTiming = "Timing of concert is 7:00 PM / 19:00";
	static int rows = 5;
	int row=-1;
	static int cols = 10;
	int col=-1;
	boolean flag1=true;
	boolean flag2=true;
	static boolean[][] seats = new boolean[rows][cols];
	static{
		for(int i=0;i<seats.length;i++){
			for(int j=0;j<seats[i].length;j++){
				seats[i][j]=true;
			}
		}
	}
	Concerts() {
        boolean flag;
        do {
            flag = true;
            int i = 1;
            for (String x : concerts) {
                System.out.println(i++ + ". " + x);
            }
            System.out.println("Select show (1-5): ");
            choice = sc.nextInt();
            if (choice >= 1 && choice <= 5) {
                flag = false;
            } else {
                System.out.println(" === Invalid Selection === ");
                System.out.println(" === Enter valid Selection === ");
            }
        } while (flag);
        do {
            flag = true;
            System.out.println("Select Seat");
            int i = 1;
            for (String x : concertSeat) {
                System.out.println(i++ + ". " + x);
            }
            System.out.println("Select seat type (1-4): ");
            seat = sc.nextInt();
            if (seat >= 1 && seat <= 4) {
                flag = false;
            } else {
                System.out.println(" === Invalid Selection === ");
                System.out.println(" === Enter valid Selection === ");
            }
        } while (flag);
		int [][] basePrice = {{899,1599,4999,9999},{999,1999,6999,11999},{599,1499,3999,8999},{999,1699,8999,12999},{1099,2199,9999,15999}};
		for (int i = 0;i<basePrice.length;i++){
			for(int j = 0;j<basePrice[i].length;j++){
				if((i == (choice-1)) && (j == (seat-1))){
					pricePerTkt = basePrice[choice-1][seat-1];
				}
			}
		}
		
        System.out.println("Enter the no. of Tickets");
		noOfTickets = sc.nextInt();
		totalPrice=(noOfTickets*pricePerTkt);
		totalPrice+=0.18*totalPrice;
		seatSelection(rows,row,cols,col,seats,flag1,flag2);
		payment();
		bookings[bookingCount][0] = bookingID;
		bookings[bookingCount][3] = Integer.toString(noOfTickets);
		bookings[bookingCount][2] = concerts[choice-1];
		bookings[bookingCount][1] = concertVenue;
		bookingCount++;
		
    }
	/*void seatSelection(){
		displaySeats(seats, rows, cols);
		boolean flag=true;
		for(int i=1;i<=noOfTickets;i++){
			do{
				System.out.println("Enter seat no. for ticket "+i);
				do{
					System.out.print("Enter row: ");
					row=sc.nextInt();
					flag1=(row>=1 && row<=rows)?false:true;
					if(flag1){
						System.out.println("Invalid");
					}
				}while(flag1);
				do{
					System.out.print("Enter col: ");
					col=sc.nextInt();
					flag2=(col>=1 && col<=cols)?false:true;
					if(flag2){
						System.out.println("Invalid");
					}
				}while(flag2);
				if(seats[row-1][col-1]==false){
					System.out.println("Seat not available");
					flag=true;
				}
				else{
					seats[row-1][col-1]=false;
					flag=false;
				}
			}while(flag);
		}
		//displaySeats(seats, rows, cols);
	}
	void displaySeats(boolean[][] seats, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j]) {
                    System.out.print("\u001B[32m[O]\u001B[0m ");
                } else {
                    System.out.print("\u001B[31m[X]\u001B[0m ");
                }
            }
            System.out.println();
        }
    }*/
	void display(){
		
		System.out.println("Your Show: " + concerts[choice-1]);
		System.out.println("Your ShowSeat: " + concertSeat[seat - 1]);
		System.out.println("Venue Address: " + concertVenue);
		System.out.println(concertTiming);
	}
}
class standup extends Events{
	int availableTckt=100;
	static int seatNo=40;
	int rseatNo=0;
	//int comedianChoice;
	static String PROMOcode="COMEDY@25";
	String[] seatType = {"VIP","Gold","Silver","Normal"};
	String[] timeSlots={"07:00pm to 09:00pm","09:30pm to 11:30pm"};
	String[] comedian={"KANAN GILL","MANAN DESAI","SAMAY RAINA","NITIN MIRANI"};
	String[] date={"14 Feb","16 Feb","20 Feb"};
	
	static int rows = 6;
	int row=-1;
	static int cols = 7;
	int col=-1;
	boolean flag1=true;
	boolean flag2=true;
	static boolean[][] seats = new boolean[rows][cols];
	static{
		for(int i=0;i<seats.length;i++){
			for(int j=0;j<seats[i].length;j++){
				seats[i][j]=true;
			}
		}
	}
	
	void mainMenu(){
		boolean flag=true;
		while(flag){
		System.out.println("=====STANDUP COMEDY=====");
		System.out.println("Enter 1  for ARTIST DETAILS");
		System.out.println("Enter 2 for EXIT");
		System.out.println("OFFERS If u will buy 10 tickets there will be 5% discount,If the user enters a valid promo code they get a 15% discount on their total ticket price");
		System.out.print("ENTER CHOICE :"); 
		int y=sc.nextInt();
		switch(y){
			case 1:
			chooseArtist();
			payment();
			display();
			break;
			case 2:
			System.out.println("THANK YOU! FOR USING ONLINE TICKET BOOKING SYSTEM");
			flag=false;
			break;	
			}
		}
	}
	void display(){
		System.out.println("BOOKING CONFIRMED");
		System.out.println();
		System.out.println("-----BOOKING Details-----");
		System.out.println("Booking ID : "+ bookingID);
		System.out.println("Comedian : "+comedian[choice-1]);
		System.out.println("Price : "+totalPrice*numTicket);
		System.out.println("Timing : "+timeSlots[showTime-1]);
		System.out.println("Seat Type : "+seatType[rseatNo-1]);
		System.out.println("Date : "+date[dateChoice-1]);
		System.out.println();
		bookings[bookingCount][0] = bookingID;
	    bookings[bookingCount][3] = Integer.toString(numTicket);
	    bookings[bookingCount][2] = comedian[choice-1];
	    bookingCount++;
	}
	void chooseArtist(){
		System.out.println("CHOOSE ANY DESIRED STANDUP COMEDIAN YOU WANT");
		System.out.println("1.KANAN GILL");
		System.out.println("2.MANAN DESAI");
		System.out.println("3.SAMAY RAINA");
		System.out.println("4.NITIN MIRANI"); 
		System.out.print("ENTER CHOICE :"); 
		
		choice=sc.nextInt();
		ticketAmt1();
	}
	int numTicket;
	void ticketAmt1(){
		seatDetail();
		System.out.print("Enter total number of ticket you want : ");
		numTicket=sc.nextInt();
		
		if (numTicket<=availableTckt){
			availableTckt-=numTicket;
			applyDiscount(numTicket);
			
		}	
		else{
			System.out.println("OOPS! Sorry no available tickets");
			
		}
		timing();
		date();
	}
	
	void applyDiscount(int numTicket){
		totalPrice = 1;
        switch (rseatNo){
			case 1:
				totalPrice=totalPrice*1499;
				break;
				
			case 2:
				totalPrice=totalPrice*999;
				break;
			case 3:
				totalPrice=totalPrice*699;
				break;
			case 4:
				totalPrice=totalPrice*499;
				break;
		}
		if (numTicket>= 10) {
            totalPrice *= 0.95; // 5% discount for 10 or more tickets
            System.out.println("You get a 5% discount!");
        }
		sc.nextLine();
        // Promo code offer (apply an additional discount if valid code is entered)
        System.out.print("Enter Promo Code for additional discount (or type 'none' to skip):");
        String promoCode = sc.nextLine();
        if(promoCode.equalsIgnoreCase("COMEDY@25")){
            totalPrice *= 0.80;  // 20% discount for valid promo code
            System.out.print("Promo Code 'COMEDY@25' applied! You get an additional 20% discount.");
        }
	}
	void seatDetail(){
		System.out.println();
		System.out.println("SEAT DETAIL OF YOUR SHOW IS GIVEN BELOW");
		System.out.println("1.VIP    1499/-");
		System.out.println("2.Gold   999/- ");
		System.out.println("3.Silver 699/-");
		System.out.println("4.Normal 499/-");
		System.out.print("Enter Choice : ");
		rseatNo=sc.nextInt();
		seatSelection(rows,row,cols,col,seats,flag1,flag2);
	}
	void timing(){
		System.out.println("TIME SLOTS ARE GIVEN BELOW");
		System.out.println("1. 07:00pm to 09:00pm");
		System.out.println("2. 09:30pm to 11:30pm");
		System.out.print("Enter Choice : ");
		showTime=sc.nextInt();
	}
	void date(){
		System.out.println("Select Date");
		System.out.println("1. 14 Feb");
		System.out.println("2. 16 Feb");
		System.out.println("3. 20 Feb");
		System.out.print("Enter Choice : ");
		dateChoice=sc.nextInt();
		System.out.println();
	}
	
	//bookings[bookingCount][3] = concertvenue;
}
class workshop extends Events {
	int timeChoice,choiceFinal;
    String refreshmentChoice, materialChoice;
    String[][] workshopsNames = {{"Web Development", "App Development", "Cyber Security", "Game Development"}, {"Photography", "Pottery & Ceramic", "Painting & Drawing", "Calligraphy"},
            {"Cooking", "Gardening"}, {"Yoga & Zumba", "Art Of Living"}, {"Pitch Deck", "Startup Bootcamp", "Entrepreneurship Summit", "Sales & Marketing"}};
    String[][][] timeSlots = {
            {{"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}},
            {{"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}},
            {{"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}},
            {{"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}},
            {{"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}, {"10 AM", "3 PM", "6 PM", "8 PM"}}};
    int[][] basePrice = {{500, 500, 400, 800}, {400, 250, 300, 500}, {800, 400}, {800, 1200, 300, 1000}};
    String[] dates = {"28 Jan", "29 Jan", "1 Feb", "2 Feb"};
    
	static int rows = 10;
	int row=-1;
	static int cols = 5;
	int col=-1;
	boolean flag1=true;
	boolean flag2=true;
	static boolean[][] seats = new boolean[rows][cols];
	static{
		for(int i=0;i<seats.length;i++){
			for(int j=0;j<seats[i].length;j++){
				seats[i][j]=true;
			}
		}
	}
	
    // Getting User Preferences
    void preference() {
        System.out.println("");
        System.out.println("==========WORKSHOPS==========");
        System.out.println("1.Coding");
        System.out.println("2.Creative Arts");
        System.out.println("3.Hobbies & Lifestyle");
        System.out.println("4.Health & Wellness");
        System.out.println("5.Entreprenurship");
        System.out.print("Enter Choice : ");
        choice = sc.nextInt() - 1;
        System.out.println("");
        
        if (choice < 0 || choice > 4) {
            System.out.println("Invalid Workshop Category! Please try again.");
            return;
        }

        // Display workshops in the selected category
        for (int i = 0; i < workshopsNames[choice].length; i++) {
            System.out.println((i + 1) + "." + workshopsNames[choice][i]);
        }
        System.out.print("Enter Choice : ");
        choiceFinal = sc.nextInt() - 1;

        if (choiceFinal < 0 || choiceFinal >= workshopsNames[choice].length) {
            System.out.println("Invalid Workshop! Please try again.");
            return;
        }
        System.out.println("");

        // Select Date
        System.out.println("Available Dates:");
        for (int i = 0; i < dates.length; i++) {
            System.out.println((i + 1) + "." + dates[i]);
        }
        System.out.print("Select Date : ");
        dateChoice = sc.nextInt() - 1;
        if (dateChoice < 0 || dateChoice >= dates.length) {
            System.out.println("Invalid Date! Please try again.");
            return;
        }
        System.out.println("");

        // Select Time Slot
        System.out.println("Available Time Slots:");
        for (int i = 0; i < timeSlots[choice][choiceFinal].length; i++) {
            System.out.println((i + 1) + "." + timeSlots[choice][choiceFinal][i]);
        }
        System.out.print("Select Time : ");
        timeChoice = sc.nextInt() - 1;
        if (timeChoice < 0 || timeChoice >= timeSlots[choice][choiceFinal].length) {
            System.out.println("Invalid Time Slot! Please try again.");
            return;
        }
        sc.nextLine(); 
        // Refreshment choice
        do {
            System.out.println("Do You Want Refreshments(y/n) [Rs.200]");
            refreshmentChoice = sc.nextLine().toLowerCase();
        } while (refreshmentChoice.charAt(0) != 'y' && refreshmentChoice.charAt(0) != 'n');
        System.out.println("");

        // Material choice
        do {
            System.out.println("Will You Bring Your Own Materials(y/n) [Rs.400]");
            materialChoice = sc.nextLine().toLowerCase();
        } while (materialChoice.charAt(0) != 'y' && materialChoice.charAt(0) != 'n');

        if (materialChoice.charAt(0) == 'n') {
            System.out.println("");
            System.out.println("Please Bring All The Required Materials");
        }

        // Select Number of Tickets
        do {
            System.out.println("");
            System.out.println("Enter Number of Tickets(Max 10) : ");
            noOfTickets = sc.nextInt();
        } while (noOfTickets <= 0 || noOfTickets > 10);
		seatSelection(rows,row,cols,col,seats,flag1,flag2);

        priceCalculation();
    }
	
    // Calculating Final Price
    void priceCalculation() {
        // Getting Base Price
        totalPrice = basePrice[choice][choiceFinal];
        // Price for Total Tickets
        totalPrice *= noOfTickets;
        if (refreshmentChoice.charAt(0) == 'y') {
            totalPrice += 200;
        }
        if (materialChoice.charAt(0) == 'y') {
            totalPrice += 400;
        }
        // 18% GST
        totalPrice = totalPrice * 1.18;
    }

	// Display Booking Details
    void display() {
		payment();
        System.out.println("");
        System.out.println("BOOKING CONFIRMED");
        System.out.println("");
        System.out.println("-----BOOKING DETAILS-----");
        System.out.println("Booking ID : " + bookingID);
        System.out.println("Event Name : " + workshopsNames[choice][choiceFinal]);
        System.out.println("Name : " + userFirstName+" "+userLastName);
        System.out.println("Date : " + dates[dateChoice]);
        System.out.println("Cost : " + totalPrice);
		bookings[bookingCount][0] = bookingID;
	    bookings[bookingCount][3] = Integer.toString(noOfTickets);
	    bookings[bookingCount][2] = workshopsNames[choice][choiceFinal];
	    bookingCount++;
    }
	
	//bookings[bookingCount][3] = concertvenue;
}
class movie extends Events {
	int movieChoice;
    int genreChoice;
    boolean check = true;
    boolean flag = true;
    String[][] film = {{"Animal", "KGF 1", "KGF 2", "Batla House", "Singham Again"},{"Hera Pheri", "Phir Hera Pheri", "Housefull", "Dhammal", "Golmall Again"},{"Dhrisyam", "Dhrisyam 2", "Badla", "Rahasya", "Ugly"},{"Interstellar", "Avatar", "Transformer", "Doctor Strange", "Avengers Endgame"}};
	
	static int rows = 10;
	int row=-1;
	static int cols = 10;
	int col=-1;
	boolean flag1=true;
	boolean flag2=true;
	static boolean[][] seats = new boolean[rows][cols];
	static{
		for(int i=0;i<seats.length;i++){
			for(int j=0;j<seats[i].length;j++){
				seats[i][j]=true;
			}
		}
	}
	
    void genreSelect() {
        do {
            System.out.println("Select the genre of movie");
            System.out.println("1. Action \n2. Comedy \n3. Thriller \n4. SciFi");
            System.out.println("Enter your Choice from 1 to 4");
            genreChoice = sc.nextInt()-1;
            if(genreChoice >= 0 && genreChoice < 5) {
                flag = false;
            }
        } while(flag);
        
        genreChoice();
        showTime();
        noOfTickets();
        seat();  
        fareCalculator();
		
        display();
    }
	void genreChoice(){
		for(int i = 0;i<film[genreChoice].length;i++){
			System.out.println((i+1)+". "+film[genreChoice][i]);
		}
		System.out.println("Enter your Choice from 1 to 5");
		movieChoice = sc.nextInt() - 1;
	}
   
    
    void showTime() {
        flag = true;
        do {
            System.out.println("Please Select the Show time");
            System.out.println("1. Evening show(17:00)");
            System.out.println("2. Night show(21:00)");
            System.out.println("Please select 1 or 2");
            showTime = sc.nextInt();
            if(showTime == 1 || showTime == 2) {
                flag = false;
            } else {
                System.out.println("Please enter valid input");
            }
        } while(flag);
    }
    
    void seat() {
        flag = true;
        do {
            if(showTime == 1) {
                System.out.println("The Price for evening show are as follows");
                System.out.println("1. Gold: 200");
                System.out.println("2. Silver: 150");
                System.out.println("3. Bronze: 100");
            } else if(showTime == 2) {
                System.out.println("The Price for night show are as follows");
                System.out.println("1. Gold: 250");
                System.out.println("2. Silver: 200");
                System.out.println("3. Bronze: 150");
            }
            System.out.println("Enter Choice from 1, 2 or 3");
            seat = sc.nextInt();
            if(seat >= 1 && seat <= 3) {
                flag = false;
            } else {
                System.out.println("Please enter a valid input");
            }
        } while(flag);
    }
    
    void noOfTickets() {
        System.out.println("Enter the number of tickets you want");
        noOfTickets = sc.nextInt();
		seatSelection(rows,row,cols,col,seats,flag1,flag2);
    }
    
    void fareCalculator() {
        if(showTime==1&&seat==1)
        { 
            totalPrice=(200*noOfTickets);
         } 
        else if(showTime==1&&seat==2)
        { 
            totalPrice=(150*noOfTickets);
         } 
        else if(showTime==1&&seat==3)
        { 
            totalPrice=(100*noOfTickets);
         } 
        else if(showTime==2&&seat==1)
        { 
            totalPrice=(250*noOfTickets); 
        } 
        else if(showTime==2&&seat==2)
        { 
            totalPrice=(200*noOfTickets); 
        } 
        else if(showTime==2&&seat==3)
        { 
            totalPrice=(150*noOfTickets);
        }
	}
    
    void display() {
		payment();
		System.out.println("");
        System.out.println("BOOKING CONFIRMED");
        System.out.println("");
        System.out.println("-----BOOKING DETAILS-----");
        System.out.println("Name : " + userFirstName+" "+userLastName);
		System.out.println("Booking ID: " + bookingID);
        System.out.println("Name of Movie "+film[genreChoice][movieChoice]);
        System.out.println("Ticket Fare: " + totalPrice);
        if(showTime == 1) {
            System.out.println("Time Of Movie: 17:00");
        } else {
            System.out.println("Time of Movie: 21:00");
        }
		bookings[bookingCount][0] = bookingID;
		bookings[bookingCount][3] = Integer.toString(noOfTickets);
	    bookings[bookingCount][2] = film[genreChoice][movieChoice];
	    bookingCount++;
	}
}
class Run extends Events{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Run obj=new Run();
		while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Customer Portal");
            System.out.println("2. Admin Login (For Future Features)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    obj.customerPortal();
                    break;
                case 2:
					//obj.adminPortal();
                    System.out.println("Admin features will be available soon.");
                    break;
                case 3:
                    System.out.println("Thank you for using the Complete Ticket Booking System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
					
            }
        }
	}
	void customerPortal() {
        System.out.print("Enter First name : ");
        userFirstName = sc.nextLine();
		System.out.print("Enter Last name : ");
		userLastName = sc.nextLine();
		//phn  = "1234567890";
		boolean c = true;
        while (c) {
            System.out.print("Enter valid contact no. : ");
            phn = sc.nextLine();
            if (phn.length() == 10) {
                for (int i = 0; i < phn.length(); i++) {
                    if ((int) phn.charAt(i) >= '0' && (int) phn.charAt(i) <= '9') {
                        c = false;
                    } else {
                        c = true;
                        break;
                    }
                }
            }
        } 
        boolean c1 = true;
		System.out.print("Enter valid Email id : ");
        while (c1) {
            email = sc.nextLine();
            if (email.endsWith("@gmail.com")) {
                c1 = false;
                System.out.println("Welcome, " + userFirstName+" "+userLastName + "! Your account has been verified.");
            }
			else{
				System.out.println("Enter Valid E-mail id (Ex.example@gmail.com)");
			}
        }
		customerMenu();
	}
	void customerMenu() {
        while (true) {
			createBookingID();
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Book Concert");
            System.out.println("2. Book Sports Event");
            System.out.println("3. Workshop");
            System.out.println("4. Movie");
            System.out.println("5. Standup Comedy");
            System.out.println("6. View Booking");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
			System.out.println();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    Concerts c = new Concerts();
                    //c.bookEvent();
                    c.displayBookingDetails();
                    c.display();
                    break;
                case 2:
                    Sports s = new Sports();
                    //s.bookEvent();
                    s.displayBookingDetails();
                    s.display();
                    break;
                case 3:
					workshop w = new workshop();
					w.preference();
					w.display();
                    break;
                case 4 :
				    movie m = new movie();
				    m.genreSelect();
					//m.displayBookingDetails
					break;
				case 5:
				    standup st = new standup();
					st.mainMenu();
					//st.displayBookingDetails();
					break;
				case 6 :
				    viewBooking();
					break;
				case 7 :
				    cancelbooking();
					break;
				case 8:
                    System.out.println("Thank you!");
                    return;    
				default:
                    Events obj = new Events();
                    obj.bookEvent();
					break;
    
       }
        }
    }
}