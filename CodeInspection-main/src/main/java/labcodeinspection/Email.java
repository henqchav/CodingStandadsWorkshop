package labcodeinspection;
import java.util.Locale;
public class Email {

	private transient final String m_firstName; //NOMPD esta linea se debe mantener
	private transient final String m_lastName;
	private transient String password;
	private transient String department;
	private transient final int defaultpasswordLength = 8;
	private transient String email;
	/**
     * Constructor de la clase Email.
     *
     * @param firstName el nombre del destinatario
     * @param lastName el apellido del destinatario
     */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.password = null;
	}
	/**
     * Muestra la información del email.
     */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}
	/**
     * Establece el departamento del email según el código proporcionado.
     *
     * @param depChoice el código del departamento
     */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			this.department = "unknown";
			break;
		}
	}
	/**
	 * Crea una contraseña de manera aleatoria 
	 * 
	 * 
	 * @param length
	 * @return
	 */
	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	/**
     * Genera el email y asigna una contraseña aleatoria.
     * El email generado se basa en el nombre, apellido y departamento.
     */
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		this.email = this.m_firstName.toLowerCase(Locale.ROOT) + this.m_lastName.toLowerCase(Locale.ROOT) + "@" + this.department.toLowerCase(Locale.ROOT)
				+ ".espol.edu.ec";
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
}
