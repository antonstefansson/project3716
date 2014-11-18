import java.util.Scanner;

public class Admin {
	public Admin( Project proj ) {
		Scanner sc = new Scanner( System.in );
		System.out.println("Enter the group size:");
		while( !sc.hasNextInt() ) {
			System.out.println("Enter an Integer:");
			sc.nextLine();
		}
		int size = sc.nextInt();
		proj.setSize( size );
	}
}
