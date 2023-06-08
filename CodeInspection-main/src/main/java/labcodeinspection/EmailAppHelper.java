package labcodeinspection;

import java.util.Scanner;

//@SuppressWarnings("PMD.UseUtilityClass")
public class EmailAppHelper{
	
	private EmailAppHelper() {
		
	}
	/**
	 * El metodo main que crea el correo 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your first name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter your last name: ");
		String lastName = sc.nextLine();

		System.out.print("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");

		int depChoice = sc.nextInt();
		sc.close();

		generateEmailAndShow(firstName, lastName, depChoice);
		
	}
	/**
	 * Metodo que genera el correo
	 * 
	 * @param fisrtName
	 * @param lastName
	 * @param depChoice
	 */
	public static void generateEmailAndShow(String fisrtName, String lastName, int depChoice) {
		Email email = new Email(fisrtName, lastName);
		email.setDeparment(depChoice);
		email.generateEmail();
		email.showInfo();
	}
}
