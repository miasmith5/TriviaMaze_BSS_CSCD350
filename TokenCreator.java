
public class TokenCreator {

	public static Token createToken(int n) {
		if(n == 0) {
			return new AddAChanceToken();
		}
		
		else if(n == 1){
			return new RemoveTwoChoicesToken();
		}
		
		// add tokens later
		
		return null;
	}
}
