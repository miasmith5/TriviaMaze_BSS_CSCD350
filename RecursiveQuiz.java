
public class RecursiveQuiz {
private int count = 0;

void bar(int n ) {
	if(n <= 0) return;
	
	for(int i =0; i < n; i++) {
		this.count = this.count + 1;
	}
	
	bar(n-1);
}

private int getCount() {
	return count;
}

public static void main(String[] args) {
	RecursiveQuiz rq = new RecursiveQuiz();
	
	rq.bar(4);
	
	System.out.print(rq.getCount());
}
}
