package _001_ToDo;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by jessemaynard on 10/12/16.
 */
public class Menu {

    // Scanner that detects input.
    Scanner input = new Scanner(System.in);

    public void menu(){
        //Variables
        int menuOptions;
        boolean menuActive = true;

        //Accessing methods in other classes
        List accessList = null;
        try {
            accessList = new List();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Help accessHelp = new Help();

        try {
        while (menuActive){
            System.out.println("Howdy, what would you like to make?");
            //Menu Options flavor text
            System.out.println("1. Make a New List/Add to List");
            System.out.println("2. List Items");
            System.out.println("3. Remove an Item");
            System.out.println("4. Clear Your List");
            System.out.println("5. Help!");
            System.out.println("6. Quit");

            menuOptions = input.nextInt();
            // Switch statement for menu
            switch (menuOptions) {
                case (1): accessList.addToList();
                    break;
                case (2): accessList.displayList();
                    break;
                case (3): accessList.removeFromList();
                    break;
                case (4): accessList.clearList();
                    break;
                case (5): accessHelp.displayHelp();
                    break;
                case (6): System.exit(0);
                    break;
            }
        }

        } catch (InputMismatchException ime){
            System.out.println("Looks like you've entered an invalid option.");
        }
    }

}
