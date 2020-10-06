package pandemic;

public class Cycle {
	int cycleNumber;
	String newsArticle;
	
	public Cycle() {
		
	}
	
	public void setPaper() {
		newsArticle = "Hello World";
		System.out.println(newsArticle);			
	}
	
	public String getPaper() {
		return newsArticle;
	}
}
