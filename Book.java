public class Book {

  //Properties, Fields and Global Variables
  String title;
  int pageCount;
  int ISBN;
  boolean isCheckedOut;
  int dayCheckedOut = -1;

  //Constructor for a new book.
  public Book(String title, int pageCount, int ISBN){
    //Things I would want a new book to have, when it is first initialized.
    this.title = title;
    this.pageCount = pageCount;
    this.ISBN = ISBN;
    //New book is created. So it cannot be checked out yet by default.
    isCheckedOut = false;
  }

  //Getters ---> INSTANCE methods. They get property values of instances.
  public String getTitle() {
    return this.title;
  }

  public int getPageCount(){
    return this.pageCount;
  }

  public int getISBN(){
    return this.ISBN;
  }

  public boolean getIsCheckedOut(){
    return this.isCheckedOut;
  }

  public int getDayCheckedOut(){
    return this.dayCheckedOut;
  }

  //Setters
  public void setIsCheckedOut(boolean isCheckedOut, int dayCheckedOut){
    this.isCheckedOut = isCheckedOut;
    setDayCheckedOut(dayCheckedOut);
  }

  private void setDayCheckedOut(int dayCheckedOut){
    this.dayCheckedOut = dayCheckedOut;
  }

}
