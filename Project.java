package cse111;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Project {

	public static Connection connection;
	public static void main(String[] args)
	{
		System.out.println("Hello would you like to open the NBA database? (y or n)");
		Scanner sc = new Scanner(System.in); 
		char c = sc.next().charAt(0); 
		if(c=='y'||c=='Y') {
			open();
			System.out.println("What would you like to do?\r\n"
					+ "click 1 to be a fan\r\n"
					+ "click 2 to be a coach\r\n"
					+ "click 3 to be a gm\r\n"
					+ "click 4 to close the database");
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			switch (x){
			case 1: fan();
			close();
			break;
			case 2: coach();
			close();
			break;
			case 3: gm();
			close();
			break;
			case 4: close();
			break;
			}


		}
		else {
			System.out.println("BYE");
		}
	}
	public static void open() {
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\zekek\\eclipse-workspace\\cse111\\src\\cse111\\nbap.db");
			System.out.println("Connected successfully");
			//createWarehouse();

			//Number3();
			//query6();

		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void q1(String team) {
		try {

			Statement statement = connection.createStatement();

			ResultSet r=statement.executeQuery("select p_name\r\n" + 
					"from player,team\r\n" + 
					"where p_teamkey=t_teamkey\r\n" + 
					"and t_name='"+team+"'\r\n");
			while(r.next()){
				System.out.println(r.getString("p_name"));
			}
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void q2(String team) {
		try {

			Statement statement = connection.createStatement();

			ResultSet r=statement.executeQuery("select st_ShotPercentage,st_blocks,st_steals,st_ppg,st_offense,st_defense,st_ovr\r\n" + 
					"from Stats, Team\r\n" + 
					"where t_statkey=st_statkey\r\n" + 
					"and t_name='"+team+"'");
			while(r.next()){
				System.out.println("Shot Percentage "+r.getString("st_ShotPercentage"));
				System.out.println("Blocks"+r.getString("st_blocks"));
				System.out.println("Steals"+r.getString("st_steals"));
				System.out.println("PPG" +r.getString("st_ppg"));
				System.out.println("Offense"+r.getString("st_offense"));
				System.out.println("Defense"+r.getString("st_defense"));
				System.out.println("OVR"+r.getString("st_ovr"));

			}
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void q3(String team) {
		try {

			Statement statement = connection.createStatement();

			ResultSet r=statement.executeQuery("select p_name,st_ShotPercentage,st_blocks,st_steals,st_ppg,st_offense,st_defense,st_ovr\r\n" + 
					"from Stats, Team,Player\r\n" + 
					"where st_statkey=p_statkey and\r\n" + 
					"p_teamkey=t_teamkey and\r\n" + 
					"t_name='"+team+"'\r\n");
			while(r.next()){
				System.out.println(r.getString("p_name"));
				System.out.print("Shot Percentage "+r.getString("st_ShotPercentage"));
				System.out.print("|Blocks "+r.getString("st_blocks"));
				System.out.print("|Steals "+r.getString("st_steals"));
				System.out.print("|PPG " +r.getString("st_ppg"));
				System.out.print("|Offense "+r.getString("st_offense"));
				System.out.print("|Defense "+r.getString("st_defense"));
				System.out.println("|OVR "+r.getString("st_ovr"));

			}
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void q4(String team) {
		try {

			Statement statement = connection.createStatement();

			ResultSet r=statement.executeQuery("select s_salary,s_salaryType\r\n" + 
					"from salary, team\r\n" + 
					"where s_salarykey=t_salarycap and\r\n"
					+ "t_name='"+team+"'\r\n");
			while(r.next()){
				System.out.println("Team Salary $"+r.getString("s_salary")+" Salary Type: "+r.getString("s_salaryType"));
			}

		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void q5(String team) {
		try {

			Statement statement = connection.createStatement();

			ResultSet r=statement.executeQuery("select p_name,s_salary,s_salaryType\r\n" + 
					"from salary, player,team\r\n" + 
					"where s_salarykey=p_salary\r\n"
					+ "and p_teamkey=t_teamkey\r\n"
					+ "and t_name='"+team+"'");
			while(r.next()){
				System.out.println( "Player: "+r.getString("p_name")+" Salary $"+r.getString("s_salary"));
			}

		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void fan() {
		try
		{
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\zekek\\eclipse-workspace\\cse111\\src\\cse111\\nbap.db");
			System.out.println("Connected successfully");
			System.out.println("Which team are you a fan of? ('no team' is not a valid otion)");
			Statement statement = connection.createStatement();
			Scanner sc = new Scanner(System.in); 
			ResultSet rs=statement.executeQuery("select t_name\r\n" + 
					"from team");
			while(rs.next()) {
				System.out.println(rs.getString("t_name"));
			}
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);

			String team= input.nextLine();
			System.out.println("What would you like to do?\r\n" + 
					"click 1 to view team roster\r\n" + 
					"click 2 to view team stats\r\n" + 
					"click 3 to view team salary\r\n" + 
					"click 4 to view player salary database");


			int choice=i.nextInt();

			if (choice==1) {
				q1(team);
				System.out.println("Would you like to do anything else? (y or n)");
				char c = sc.next().charAt(0); 
				if(c=='y'||c=='Y') {
					System.out.println("What would you like to do?\r\n" + 
							"click 2 to view team stats\r\n" + 
							"click 3 to view team salary\r\n" + 
							"click 4 to view player salary database");
					int choice2=i.nextInt();

					if(choice2==2) {
						q2(team);
						System.out.println("Here are the player stats as well");
						q3(team);
						System.out.println("Would you like to do anything else? (y or n)");
						char c2 = sc.next().charAt(0); 
						if(c2=='y'||c2=='Y') {
							System.out.println("What would you like to do?\r\n" + 
									"click 3 to view team salary\r\n" + 
									"click 4 to view player salary");
							int choice3=i.nextInt();

							if(choice3==3) {
								q4(team);

								System.out.print("Want to see player salaries too?(y/n)");
								char c3 = sc.next().charAt(0); 

								if(c3=='y'||c3=='Y') {
									System.out.println("click 4 to view player salary");
									int choice4=i.nextInt();

									if(choice4==4) {

										q5(team);
										System.out.println("If you want to view more open the NBA database again. Bye");


									}

									else {
										System.out.println("INVALID ANSWER");
										close();
									}

								}
								else {
									close();

								}

							}

							else if(choice2==4) {
								q5(team);
								System.out.println("If you want to view more open the NBA database again. Bye");
							}
							else {
								System.out.println("INVALID ANSWER");
								close();
							}

						}
						else {
							close();

						}
					}
					else if (choice2==3) {
						q4(team);
						System.out.print("Want to see player salaries too?(y/n)");
						char c3 = sc.next().charAt(0); 

						if(c3=='y'||c3=='Y') {



							q5(team);
							System.out.println("If you want to view more open the NBA database again. Bye");

						}
					}
					else if(choice2==4) {
						q5(team);
						System.out.println("If you want to view more open the NBA database again. Bye");
						close();					}
					else {
						System.out.println("INVALID ANSWER");
						close();
					}

				}
				else {
					close();
				}

			}
			else if(choice==2) {
				q2(team);
				System.out.println("Here are the player stats as well");
				q3(team);
				System.out.println("Would you like to do anything else? (y or n)");
				char c2 = sc.next().charAt(0); 
				if(c2=='y'||c2=='Y') {
					System.out.println("What would you like to do?\r\n" + 
							"click 3 to view team salary\r\n" + 
							"click 4 to view player salary");
					int choice3=i.nextInt();

					if(choice3==3) {
						q4(team);

						System.out.print("Want to see player salaries too?(y/n)");
						char c3 = sc.next().charAt(0); 

						if(c3=='y'||c3=='Y') {
							System.out.println("click 4 to view player salary");
							int choice4=i.nextInt();

							if(choice4==4) {

								q5(team);
								System.out.println("If you want to view more open the NBA database again. Bye");


							}

							else {
								System.out.println("INVALID ANSWER");
								close();
							}

						}
						else {
							close();

						}
					}
				}
			}
			else if (choice==3) {
				q4(team);
				System.out.print("Want to see player salaries too?(y/n)");
				char c3 = sc.next().charAt(0); 

				if(c3=='y'||c3=='Y') {



					q5(team);
					System.out.println("If you want to view more open the NBA database again. Bye");

				}
				else {
					close();

				}

			}
			else if(choice==4) {
				q5(team);
				System.out.println("If you want to view more open the NBA database again. Bye");
				close();

			}
			else {
				System.out.println("INVALID ANSWER");
				close();
			}
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	//coach stuff

	public static void SQL1()
	{
		Statement states = null;
		try
		{
			states = connection.createStatement();

			String sql = "SELECT t_teamkey, t_name FROM Team";
			ResultSet rs = states.executeQuery(sql);
			while(rs.next()) {
				System.out.println("");
				System.out.print("Team Name: " + rs.getString("t_name") + " | ");
				System.out.println("Team Key: " + rs.getString("t_teamkey"));
				System.out.println("");
			}
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}


	public static void SQL2()
	{
		String val1;
		String val2;
		Scanner key = new Scanner(System.in);
		Statement states = null;
		PreparedStatement state = null;

		try
		{
			states = connection.createStatement();
			state = connection.prepareStatement("UPDATE Stats SET st_min = ? WHERE st_statkey = ?");

			System.out.println("Enter Stat Key of Player:");
			val1 = key.next();

			System.out.println("Enter New Amount of Minutes:");
			val2 = key.next();

			Integer.valueOf(val1);
			Integer val3 = Integer.valueOf(val1);
			val3.intValue();
			int suppkey1 = val3.intValue();

			Integer.valueOf(val2);
			Integer val4 = Integer.valueOf(val2);
			val4.intValue();
			int suppkey2 = val4.intValue();

			state.setInt(1, suppkey2);
			state.setInt(2, suppkey1);
			state.executeUpdate();
			state.close();

			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	public static void SQL3()
	{
		Statement states = null;
		Scanner key = new Scanner(System.in);
		int playerKey;
		System.out.println("Enter a Player Key to change role:");
		playerKey = key.nextInt();
		try
		{
			states = connection.createStatement();

			String sql = "SELECT p_name, p_statkey FROM Player WHERE p_playerkey = " + playerKey;
			ResultSet rs = states.executeQuery(sql);
			while(rs.next()) {
				System.out.println("");
				System.out.print("Player Name: " + rs.getString("p_name") + " | ");
				System.out.println("StatKey: " + rs.getString("p_statkey"));
				System.out.println("");
			}
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}


	public static void SQL4()
	{
		Statement states = null;
		Scanner key = new Scanner(System.in);
		int teamKey;
		System.out.println("Enter a Team Key:");
		teamKey = key.nextInt();
		try
		{
			states = connection.createStatement();

			String sql = "SELECT DISTINCT p_name,\r\n" + 
					"				 p_playerkey,\r\n" +
					"                d_role,\r\n" + 
					"                t_name\r\n" + 	
					"  FROM player,\r\n" + 
					"       depthchart,\r\n" + 
					"       team\r\n" + 
					" WHERE p_teamkey = t_teamkey AND \r\n" + 
					"       p_depthkey = d_depthkey AND  \r\n" + 
					"       d_playerkey = p_playerkey AND \r\n" + 
					"       t_teamkey = " + teamKey + " ORDER BY d_role DESC";
			ResultSet rs = states.executeQuery(sql);
			while(rs.next()) {
				System.out.print("Player Name: " + rs.getString("p_name") + " | ");
				System.out.print("Player Key: " + rs.getString("p_playerkey") + " | ");
				System.out.print("Depth Role: " + rs.getString("d_role") + " | ");
				System.out.println("Team Name: " + rs.getString("t_name"));
			}
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}


	public static void SQL5()
	{
		Statement states = null;
		Scanner key = new Scanner(System.in);
		int playerKey;
		System.out.println("Enter a Player Key:");
		playerKey = key.nextInt();
		try
		{
			states = connection.createStatement();

			String sql = "UPDATE DepthChart  \r\n" + 
					"SET     d_role =  CASE  \r\n" + 
					"                        WHEN d_role = 'Starter' THEN 'Bench' \r\n" + 
					"                        WHEN d_role = 'Bench' THEN 'Starter'\r\n" + 
					"                        ELSE d_role\r\n" + 
					"                    END \r\n" + 
					"WHERE   d_playerkey IN (SELECT d_playerkey FROM Player, DepthChart WHERE p_playerkey = d_playerkey AND p_playerkey = " + playerKey + ")";
			states.executeUpdate(sql);
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	public static void SQL6()
	{
		Statement states = null;
		Scanner key = new Scanner(System.in);
		int teamKey;
		System.out.println("Enter a Team Key:");
		teamKey = key.nextInt();
		try
		{
			states = connection.createStatement();

			String sql = "SELECT DISTINCT p_name,\r\n" + 
					"                p_playerkey,\r\n" + 
					"                st_min\r\n" + 
					"                \r\n" + 
					"  FROM Player,\r\n" + 
					"       Team,\r\n" + 
					"       Stats\r\n" + 
					" WHERE p_teamkey = t_teamkey AND  \r\n" + 
					"       st_statkey = p_statkey AND\r\n" + 
					"       t_teamkey = " + teamKey;
			ResultSet rs = states.executeQuery(sql);
			while(rs.next()) {
				System.out.print("Player Name: " + rs.getString("p_name") + " | ");
				System.out.print("Player Key: " + rs.getString("p_playerkey") + " | ");
				System.out.println("Minutes Played: " + rs.getString("st_min"));
			}
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}


	public static void SQL7()
	{
		Statement states = null;
		Scanner key = new Scanner(System.in);
		int teamKey;
		System.out.println("Enter a Team Key:");
		teamKey = key.nextInt();
		try
		{
			states = connection.createStatement();

			String sql = "SELECT DISTINCT p_name,\r\n" + 
					"                p_playerkey,\r\n" + 
					"                p_position\r\n" + 
					"                \r\n" + 
					"  FROM Player,\r\n" + 
					"       Team\r\n" +
					" WHERE p_teamkey = t_teamkey AND  \r\n" + 
					"       t_teamkey = " + teamKey;
			ResultSet rs = states.executeQuery(sql);
			while(rs.next()) {
				System.out.print("Player Name: " + rs.getString("p_name") + " | ");
				System.out.print("Player Key: " + rs.getString("p_playerkey") + " | ");
				System.out.println("Position: " + rs.getString("p_position"));
			}
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}




	public static void SQL8()
	{
		Statement states = null;
		Scanner key = new Scanner(System.in);
		int playerKey;
		System.out.println("Enter a Player Key to change Position of:");
		playerKey = key.nextInt();
		String pos;
		System.out.println("Enter a Position to change to:");
		pos = key.next();
		try
		{
			states = connection.createStatement();

			String sql = "UPDATE Player SET p_position = '" + pos + "' WHERE p_playerkey = " + playerKey;
			states.executeUpdate(sql);
			states.close();       	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}



	public static void Disconnect()
	{
		try
		{
			if(connection != null) {
				connection.close();
				System.out.println("Successfully Disconnected");
			}        	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}



	public static void coach() {
		Scanner key = new Scanner(System.in);
		int item = 0;

		while(item != 10) {
			if(item == 0) {
				System.out.println("Enter 1 to Connect");
				item = key.nextInt();
				open();
				continue;
			}
			if(item == 1) {
				System.out.println("Enter 2 to go to Menu, Please enter the number 2 COACH");
				item = key.nextInt();
				if(item == 2) {
					continue;
				}
				else {
					System.out.println("Wrong Choice, YOu FaIl Fool!");
					break;
				}
			}


			System.out.println("Choose Method: ");
			System.out.println("1--> CONNECT");
			System.out.println("2--> View minutes");
			System.out.println("3--> Adjust minutes");
			System.out.println("4--> What is the Player Name from the Player Key");
			System.out.println("5--> Print out Teams");
			System.out.println("6--> List out the depth of a team and each Player Key");
			System.out.println("7--> Adjust Depth");
			System.out.println("8--> View Positions");
			System.out.println("9--> Adjust position");
			System.out.println("10--> DISCONNECT");

			item = key.nextInt();

			switch(item) {

			case 1:
				item = 1;
				open();
				break;
			case 2:
				item = 2;
				SQL6();
				break;
			case 3:
				item = 3;
				SQL2();
				break;
			case 4:
				item = 4;
				SQL3();
				break;
			case 5:
				item = 5;
				SQL1();
				break;
			case 6:
				item = 6;
				SQL4();
				break;
			case 7:
				item = 7;
				SQL5();
				break;
			case 8:
				item = 8;
				SQL7();
				break;
			case 9:
				item = 9;
				SQL8();
				break;
			case 10:
				item = 10;
				Disconnect();
				break;

			default:
				System.out.println("Return back to Menu and Try Again");
			}
		}
	}
	public static void t1(String name, int key) {
		try {
			Statement statement = connection.createStatement();
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);
			String sql="update Player\r\n" + 
					"set p_teamkey='"+key+"',p_depthkey='"+key+"'\r\n" + 
					"where p_name='"+name+"';\r\n";
			statement.executeUpdate(sql);
			statement.close();  
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
	}
	public static void t2(String name, int key) {
		try {
			Statement statement = connection.createStatement();
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);
			String sql="update DepthChart\r\n" + 
					"set d_depthkey='"+key+"'\r\n" + 
					"where d_playerkey in (select d_playerkey from Depthchart, player where p_playerkey=d_playerkey and p_name='"+name+"');\r\n";
			statement.executeUpdate(sql);
			statement.close();  
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}

	}

	public static void gmq1() {
		try {

			Statement statement = connection.createStatement();
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);

			System.out.println("What player will you be Trading for?");
			String name=input.nextLine();
			ResultSet r=statement.executeQuery("select p_name,t_salarycap, s_salary\r\n" + 
					"from player,salary,team\r\n" + 
					"where p_salary=s_salarykey and p_teamkey=t_teamkey\r\n"
					+ "and p_name='"+name+"'");
			while(r.next()){
				System.out.println("Player:"+name+" |Salary:$"+r.getString("s_salary"));

			}
			System.out.println("Who are you trading?");
			String name2=input.nextLine();
			System.out.println("Enter your team key");
			int key=input.nextInt();
			System.out.println("Enter "+name+"'s team key");
			int key2=input.nextInt();
			t1(name,key);
			t2(name,key);
			t1(name2,key2);
			t2(name2,key2);


		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void gmq2() {
		try {
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);
			Statement statement = connection.createStatement();
			System.out.println("Choose a player to change their salary");
			String name =input.next();
			System.out.println("Enter a salary");
			int sal =i.nextInt();
			String sql="update Salary \r\n" + 
					"set s_salary='"+sal+"'\r\n" + 
					"where s_salarykey in (select s_salarykey from salary, player where s_salarykey=p_salary and p_name='"+name+"');";
			statement.executeUpdate(sql);
			statement.close();

		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void gmq3() {
		try {
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);
			Statement statement = connection.createStatement();
			System.out.println("Choose a player to release");
			String name =input.nextLine();
			System.out.println("Enter 31");
			int key=i.nextInt();
			if(key==31) {
				String sql="update Player\r\n" + 
						"set p_teamkey='"+key+"', p_depthkey='N/A'\r\n" + 
						"where p_name in (select p_name from player, team where p_teamkey=t_teamkey and p_name ='"+name+"' );\r\n"
						+ "update DepthChart\r\n" + 
						"set d_depthkey='N/A'\r\n" + 
						"where d_playerkey in (select d_playerkey from Depthchart, player where p_playerkey=d_playerkey and p_name='"+name+"');\r\n";

				statement.executeUpdate(sql);
				statement.close();		}
			else {
				System.out.println("You didn't follow directions :/");
				close();
			}
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}
	public static void gmq4() {
		try {
			Scanner input = new Scanner(System.in); 

			Statement statement = connection.createStatement();
			System.out.println("What shot% do you want to have?");
			double shot=input.nextDouble();
			System.out.println("blocks?");
			double blocks=input.nextDouble();
			System.out.println("steals?");
			double steals=input.nextDouble();
			System.out.println("ppg?");
			int ppg=input.nextInt();
			System.out.println("Offensive Rating?");
			int offense=input.nextInt();
			System.out.println("Defensive Rating?");
			int defense=input.nextInt();
			System.out.println("Ovr?");
			int ovr=input.nextInt();



			ResultSet r=statement.executeQuery("select p_name, pos_name, t_name, t_teamkey\r\n" + 
					"from player, positions , team,stats\r\n" + 
					"where p_playerkey=pos_playerkey and \r\n" + 
					"st_statkey=p_statkey and\r\n" + 
					"p_teamkey=t_teamkey and\r\n" + 
					"st_ShotPercentage>'"+shot+"' and st_blocks>'"+blocks+"' and st_steals>'"+steals+"' and st_ppg>'"+ppg+"' and st_offense>'"+offense+"' and st_defense>'"+defense+"' and st_ovr>'"+ovr+"'\r\n" + 
					"group by p_name order by t_name\r\n" );
			while(r.next()){
				System.out.println("Player name:"+r.getString("p_name"));
				System.out.print("Position "+r.getString("pos_name"));
				System.out.print("|Team: "+r.getString("t_name"));
				System.out.println("|TeamKey "+r.getString("t_teamkey"));

			}
		}
		catch(SQLException e)
		{
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		finally
		{

		}
	}

	public static void gm() {
		try {
			System.out.println("Which team are you a gm of? ('no team' is not a valid otion)");
			Statement statement = connection.createStatement();
			Scanner sc = new Scanner(System.in); 
			ResultSet rs=statement.executeQuery("select t_name\r\n" + 
					"from team");
			while(rs.next()) {
				System.out.println(rs.getString("t_name"));
			}
			Scanner input = new Scanner(System.in);
			Scanner i = new Scanner(System.in);

			String team= input.nextLine();

			int choice =0;
			while (choice!=9) {

				if(choice == 0) {
					System.out.println("Enter 2 to go to Menu");
					choice = input.nextInt();
					if(choice == 2) {
						continue;
					}
					else {
						System.out.println("Wrong Choice, YOu FaIl Fool!");
						break;
					}
				}
				System.out.println("What would you like to do?\r\n" + 
						"click 1 to view team roster\r\n" + 
						"click 2 to view team stats\r\n" + 
						"click 3 to view players and team salary\r\n" +
						"click 4 to trade players\r\n"+
						"clicj 5 to adjust player salary\r\n"+
						"click 6 to release players\r\n"+
						"click 7 to change your team\r\n"+
						"click 8 to view all players that match criteria\r\n"+
						"click 9 to close the database\r\n");
				choice=	i.nextInt();

				switch(choice) {

				case 1:
					choice = 1;
					q1(team);
					break;
				case 2:
					choice = 2;
					q2(team);
					System.out.println("Here are the player stats as well");
					q3(team);
					break;
				case 3:
					choice = 3;
					q4(team);
					q5(team);
					break;
				case 4:
					choice = 4;
					gmq1();
					break;
				case 5:
					choice = 5;
					gmq2();
					break;
				case 6:
					choice = 6;
					gmq3();
					break;
				case 7:
					choice = 7;
					System.out.println("Which team are you a gm of? ('no team' is not a valid otion)");

					Scanner input2 = new Scanner(System.in);

					team= input2.nextLine();					
					break;
				case 8:
					choice = 8;
					gmq4();
					break;
				case 9:
					choice =9;
					close();
					break;
				default:
					System.out.println("Return back to Menu and Try Again");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close() {
		try
		{
			if(connection != null)
				connection.close();
			System.out.println("closed successfully");

		}
		catch(SQLException e)
		{
			// connection close failed.
			System.err.println(e.getMessage());
		}
	}
}




