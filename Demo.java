import java.util.*;

public class Demo
{
    public static void main(String[] args)
    {
        int wood = 0, drawers = 0, quantity = 0;
        String woodType = " ", input = " "; 
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<Order>();

        //Do-while loop that iterates as long as the user wishes to enter more information.
        do
        {
            //Gathering information from the user.
            System.out.println("\nType of wood:");
            System.out.println("\t1. Cherry\n\t2. Oak\n\t3. Pine");
            System.out.print("Select the Type of wood: ");
            wood = keyboard.nextInt();
            //Validating input.
            while(wood < 1 || wood > 3)
            {
                System.out.print("That is an invalid menu choice. You must enter a number from 1 - 3. Try again: ");
                wood = keyboard.nextInt();
                System.out.println();
            }
            //Assigning the wood type based on the menu selection.
            if(wood == 1)
            {
                woodType = "Cherry";
            }
            else if(wood == 2)
            {
                woodType = "Oak";
            }
            else 
            {
                woodType = "Pine";
            }

            System.out.print("Enter the number of drawers: ");
            drawers = keyboard.nextInt();
            //Validating input. No more than 6 drawers and no less than 0.
            while(drawers > 6)
            {
                System.out.print("That is too many drawers. The number of drawers must be no more than 6: Try again: ");
                drawers = keyboard.nextInt();
            }
            while(drawers < 0)
            {
                System.out.print("That is too few drawers. The number of drawers must be at least 0. Try again: ");
                drawers = keyboard.nextInt();
                System.out.println();
            }

            System.out.print("Enter the amount of desks you wish to purchase: ");
            quantity = keyboard.nextInt();
            //Validating input. The user must order at least one desk.
            while(quantity < 1)
            {
                System.out.print("You must order at least one desk. Try again: ");
                quantity = keyboard.nextInt();
            }

            //Instantiating a Desk object.
            Desk desk = new Desk(woodType, drawers);
            
            //Adding a new Order object the the orders ArrayList each time the loop iterates.
            orders.add(new Order(desk, quantity));

            keyboard.nextLine();
            System.out.print("\nWould you like to enter another order for desks (Y/N)?: ");
            input = keyboard.nextLine();
        } while(input.equalsIgnoreCase("y"));

        System.out.println("\nDesk Orders Report");
        //For loop to display the information.
        for(int i = 0; i < orders.size(); i++)
        {
            System.out.println(orders.get(i));
        }

        //Finding the most expensive desk.
        double mostExpensive = orders.get(0).getDiscountedPrice();
        for(int i = 1; i < orders.size(); i++)
        {
            if(mostExpensive < orders.get(i).getDiscountedPrice())
            {
                mostExpensive = orders.get(i).getDiscountedPrice();
            }
        }
        
        System.out.printf("\nOut of the %d orders that were placed, the most " +
                          "expensive desk sold costs $%,.2f", orders.get(0).getCounter(), mostExpensive);
    }
}
