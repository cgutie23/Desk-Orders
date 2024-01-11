
public class Desk 
{
    private String wood; //The type of wood.
    private int drawers; //The number of drawers

    /**
      No-arg constructor. 
     */
    public Desk()
    {
      wood = " ";
      drawers = 0;
    }

    /**
      Constructor. 
      @param wood The type of wood. 
      @param drawers The amount of drawers. 
     */
    public Desk(String wood, int drawers)
    {
      this.wood = wood;
      this.drawers = drawers;
    }

    /**
      Copy Constructor. 
      @param obj The object to copy from. 
     */
    public Desk(Desk obj)
    {
      wood = obj.wood;
      drawers = obj.drawers;
    }

    /**
      setWood method.
      @param wood The type of wood. 
     */
    public void setWood(String wood)
    {
      this.wood = wood;
    }
    
    /**
      getWood method. 
      @return The type of wood.
     */
    public String getWood()
    {
      return wood;
    }

    /**
      setDrawers method. 
      @param drawers The amount of drawers. 
     */
    public void setDrawers(int drawers)
    {
      this.drawers = drawers;
    }

    /**
      getDrawers method.
      @return The amount of drawers. 
     */
    public int getDrawers()
    {
      return drawers;
    }

    /**
      The getReturnPrice method will calculate the return price of a desk based
      on it's wood and it's amount of drawers. 
      @return The return price of the desk. 
     */
    public double getReturnPrice()
    {
      double basePrice = 0.0, additionalPrice = 0.0;
      final int LOW_THRESH = 3; //Thresholds for the amount of drawers.
      
      //Base prices based on the type of wood.
      final double CHERRY_BASE = 575.0, OAK_BASE = 425.0, PINE_BASE = 250.0;
      
      //Additional prices based on wood and amount of drawers.
      final double CHERRY_2 = 65.75, CHERRY_6 = 61.5, OAK_2 = 55.40, OAK_6 = 52.85,
                    PINE_2 = 45.15, PINE_6 = 43.25;

      //Calculating prices for Cherry.              
      if(wood.equalsIgnoreCase("Cherry"))
      {
        basePrice = CHERRY_BASE;
        
        if(drawers < LOW_THRESH)
        {
          additionalPrice = CHERRY_2;
        }
        else
        {
          additionalPrice = CHERRY_6;
        }
      }

      //Calculating prices for Oak.
      if(wood.equalsIgnoreCase("Oak"))
      {
        basePrice = OAK_BASE;
        
        if(drawers < LOW_THRESH)
        {
          additionalPrice = OAK_2;
        }
        else
        {
          additionalPrice = OAK_6;
        }
      }

      //Calculating prices for Pine.
      if(wood.equalsIgnoreCase("Pine"))
      {
        basePrice = PINE_BASE;
        
        if(drawers < LOW_THRESH)
        {
          additionalPrice = PINE_2;
        }
        else
        {
          additionalPrice = PINE_6;
        }
      }

      return basePrice + drawers * additionalPrice;
    }

    /**
      toString method. 
      @return a String representing the class's attributes. 
     */
    public String toString()
    {
      String str = String.format("\nType of wood: %s \nNumber of drawers: %d \nRegular Price: $%,.2f",
                                  wood, drawers, getReturnPrice());
      return str;
    }
}
