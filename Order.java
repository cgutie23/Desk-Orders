
public class Order 
{
    private Desk desk; 
    private int quantity;
    public static int counter = 0;

    /**
      No-arg Constructor. 
     */
    public Order()
    {
      desk = new Desk();
      quantity = 0;
    }

    /**
      Constructor.
      @param desk a Desk object.
      @param quantity The quantity of desks.
     */
    public Order(Desk desk, int quantity)
    {
      this.desk = new Desk(desk);
      this.quantity = quantity;
      counter ++;
    }

    /**
      setDesk method. 
      @param desk A Desk object. 
     */
    public void setDesk(Desk desk)
    {
      this.desk = new Desk(desk);
    }

    /**
      getDesk method. 
      @return a Desk object. 
     */
    public Desk getDesk()
    {
      return new Desk(desk);
    }

    /**
      setQuantity method. 
      @param quantity The quantity of desks. 
     */
    public void setQuantity(int quantity)
    {
      this.quantity = quantity;
    }

    /**
      getQuantity method. 
      @return The quantity of desks. 
     */
    public int getQuantity()
    {
      return quantity;
    }

    /**
      getCounter method. 
      @return The static counter to determine how many instances of the class were created. 
     */
    public int getCounter()
    {
      return counter;
    }

    /**
      The getDiscountedPrice method will calculate the discounted price of an order if a bulk
      order is placed. 
      @return The discounted price of an order. 
     */
    public double getDiscountedPrice()
    {
      final int CHERRY_THRESH = 10, OAK_THRESH = 12, PINE_THRESH = 15;
      final double DISCOUNT = 12.5;
      double discountedPrice = 0.0;

      //Calculating discount for Cherry.
      if(desk.getWood().equalsIgnoreCase("Cherry") && quantity > CHERRY_THRESH)
      {
        discountedPrice = desk.getReturnPrice() * (100 - DISCOUNT) / 100;
      }
      else
      {
        discountedPrice = desk.getReturnPrice();
      }

      //Calculating discount for Oak.
      if(desk.getWood().equalsIgnoreCase("Oak") && quantity > OAK_THRESH)
      {
        discountedPrice = desk.getReturnPrice() * (100 - DISCOUNT) / 100;
      }
      else
      {
        discountedPrice = desk.getReturnPrice();
      }

      //Calculating discount for Pine.
      if(desk.getWood().equalsIgnoreCase("Pine") && quantity > PINE_THRESH)
      {
        discountedPrice = desk.getReturnPrice() * (100 - DISCOUNT) / 100;
      }
      else
      {
        discountedPrice = desk.getReturnPrice();
      }

      return discountedPrice;
    }

    /**
      The getTotalCost method will caclulate the total cost of an order. 
      @return The total cost of an order. 
     */
    public double getTotalCost()
    {
      return getDiscountedPrice() * quantity;
    }

    /**
      toString method. 
      @return A String representing this class's attributes. 
     */
    public String toString()
    {
      String str = String.format(desk + "\nQuantity: " + quantity + "\nDiscounted Desk Price: $%,.2f \nTotal Order Cost: $%,.2f"
                                , getDiscountedPrice(), getTotalCost());

      return str;
    }
}
