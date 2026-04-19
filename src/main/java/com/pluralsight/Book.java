package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedout, String checkedOutTo){
        this.id=id;
        this.isbn=isbn;
        this.title=title;
        this.isCheckedOut=isCheckedout;
        this.checkedOutTo=checkedOutTo;

    }
    public boolean setisCheckedOut(boolean isCheckedOut){
        this.isCheckedOut=isCheckedOut;
        return this.isCheckedOut;
    }
    public void setCheckedOutto(String name){
        this.checkedOutTo=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
public void checkOut(String name){
    this.isCheckedOut=true;
    this.checkedOutTo=name;
}
public void checkIn(){
    this.isCheckedOut=false;
    this.checkedOutTo="";
}
}
