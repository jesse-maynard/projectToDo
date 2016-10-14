package _001_ToDo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jessemaynard on 10/12/16.
 */
public class List {

    //IntelliJ did it :D
    public List() throws FileNotFoundException {
    }

    //Scanner and Arraylist for methods in the List Class.
    Scanner input = new Scanner(System.in);
    ArrayList<String> shoppingArray = new ArrayList<>();
    ArrayList<String> toDoArray = new ArrayList<>();


    //Variables to store the input for y/n questions and the names of list txt documents.
    char yesNo;
    String shopFileName = "shoppingList.txt", toDoFileName = "remindList.txt";
    //Scanners to read text files
    Scanner readShopFile = new Scanner(new FileReader(shopFileName));
    Scanner readToDoFile = new Scanner(new FileReader(toDoFileName));


    public void addToList(){
        int listOptions;

        //Menu options
        System.out.println("What kind of list would you like to make?");
        System.out.println("1. Shopping List");
        System.out.println("2. Reminder");
        listOptions = input.nextInt();
        System.out.println("You have selected option " + listOptions + " is that correct?");
        System.out.println("y/n");
        yesNo = input.next().charAt(0);

        //Switch to redirect user
        if (yesNo == 'y'){
            switch (listOptions){
                case (1): shoppingList();
                    break;
                case (2): reminderList();
                    break;
            }
        } else {
            System.out.println("Oops, that's not an option");
        }
    }

    //Method that prints the list and writes them to a file.
    public void displayList(){

        System.out.println("Shopping List: " + shoppingArray);
        System.out.println("To Do List: " + toDoArray);
        // Reads the list from the file.
        while (readShopFile.hasNextLine()){
            shoppingArray.add(readShopFile.nextLine());
        }
        while (readToDoFile.hasNextLine()){
            toDoArray.add(readToDoFile.nextLine());
        }


    }

    //Method for making a shopping list.
    public void shoppingList() {
        boolean makingList = true;

        //Variables
        int i;


        try {
            while (makingList) {
                //Variables
                String shopInput;
                boolean moreItems = true;

                System.out.println("Okay, what are you shopping for today?");
                input.nextLine();
                shopInput = input.nextLine();
                System.out.println("Is that a High Priority item?");
                System.out.println("y/n");
                yesNo = input.next().charAt(0);
                // Switch that determines item priority.
                switch (yesNo) {
                    case ('y'):
                        shoppingArray.add(0, shopInput);
                        break;
                    case ('n'):
                        shoppingArray.add(shopInput);
                        break;
                }

                //Loop to add more items
                while (moreItems) {

                    System.out.println("Done adding items?");
                    System.out.println("y/n");
                    yesNo = input.next().charAt(0);

                    //Switch to redirect the user
                    switch (yesNo) {
                        case ('y'):
                            moreItems = false;
                            makingList = false;
                            // Writes the items in the array to the shopList file.
                            PrintWriter shopFile = new PrintWriter(new FileWriter(shopFileName));
                            for (i = 0; i < shoppingArray.size(); ++i){
                                shopFile.println(shoppingArray.get(i));
                            }
                            shopFile.close();
                            break;
                        case ('n'):
                            System.out.println("Very well, what else did you want to add?");
                            input.nextLine();
                            shopInput = input.nextLine();
                            System.out.println("Is that a High Priority item?");
                            System.out.println("y/n");
                            yesNo = input.next().charAt(0);
                            // Switch that determines item priority.
                            switch (yesNo) {
                                case ('y'):
                                    shoppingArray.add(0, shopInput);
                                    break;
                                case ('n'):
                                    shoppingArray.add(shopInput);
                                    break;
                            }
                            break;

                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reminderList(){

        boolean makingList = true;

        //Variables
        int i;

        while (makingList){
            //Loop to add more items
            String toDoInput;
            boolean moreItems = true;

            System.out.println("Okay, what are you planning to do?");
            input.nextLine();
            toDoInput = input.nextLine();
            System.out.println("Is that a High Priority task?");
            System.out.println("y/n");
            yesNo = input.next().charAt(0);
            // Switch that determines item priority.
            switch (yesNo) {
                case ('y'):
                    toDoArray.add(0, toDoInput);
                    break;
                case ('n'):
                    toDoArray.add(toDoInput);
                    break;
            }

            //Loop to add more items.
            while(moreItems) {

                System.out.println("Done adding plans?");
                System.out.println("y/n");
                yesNo = input.next().charAt(0);

                //Switch to redirect the user
                switch (yesNo) {
                    case ('y'):
                        moreItems = false;
                        makingList = false;

                        // Writes the items in the array to the shopList file.
                        try {
                            PrintWriter toDoFile = new PrintWriter(new FileWriter(toDoFileName));

                        for (i = 0; i < toDoArray.size(); ++i){
                            toDoFile.println(toDoArray.get(i));
                        }
                            toDoFile.close();
                        break;

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case ('n'):
                        System.out.println("Very well, make some more plans?");
                        input.nextLine();
                        toDoInput = input.nextLine();
                        System.out.println("Is that a High Priority task?");
                        System.out.println("y/n");
                        yesNo = input.next().charAt(0);
                        // Switch that determines item priority.
                        switch (yesNo) {
                            case ('y'):
                                toDoArray.add(0, toDoInput);
                                break;
                            case ('n'):
                                toDoArray.add(toDoInput);
                                break;
                        }
                        break;

                }
            }
        }
    }

    //Method for removing items from a list
    public void removeFromList(){
        boolean removingItem = true;

        while (removingItem){
            //Variables
            int rmvOptions;

            System.out.println("Alright, which list do you want to remove from?");
            System.out.println("1. Shopping");
            System.out.println("2. Reminders");
            rmvOptions = input.nextInt();

            switch (rmvOptions){

                case (1): rmvShoppingList();
                    break;
                case (2): rmvRemindersList();
                    break;

            }
        }
    }

    public void rmvShoppingList() {
        boolean deleting = true;
        // Variables
        int i, rmvShopItem;

        try {
            while (deleting) {

                // Variables

                for (i = 0; i < shoppingArray.size(); ++i) {
                    System.out.println((i + 1) + ". " + shoppingArray.get(i));
                }

                System.out.println("Which item would you like to delete?");
                rmvShopItem = input.nextInt();
                shoppingArray.remove(rmvShopItem - 1);
            }
        } catch (IndexOutOfBoundsException ibe){

        }
    }

    public void rmvRemindersList() {
        boolean deleting = true;
        // Variables
        int i, rmvToDoItem;

        try {
            while (deleting) {

                // Variables

                for (i = 0; i < toDoArray.size(); ++i) {
                    System.out.println((i + 1) + ". " + toDoArray.get(i));
                }

                System.out.println("Which item would you like to delete?");
                rmvToDoItem = input.nextInt();
                shoppingArray.remove(rmvToDoItem - 1);
            }
        } catch (IndexOutOfBoundsException ibe){

        }
    }

    public void clearList(){

        toDoArray.clear();
        shoppingArray.clear();

        try {
            PrintWriter shopFile = new PrintWriter(new FileWriter(shopFileName));
            shopFile.println("");
            shopFile.close();
            PrintWriter toDoFile = new PrintWriter(new FileWriter(toDoFileName));
            toDoFile.println("");
            toDoFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


