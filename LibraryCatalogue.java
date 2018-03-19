import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue{

  Map<String,Book> bookCollection = new HashMap <String,Book>();
  int currentDay = 0;
  int lengthOfCheckoutPeriod = 7;
  double initialLateFee = 0.50;
  double feePerLateDay = 1.00;

  public LibraryCatalogue(){
    Map<String,Book> bookCollection = new HashMap <String,Book>();
  }

  public LibraryCatalogue(Map<String,Book> bookCollection, int lengthOfCheckoutPeriod, double initialLateFee, double feePerLateDay){
    this.bookCollection = bookCollection;
    this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
    this.initialLateFee = initialLateFee;
    this.feePerLateDay = feePerLateDay;
  }

  //Getters
  public Map<String,Book> getBookCollection(){
    return this.bookCollection;
  }

  public Book getBook(String title){
    return getBookCollection().get(title);
  }

  public int getCurrentDay(){
    return this.currentDay;
  }

  public int getLengthOfCheckoutPeriod(){
    return this.lengthOfCheckoutPeriod;
  }

  public double getInitialLateFee(){
    return this.initialLateFee;
  }

  public double getFeePerLateDay(){
    return this.feePerLateDay;
  }

  //Setters
  public void nextDay(){
    this.currentDay++;
  }

  public void setDay(int currentDay){
    this.currentDay = currentDay;
  }

  //INSTANCE Methods
  public void checkOutBook(String title){
    Book book = getBook(title);
    if (book.getIsCheckedOut()){
      sorryBookAlreadyCheckedOut(book);
    } else{
      book.setIsCheckedOut(true, currentDay);
      System.out.println(title + " is successfully checked out! It is due on "
      + (getCurrentDay() + getLengthOfCheckoutPeriod()) + ".");
    }
  }

  public void returnBook(String title){
    Book book = getBook(title);
    int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
    if (daysLate > 0){
      System.out.println("The book is returned " + daysLate + " days late. Total fee owed to the library is $" + (getInitialLateFee() + (getFeePerLateDay() * daysLate)) + ".");
    } else {
      System.out.println("The book is successfully returned. Thank you!");
    }
    book.setIsCheckedOut(false, -1);

  }

  public void sorryBookAlreadyCheckedOut(Book book){
    System.out.println("Sorry, " + book.getTitle() + " is already checked out. "
    + "It should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()) + ".");
  }

  public static void main(String[] args){
    LibraryCatalogue lib = new LibraryCatalogue();
    Book harry = new Book("Harry Potter", 94857, 2113632837);
    lib.bookCollection.put("Harry Potter", harry);
    lib.checkOutBook("Harry Potter");
    lib.nextDay();
    lib.nextDay();
    lib.nextDay();
    lib.nextDay();
    lib.nextDay();
    lib.nextDay();
    lib.nextDay();
    lib.nextDay();
    lib.returnBook("Harry Potter");

  }

}
