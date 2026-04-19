# Project Name
Neighborhood library App- A library book inventory management system that facilitates check-in and checkout.
While displaying books available to be checked out and books already checked out, with any relevant information.
## Table of contents
  -Installation
  -Usage
  -features
  -Contributing
## Installation
  
### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Steps
1. Clone the repository
   ```bash
   git clone https://github.com/Estb1296/neighborhood-library-app.git
2. Navigate to the project directory
      cd neighborhood-library-app
3. Build the project and compile
     mvn clean install
     mvn exec: java
## Usage

-View all available books(doesn't include already checkedout Books)
-Check out a book
-Check in a book
-View checked-out books
## Example Output
```
public static int menu(Scanner input) {
        System.out.println("""
                (1)Show Available Books
                (2)Show Checked Out Books
                (3)Exit - closes out of the application""");
        return input.nextInt();
    }
```

(1)Show Available Books
(2)Show Checked Out Books
(3)Exit - closes out of the application
1
Book Id: 2| ISBN: 978-0-7432-7356-5| Title: 1984| Is available: true
Book Id: 4| ISBN: 978-0-451-52494-2| Title: Pride and Prejudice| Is available: true
Book Id: 6| ISBN: 978-0-7432-7357-2| Title: The Hobbit| Is available: true
Book Id: 8| ISBN: 978-0-14-118277-8| Title: Brave New World| Is available: true
Book Id: 10| ISBN: 978-0-7432-7358-9| Title: Wuthering Heights| Is available: true
Book Id: 12| ISBN: 978-0-14-028329-8| Title: The Odyssey| Is available: true
Book Id: 14| ISBN: 978-0-7432-7359-6| Title: Fahrenheit 451| Is available: true
Book Id: 16| ISBN: 978-0-14-028329-9| Title: Crime and Punishment| Is available: true
Book Id: 18| ISBN: 978-0-7432-7360-2| Title: Les Misérables| Is available: true
Book Id: 20| ISBN: 978-0-14-028330-5| Title: Dracula| Is available: true

10 is the amount of books still available to be checked out.

Do you want to select a book to check out or go back to the home screen?
Enter 1 to check out
Enter 2 to exit back to the home screen
```
 public static void displayShowAvailableBooksMenu(Scanner input, Book[] book) {
        displayAllBooksAvailable(book);
        boolean inSubMenu = true;
        while (inSubMenu) {
            inSubMenu = secondMenuForCheckOutPrompt(input, book);
        }
    }
```
```
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
```
Entered 1:
What is the title of the book you want to check out?
Fahrenheit 451
Book Id: 14| ISBN: 978-0-7432-7359-6| Title: Fahrenheit 451 has been checked out.
Do you want to select a book to check out or go back to the home screen?
Enter 1 to check out
Enter 2 to exit back to the home screen
Entered 2:

Exited back to the first menu

(1)Show Available Books
(2)Show Checked Out Books
(3)Exit - closes out of the application
```
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
```
Entered 1:
Book Id: 2| ISBN: 978-0-7432-7356-5| Title: 1984| Is available: true
Book Id: 4| ISBN: 978-0-451-52494-2| Title: Pride and Prejudice| Is available: true
Book Id: 6| ISBN: 978-0-7432-7357-2| Title: The Hobbit| Is available: true
Book Id: 8| ISBN: 978-0-14-118277-8| Title: Brave New World| Is available: true
Book Id: 10| ISBN: 978-0-7432-7358-9| Title: Wuthering Heights| Is available: true
Book Id: 12| ISBN: 978-0-14-028329-8| Title: The Odyssey| Is available: true
Book Id: 16| ISBN: 978-0-14-028329-9| Title: Crime and Punishment| Is available: true
Book Id: 18| ISBN: 978-0-7432-7360-2| Title: Les Misérables| Is available: true
Book Id: 20| ISBN: 978-0-14-028330-5| Title: Dracula| Is available: true

9 is the amount of books still available to be checked out.

The amount of books available  and displayed changed cause the book chosen was checked out
```
3
Invalid input, please try again.
What do you want to do now?
Enter 1 to check out
Enter 2 to exit back to the home screen

```
The following example shows what happens when a user enters an invalid option in the checkout menu. The system prompts the user to try again and provides the available options.
### Running the application
```bash
   git clone https://github.com/Estb1296/neighborhood-library-app.git
```

## Project Structure
src/
├── main/
│   └── java/
│       └── com/
│           └── Pluralsight/
│               ├── Book.java
│               └── NeighborhoodLibraryApp.java
pom.xml
target/
## Technologies
- **Language:** Java 11
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA / Eclipse
- **JDK:** OpenJDK 11
## Project Structure
├── Book.java
├── NeighborhoodLibraryApp.java

## Architecture
### Display all available books
- Books are stored as objects in a `Book[]` array
- Each book contains properties such as ID, ISBN, title, and checkout status
-Prompts user for Checkout/Exit back to home screen
### Display all checked-out books
-books derived from objects stored in a Java class, books that contain a basic array
-Prompts user for Checkin/Exit back to home screen
###Quit app
-The option picked will terminate the program

## Method Documentation

| Method | Purpose / Description | Returns |
|---------|----------------------|----------|
| `menu(Scanner input)` | Displays the main menu and returns the user's choice | `int` |
| `displayAllBooksAvailable(Book[] book)` | Lists all available books for checkout | `void` |
| `quitApp(String message)` | Prints exit message and stops the application | `boolean` |
| `displayCheckedOutBooks(Book[] book)` | Shows books currently checked out | `void` |
### Notes
-All methods rely on a shared Book[] array and a Scanner for console input.
-Input validation ensures proper user interaction and prevents invalid actions.
-Designed for clarity and simplicity in console-based Java projects.
## Author
**Ezra Teshale**
- GitHub:(https://github.com/Estb1296)
- Email: ezra.teshale12@gmail.com
## Features
- Check in and check out books
- View available and checked-out books
- Simple command-line interface
- Easy maneuver between screens in the console
