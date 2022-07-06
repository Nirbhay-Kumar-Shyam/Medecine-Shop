
import java.util.Scanner;
import java.util.HashMap;
//this is a class of entity
class Entity
{
	HashMap<Integer, String> Mh = new HashMap<Integer, String>();
	public String name = "Unknown Person";
	public int id = 0;
	int zipCodeCustomer=-1;
	int zipCodeShop=-2;
	int zipCodeDeliveryBoy=-3;
	int noOfOrder = -1;
	public Entity(Scanner myObj)
	{
		//Here I taken ID of each entity;
		System.out.println("Enter the ID no.");
		this.id = myObj.nextInt();
		System.out.println("Enter the name:");
	    Mh.put(this.id,myObj.nextLine());
	    Mh.put(this.id,myObj.nextLine());
		
	}
	void printout()
	{
		for(Integer I: Mh.keySet())
		{
			System.out.println("Name:"+Mh.get(I));
			System.out.println("ID No.:"+I);
		}	
	}
	
	void addProduct(int Id, Scanner myObj) {};
	void addOrder(int Id, Scanner myObj) {};
	int processOrder(Scanner myObj)
	{
		return 0;
	};

}




class Manufacturer extends Entity{
	HashMap<Integer, String> Mh1 = new HashMap<Integer, String>();

	int i=1;
	public Manufacturer(Scanner myObj)
	{
		super(myObj);
		System.out.println("Enter The product of Manufactrur manufactur if its over Enter 'quit' :");
		Mh1.put(i, myObj.nextLine());
        while(!Mh1.get(i).equals("quit"))
        {
        	i++;
        	Mh1.put(i, myObj.nextLine());
        }
        Mh1.remove(i);
    
	}
//Add a product to manufacturer	
void addProduct(int Id, Scanner myObj)
{
	super.addProduct(Id,myObj);
	
	System.out.println("If adding is over Enter quit");
	myObj.nextLine();
	while(!Mh1.get(i-1).equals("quit"))
	{
	 Mh1.put(i, myObj.nextLine());
	 i++;
	}
	Mh1.remove(i);
}
void printout()
{
	super.printout();
	
	System.out.println("####### Manufacturer List ########");
	
	for(Integer e : Mh1.keySet())
    {
		System.out.println(Mh1.get(e));
	}
}

}






class Customer extends Entity{
	HashMap<String, Integer> Mh2 = new HashMap<String, Integer>();
	int i=0;
	
	String Obj;
	public Customer(Scanner myObj)
	{
		super(myObj);
		System.out.println("Enter the Zip Code of Customer :");
		zipCodeCustomer = myObj.nextInt();
	
	}
	@Override	
	
	void addOrder(int Id, Scanner myObj)
	{
		super.addOrder(Id,myObj);
		myObj.nextLine();
		System.out.println("Enter Product name :");
		String Product = myObj.nextLine();
		System.out.println("Enter no. of product you want to buy :");
		int productCount = myObj.nextInt();
		 Mh2.put(Product, productCount);
	
	}
	void printout()
	{
		super.printout();
		
		System.out.println("####### Shoping List ########");
		
		for(String e : Mh2.keySet())
	    {
			System.out.println(e+"            "+Mh2.get(e));
		}
    }
}
	
class ShopsAndWarehouses extends Entity{
	HashMap<String, Integer> Mh2 = new HashMap<String, Integer>();
	
	int i=0;
	String Obj;
	public ShopsAndWarehouses(Scanner myObj)
	{
		super(myObj);
		System.out.println("Enter the Zip Code of Shop :");
		zipCodeShop= myObj.nextInt();
		int exit = 1;
		while(exit != 0)
        {
			myObj.nextLine();
			System.out.println("Enter the name of products");
			Obj = myObj.nextLine();
			System.out.println("Enter the no. of products");
        	i = myObj.nextInt();
        	
        	Mh2.put(Obj, i);
        	System.out.println("Press 1 to add more product else 0");
        	exit = myObj.nextInt();
        	
        }
		
	}
	@Override	
	void printout()
	{
		super.printout();
		System.out.println("####### Shops Products List ########");
		
		for(String e : Mh2.keySet())
	    {
			System.out.println(e+"            "+Mh2.get(e));
		}
    }
	void addProduct(int Id, Scanner myObj)
	{
		super.addProduct(Id,myObj);
		
		
		myObj.nextLine();	
		System.out.println("Enter Product name :");
		String Product = myObj.nextLine();
		System.out.println("Enter no. of new products :");
		int productCount = myObj.nextInt();
		for(String e : Mh2.keySet())
	    {
	     if(e.equals(Product))
	     {
	    	 Mh2.put(Product, Mh2.get(e)+productCount);
	    	 return;
	     }
	    }
		Mh2.put(Product, productCount);
	}
	@Override	
	int processOrder(Scanner myObj)
	{
		super.processOrder(myObj);
		int flag = 0;
		System.out.println("Enter the name of product");
		String myOrder = myObj.nextLine();
		for(String e : Mh2.keySet())
	    {
			if(e.equals(myOrder))
			{
				flag = 1;
			}
		}
		return flag;
	}
}


