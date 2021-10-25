

	class InvalidInput  extends Exception  
	{  
	    public InvalidInput (String str)  
	    {   
	        super(str);  
	    }  
	}
	
	class WrongPassword  extends Exception  
	{  
	    public WrongPassword (String str)  
	    {  
	        // calling the constructor of parent Exception  
	        super(str);  
	    }  
	}
	
	class TicketDoesntExist  extends Exception  
	{  
	    public TicketDoesntExist (String str)  
	    {  
	        // calling the constructor of parent Exception  
	        super(str);  
	    }  
	}
	class InputDoesntExist  extends Exception  
	{  
	    public InputDoesntExist  (String str)  
	    {  
	        // calling the constructor of parent Exception  
	        super(str);  
	    }  
	}
	
	class IndexOutofBound  extends Exception  
	{  
	    public IndexOutofBound  (String str)  
	    {  
	        // calling the constructor of parent Exception  
	        super(str);  
	    }  
	}
	
	class NullValueException extends Exception  
	{  
	    public NullValueException  (String str)  
	    {  
	        // calling the constructor of parent Exception  
	        super(str);  
	    }  
	}
	
	
	
