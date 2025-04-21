import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean[] accents = {false, false, false, false, false, false, false, false, false, false};
        boolean firstClassOcuped = false;
        boolean economyClassOcuped = false;

        for(int i = 0; i < accents.length; i++){

            Choice choice = Choice.NULL;

            int inputChoice = verifyResponse("Enter 1 for First Class e Please 2 for Economy", 1, 2);

            switch (inputChoice) {
                case 1:
                    choice = Choice.FIRST_CLASS;
                    break;
                case 2:
                    choice = Choice.ECONOMY;
                    break;
                }

            while (choice != Choice.PROCESS_CONCLUSIVE) {

                boolean notThereIsAFreeSeats = true;

                if(choice == Choice.FIRST_CLASS) {
                    for (int j = 0; j < 5; j++) {

                        if (!accents[j]) {
                            accents[j] = true;
                            choice = Choice.PROCESS_CONCLUSIVE;
                            notThereIsAFreeSeats = false;

                            System.out.println("Your accent is of the number " + (j + 1) + "in first Class");
                            break;
                        }

                    }

                }

                else{
                    for (int k = 5; k < 10; k++) {

                        if (!accents[k]) {
                            accents[k] = true;
                            choice = Choice.PROCESS_CONCLUSIVE;
                            notThereIsAFreeSeats = false;

                            System.out.println("Your accent is of the number " + (k + 1) + "in economy Class");
                            break;
                        }

                    }
                }

                if(notThereIsAFreeSeats) {

                    if(choice == Choice.FIRST_CLASS) {
                        if(economyClassOcuped){
                            System.out.println("ALl asents are occupied, the next flight leaves in 3 hours");
                            choice = Choice.PROCESS_CONCLUSIVE;
                        }
                        else{

                            firstClassOcuped = true;
                            int response = verifyResponse("All seats in" + choice.getDescription() + "are ocuppied. Do you accept being moved to the other class? \n1. yes\n2.No", 1, 2);

                            if (response == 1) {

                                    choice = Choice.ECONOMY;

                            }

                            else {
                                System.out.println("Next flight leaves in 3 hours");
                                choice = Choice.PROCESS_CONCLUSIVE;
                            }
                        }
                    }

                    else{

                        if(firstClassOcuped){
                            System.out.println("ALl asents are occupied, the next flight leaves in 3 hours");
                            choice = Choice.PROCESS_CONCLUSIVE;
                        }
                        else{

                            economyClassOcuped = true;
                            int response = verifyResponse("All seats in" + choice.getDescription() + "are ocuppied. Do you accept being moved to the other class? \n1. yes\n2.No", 1, 2);

                            if (response == 1) {

                                    choice = Choice.FIRST_CLASS;

                            }

                            else {
                                System.out.println("Next flight leaves in 3 hours");
                                choice = Choice.PROCESS_CONCLUSIVE;
                            }

                        }

                    }
                }

            }

        }
    }

    enum Choice{

        FIRST_CLASS("first class"),
        ECONOMY("economy class"),
        NULL(""),
        PROCESS_CONCLUSIVE("");

        final String description;

        Choice(String description){

            this.description = description;

        }

        public String getDescription(){
            return description;
        }

    }

    //VERIFY IF A RESPONSE MATCHES THE EXPECTED RESPONSE
    public static int verifyResponse(String question, int... options){
        Scanner input = new Scanner(System.in);

        int response = 0;
        boolean respondeDontExpected = true;
        while(respondeDontExpected) {


            try {

                System.out.println(question);
                response = input.nextInt();

            }
            catch (InputMismatchException e) {

                System.out.println("please enter a valid response");
                input.nextLine();
                continue;

            }

            boolean varContent = false;

            for (int option : options) {
                if (response == option) {
                    varContent = true;
                    break;
                }
            }
            if(varContent){

                respondeDontExpected = false;

            }
            else{

                System.out.println("Please enter a response between the options!!");

            }

        }

        return response;

    }

}