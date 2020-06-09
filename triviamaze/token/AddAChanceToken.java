package triviamaze.token;

public class AddAChanceToken extends Token{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddAChanceToken() {
		this.description = "A chance";
	}
	
	public String toString() {
		return this.description;
	}
}
