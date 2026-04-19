package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibraryApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Book[] book;
        book = new Book[20];
        book[0] = new Book(1, "978-0-06-112008-4", "To Kill a Mockingbird", true, "John Smith");
        book[1] = new Book(2, "978-0-7432-7356-5", "1984", false, "");
        book[2] = new Book(3, "978-0-14-028329-7", "The Great Gatsby", true, "Sarah Johnson");
        book[3] = new Book(4, "978-0-451-52494-2", "Pride and Prejudice", false, "");
        book[4] = new Book(5, "978-0-06-093546-7", "The Catcher in the Rye", true, "Mike Davis");
        book[5] = new Book(6, "978-0-7432-7357-2", "The Hobbit", false, "");
        book[6] = new Book(7, "978-0-451-52493-5", "Moby Dick", true, "Emily Chen");
        book[7] = new Book(8, "978-0-14-118277-8", "Brave New World", false, "");
        book[8] = new Book(9, "978-0-06-085052-4", "The Hobbit", true, "James Wilson");
        book[9] = new Book(10, "978-0-7432-7358-9", "Wuthering Heights", false, "");
        book[10] = new Book(11, "978-0-451-52491-1", "Jane Eyre", true, "Lisa Anderson");
        book[11] = new Book(12, "978-0-14-028329-8", "The Odyssey", false, "");
        book[12] = new Book(13, "978-0-06-093546-8", "Dune", true, "Robert Martinez");
        book[13] = new Book(14, "978-0-7432-7359-6", "Fahrenheit 451", false, "");
        book[14] = new Book(15, "978-0-451-52492-8", "The Picture of Dorian Gray", true, "Amanda Lee");
        book[15] = new Book(16, "978-0-14-028329-9", "Crime and Punishment", false, "");
        book[16] = new Book(17, "978-0-06-093546-9", "The Count of Monte Cristo", true, "David Brown");
        book[17] = new Book(18, "978-0-7432-7360-2", "Les Misérables", false, "");
        book[18] = new Book(19, "978-0-451-52495-9", "Frankenstein", true, "Jennifer Taylor");
        book[19] = new Book(20, "978-0-14-028330-5", "Dracula", false, "");
        int choice;

        boolean isRunning = true;
        while (isRunning) {
            choice = menu(input);
            switch (choice) {
                case 1 -> displayShowAvailableBooksMenu(input,book);
                case 2 -> displayCheckedOutBooksMenu(input, book);
                case 3 -> isRunning = quitApp("Thank you for using the services our esteemed establishment");
            }
        }
    }

    public static int menu(Scanner input) {
        System.out.println("""
                (1)Show Available Books
                (2)Show Checked Out Books
                (3)Exit - closes out of the application""");
        return input.nextInt();
    }

    public static void displayAllBooksAvailable(Book[] book) {
        int counter = 0;
        for (Book books : book) {
            if (!books.getIsCheckedOut()) {
                System.out.println("Book Id: " + books.getId() + "| ISBN: " + books.getIsbn() + "| Title: " + books.getTitle() + "| Is available: " + !books.getIsCheckedOut());
                counter++;
            }
        }
        System.out.println();
        System.out.println(counter + " is the amount of books still available to be checked out.");
        System.out.println();
    }

    public static boolean quitApp(String message) {
        System.out.println();
        System.out.println(message);
        return false;
    }

    public static void displayCheckedOutBooks(Book[] book) {
        int counter = 0;
        for (Book books : book) {
            if (books.getIsCheckedOut()) {
                System.out.println("Book Id: " + books.getId() + "| ISBN: " + books.getIsbn() + "| Title: " + books.getTitle() + "| Is available: " + !books.getIsCheckedOut() + "| Checked out by: " + books.getCheckedOutTo());
                counter++;
            }
        }
        System.out.println();
        System.out.println(counter + " is the amount that have been checked out.");
        System.out.println();

    }

    public static boolean secondMenuPrompt(Scanner input, Book[] book) {
        System.out.println("What do you want to do now?");
        System.out.println("C - to Check In a book\n" + "X - to go back to the home screen");
        char pickedCheckedOutbooksOption = input.next().charAt(0);
        while (pickedCheckedOutbooksOption != 'C' && pickedCheckedOutbooksOption != 'X') {
            System.out.println("Invalid input please try again.");
            System.out.println("C - to Check In a book\n" + "X - to go back to the home screen");
            pickedCheckedOutbooksOption = input.next().charAt(0);
        }
        if (pickedCheckedOutbooksOption == 'C') {
            System.out.println("What is the Id of the book you want to check-in?");
            int checkinId = input.nextInt();
            for (Book books : book) {
                if (checkinId == books.getId()) {
                    books.checkIn();
                    System.out.println("Book Id: " + books.getId() + "| ISBN: " + books.getIsbn() + "| Title: " + books.getTitle()+" has been checked in.");
                }
            }
        }

        return pickedCheckedOutbooksOption != 'X';
    }

    public static void displayCheckedOutBooksMenu(Scanner input, Book[] book) {
        displayCheckedOutBooks(book);
        boolean inSubMenu = true;
        while (inSubMenu) {
            inSubMenu = secondMenuPrompt(input, book);
        }
    }
    public static void displayShowAvailableBooksMenu(Scanner input, Book[] book) {
        displayAllBooksAvailable(book);
        boolean inSubMenu = true;
        while (inSubMenu) {
            inSubMenu = secondMenuForCheckOutPrompt(input, book);
        }
    }
    public static boolean secondMenuForCheckOutPrompt(Scanner input, Book[] book) {
        System.out.println("Do you want to select a book to check out or go back to the home screen?");
        System.out.println("Enter 1 to check out");
        System.out.println("Enter 2 to exit back to the home screen");
        int option = input.nextInt();
        input.nextLine();

            while (option != 1 && option != 2) {
                System.out.println("What do you want to do now?");
                System.out.println("Enter 1 to check out");
                System.out.println("Enter 2 to exit back to the home screen");
                option = input.nextInt();
                input.nextLine();  // Clear buffer

                if (option != 1 && option != 2) {
                    System.out.println("Invalid input please try again.");
                }
            }
        switch (option) {
            case 1:
                System.out.println("What is the title of the book you want to check out?");
                String title = input.nextLine();
                for (Book books : book) {
                    if (title.equals(books.getTitle())) {
                        books.checkOut(title);
                        System.out.println("Book Id: " + books.getId() + "| ISBN: " + books.getIsbn() + "| Title: " + books.getTitle()+" has been checked out.");
                    }
                }
                break;
            case 2:
                return false;
            default:
                while (option != 1 && option != 2){
                    System.out.println("Invalid input please try again.");
                    System.out.println("Enter 1 to check out");
                    System.out.println("Enter 2 to exit back to the home screen");
                    option = input.nextInt();
                }
                return secondMenuForCheckOutPrompt(input, book);
        }
        return true;
    }
}