package nl.sogyo.javaopdrachten.quote;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Quote {
    static String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };
	
	static String selectedQuote;
	static String selectedAuthor;
	static String presentableQuote;
	static String presentableAuthor;
    static Calendar today = Calendar.getInstance();
	
	public static void main(String []args) {
        chooseQuote();
		
		makePresentable(selectedAuthor, selectedQuote);
		
		printQuote();
    }
	
	public static void chooseQuote (){
		int day = today.get(Calendar.DAY_OF_YEAR);
		int quoteNumber = (day - 1) % quotes.length; //using quotes.length should offer robustness if the list of quotes ever gets extended
		selectedQuote = quotes [quoteNumber][1];
		selectedAuthor = quotes [quoteNumber][0];
	}
	
	public static void makePresentable(String inputAuthor, String inputQuote){
		presentableQuote = inputQuote.substring(0,1).toUpperCase() + inputQuote.substring(1);
		
		if(inputQuote.endsWith("!") || inputQuote.endsWith(".") || inputQuote.endsWith("?")){ //these should represent the cases where no full stop must be added
		}
		else {
			presentableQuote = presentableQuote.concat(".");
		}
		
		char[] authorArray = inputAuthor.toCharArray();
		
		authorArray[0] = Character.toUpperCase(authorArray[0]);
		
		for (int i=0;i<authorArray.length;i++){
			if (Character.isWhitespace(authorArray[i])) {
				authorArray[i+1] = Character.toUpperCase(authorArray[i+1]);
			}
		}
		
		presentableAuthor = "";
		
		for (char ch : authorArray){
			presentableAuthor = presentableAuthor + ch;		
		}
	}
	
	public static void printQuote(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
		System.out.println("Today's date is: " + dateFormat.format(today.getTime()));
		System.out.println("Today's quote is: " + '"' + presentableQuote + '"' + " -- " + presentableAuthor);
	}
}