import utils.ValidaEntradas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        double[][] sales = new double[4][5]; // 4 employees, 5 products
        boolean proceedInput = false;

        int inputStart = ValidaEntradas.verifyResponseLimitedOptions(
                "Do you want to start entering sales records? \n1. Yes\n2. No\n", 1, 2);

        if (inputStart == 1) {
            proceedInput = true;
        }

        int employeeIdInput;
        int productIdInput;
        int employeeIndex;
        int productIndex;
        double totalSales;

        while (proceedInput) {

            // INPUT: EMPLOYEE ID AND PRODUCT ID
            employeeIdInput = ValidaEntradas.verifyResponseLimitedOptions(
                    "Enter your employee ID (1-4): ", 1, 2, 3, 4);
            productIdInput = ValidaEntradas.verifyResponseLimitedOptions(
                    "Enter the product ID (1-5): ", 1, 2, 3, 4, 5);

            // ADJUST FOR ZERO-BASED INDEX
            employeeIndex = employeeIdInput - 1;
            productIndex = productIdInput - 1;

            totalSales = ValidaEntradas.verifyResponseDouble(
                    "Enter the total sales amount for this product: ");

            System.out.println("Today, employee #" + employeeIdInput +
                    " sold product #" + productIdInput +
                    " for a total of R$" + totalSales + ".");

            sales[employeeIndex][productIndex] += totalSales;

            int continueInput = ValidaEntradas.verifyResponseLimitedOptions(
                    "Do you want to enter another record? \n1. Yes\n2. No\n", 1, 2);

            if (continueInput == 2) {
                proceedInput = false;
            }
        }

        System.out.println("              Employee 1 | Employee 2 | Employee 3 | Employee 4 \n" +
                "Product 1 |    " + sales[0][0] + "          " + sales[1][0] + "          " + sales[2][0] + "          " + sales[3][0] +
                "\nProduct 2 |    " + sales[0][1] + "          " + sales[1][1] + "          " + sales[2][1] + "          " + sales[3][1] +
                "\nProduct 3 |    " + sales[0][2] + "          " + sales[1][2] + "          " + sales[2][2] + "          " + sales[3][2] +
                "\nProduct 4 |    " + sales[0][3] + "          " + sales[1][3] + "          " + sales[2][3] + "          " + sales[3][3] +
                "\nProduct 5 |    " + sales[0][4] + "          " + sales[1][4] + "          " + sales[2][4] + "          " + sales[3][4]);

        System.out.println("End of program.");
    }
}
