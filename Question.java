import java.util.Random;

public class Question {
	private String question;
	private int answer;
	
	
	
	public Question() {
		this.question = generateQuestion(new Random().nextInt(3));
	}
	
	public String generateQuestion(int n) {
		if(n == 0) {
			this.answer = 1;
			return "This is question one.";
		}
		
		else if(n == 1) {
			this.answer = 2;
			return "This is question two.";
		}
		
		else if(n == 2) {
			this.answer = 3;
			return "This is question three.";
		}
		
		return null;
	}
	
	public boolean hasBeenAnswered(int answer) {
		if(this.answer == answer)
			return true;
		else
			return false;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
