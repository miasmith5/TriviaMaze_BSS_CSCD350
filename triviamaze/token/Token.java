package triviamaze.token;
import java.util.regex.Pattern;

public abstract class Token {
	protected String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		Pattern pattern = Pattern.compile(".*");
		
		if(pattern.matcher(description).matches())
			this.description = description;
		
		else
			System.out.println("Exception Found: Input Type Mismatch In Token Class. Cannot Set Description.");
	}

	public String toString() {
		return this.description;
	}
}