class DeliveryAgent extends Entity{
	HashMap<Integer, Integer> Mh4 = new HashMap<>();
	
	
	public DeliveryAgent(Scanner myObj)
	{
		super(myObj);
		System.out.println("Enter the Zip Code");
		zipCodeDeliveryBoy = myObj.nextInt();
		System.out.println("Enter the no. of products you delivered");
		noOfOrder = myObj.nextInt();
		Mh4.put(zipCodeDeliveryBoy, noOfOrder);
	}	
}

	
public class MedicineShop {
	public static void main(String [] args)
	{
		Scanner myObj = new Scanner(System.in);
		Entity E[]= new Entity[5];
		
		int key = -1;
		int n =0;
		int i=0;
		
		while(key != 0)
		{
		System.out.println("Press 1 for Create Entity");
		System.out.println("Press 2 for Print Entity");
		System.out.println("Press 3 for Delete Entity");
		System.out.println("Press 4 for add product to Manufacturer");
		System.out.println("press 5 to update no. of copies of product to shop");
		System.out.println("press 6 for the list of Inventry of Shop");
		System.out.println("press 7 to Order a product");
		System.out.println("press 8 to get products made by manufacturer");
		System.out.println("press 9 to get list of all purcheses made by a customer");
		key = myObj.nextInt();
        switch(key)
        {
        case 1:
        {
    			E[i] = CreateEntity(myObj);
    			i++;
    			n = i;
    		break;
        }
        case 2:
        {
        	int temp =0;
        	for(int j=0; j<n; j++)
    		{
        		if(E[j] == null)continue;
    			E[j].printout();
    			temp = 1;
    		}
        	if(temp == 0)
        	{
        		System.out.println("### No data abvlable ###");
        	}
        	break;
        }
        case 3:
        {
        	for(int j=0; j<n; j++)
    		{
        		E[j].printout();
    		}
        	System.out.println("Enter the ID of Entity");
		    int ID = myObj.nextInt();
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{
					E[j] = null;
			     }    		    
		     }
        }
        case 4:
        {
        	System.out.println("Enter the ID of Manufacturer");
		    int ID = myObj.nextInt();
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{
					E[j].addProduct(ID, myObj);

			     }    		    
		     }
		    break;
         }
        case 5:
        {
        	System.out.println("Enter the ID of Shop");
		    int ID = myObj.nextInt();
		    int temp = 0;
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{
					E[j].addProduct(ID, myObj);
					temp = 1;
			     }    		    
		     }
		    if(temp == 0)
		    {
		    	System.out.println("No any shop found with this ID found");
		    }
        	break;
        }
        case 6:
        {
        	System.out.println("Enter the ID of Shop");
		    int ID = myObj.nextInt();
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{
					E[j].printout();
			     }    		    
		     }
        	 break;
        }
        case 7:
        {
        	System.out.println("Enter Customer ID ");
		    int ID = myObj.nextInt();
		    int temp = 0;
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{ 
					E[j].addOrder(ID, myObj);
					myObj.nextLine();
					System.out.println("Do you want to process it ?");
					System.out.println("if yes then enter 'Y'");
					System.out.println("if not then enter 'N'");
					
					String Confirmation = myObj.nextLine();
					if(Confirmation.equals("Y"))
					{
						
						for(int k=0; k<n; k++)
						{
							  if(E[k] == null)continue;
							  if(E[j].zipCodeCustomer == E[k].zipCodeShop)
							  { 
								 int checkList=0;
								 checkList = E[k].processOrder(myObj);
							      if(checkList == 1)
							      {
							    	  System.out.println("Your Order is Successful");
							    	  int min = 100000;
							  		int deliveryBoy = 0;
							  		for(int m=0; m<n; m++)
							  	    {
							  			if(E[m] == null)continue;
							  			if(E[m].noOfOrder == -1)continue;
							  			if(min > E[m].noOfOrder)
							  			{
							  				min = E[m].noOfOrder;
							  				deliveryBoy = E[m].zipCodeDeliveryBoy;
							  			}
							  		}
							  		System.out.println("Your Delivery Agent zipCode is "+deliveryBoy);
							      }
							      else
							      {
							    	  System.out.println("Sorry your Order can't be Deleverd");
							      }
						    }
					   }
					}
					else 
					{
						System.out.println("Your order declined");
					}
				 
			     temp = 1;
		     }
		    if(temp == 0)
		    {
		    	System.out.println("your ID is not found, first register it");
		    }
		  }
		    break;
       }
        case 8:
        {
        	System.out.println("Enter the ID of Manufacturer");
		    int ID = myObj.nextInt();
		    int temp = 0;
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{
					E[j].printout();
					temp = 1;
			     }    		    
		     }
		    if(temp == 0)
		    {
		    	System.out.println("No any manufacturer found with this ID");
		    }
        	break;
        }
        case 9:
        {
        	System.out.println("Enter the ID of Customer");
		    int ID = myObj.nextInt();
		    int temp = 0;
		    for(int j=0; j<n; j++)
			{
		    	if(E[j] == null)continue;
				if(ID == E[j].id)
				{
					E[j].printout();
					temp = 1;
			     }    		    
		     }
		    if(temp == 0)
		    {
		    	System.out.println("No any customer found with this ID");
		    }
        	break;
        }
      }
   }
}
        
	
static Entity CreateEntity(Scanner myObj)
	{
		System.out.println("Enter the ID of Entity to Create");
		System.out.println("ID    Names");
		System.out.println(" 1    Manufacturer");
		System.out.println(" 2    Customer");
		System.out.println(" 3    Shops and warehouses");
		System.out.println(" 4    Delivery agent");
		System.out.println("Enter the type: ");
		int myType = myObj.nextInt();
		if(myType == 1)return new Manufacturer(myObj);
		if(myType == 2)return new Customer(myObj);
		if(myType == 3)return new ShopsAndWarehouses(myObj);
		if(myType == 4)return new DeliveryAgent(myObj);
		return null;
	}
}
