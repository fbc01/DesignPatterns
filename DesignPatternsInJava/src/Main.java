import BuilderDesignPattern.Director;
import ObjectPoolDesignPattern.ObjectPoolClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter Number");
        Scanner input = new Scanner(System.in);
        int usecase = input.nextInt();
        switch (usecase) {
            case 1:
                Director.buildUserDTO();
                break;

            case 2:
                ObjectPoolClient.getObjectPoolImplementation();
                break;
        }
    }
}