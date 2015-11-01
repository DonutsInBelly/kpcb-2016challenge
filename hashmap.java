/**
 * @author carlin
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hashmap
{
	/**
	 * @param takes 1 String argument at runtime called "text".
	 * 		  This is the text file for input in the hash table.
	 * 		  Key Value pairs in the text file are done in this format:
	 * 		  key,value
	 * hashmap takes a text file. Reads it line by line and tokenizes each line.
	 * Each line is a key value pair and is put into the hashmap.
	 * The hashing function is just taking the String key and getting the hashCode() and taking the modulus of it
	 * After that, it takes the user into a menu to do manual functions like:
	 * Set
	 * Get
	 * Delete
	 * Load
	 */
    public static void main (String args[])
    {
    	if(args[0]==null)
    	{
    		System.out.println("Error:\nUsage: \"java hashmap [TEXT FILE]\"");
    		return;
    	}
    	System.out.println("What is the size of the table?");
    	Scanner scan = new Scanner(System.in);
    	String input = scan.next();
    	int size = Integer.parseInt(input);
    	Table hashMap = new Table(size);
    	System.out.println("Generating Hashmap based on textfile.....");
    	String text = args[0];
    	try
    	{
    		BufferedReader read = new BufferedReader(new FileReader(text));
    		String line;
    		while((line=read.readLine())!=null)
    		{
    			StringTokenizer tokens = new StringTokenizer(line,",");
    			String key=tokens.nextToken();
    			Object value=tokens.nextToken();
    			if(!(hashMap.set(key, value)))
    			{
    				System.out.println("Error: Value could not be stored.");
    				if(hashMap.load()>1.0)
    				{
    					System.out.println("Too many key value pairs in the text file. Please check your file.");
    					return;
    				}
    			}
    		}
    		while(input!="q")
    		{
    			System.out.println("Choose an action (Type \"q\" to exit)");
    			System.out.println("Options:\nSet\nGet\nDelete\nLoad");
    			input = scan.next();
    			switch(input)
    			{
    			case "set":
    				String key;
    				String value;
    				System.out.println("Please enter a key: ");
    				key=scan.next();
    				System.out.println("Please enter a value: ");
    				value=scan.next();
    				hashMap.set(key, value);
    				System.out.println("Value set: " + value);
    				System.out.println();
    				break;
    			case "get":
    				System.out.println("Please enter a key: ");
    				key=scan.next();
    				if(hashMap.get(key)==null)
    				{
    					System.out.println("Value not found");
    					System.out.println();
    				}
    				else
    				{
    					System.out.println("Value Found: " + hashMap.get(key));
    					System.out.println();
    				}
    				break;
    			case "delete":
    				System.out.println("Please enter a key: ");
    				key=scan.next();
    				if(hashMap.get(key)==null)
    				{
    					System.out.println("No Value associated with key");  
    					System.out.println();
    				}
    				else
    				{
    					System.out.println("Value deleted: " + hashMap.delete(key));
    					System.out.println();
    				}
    				break;
    			case "load":
    				System.out.println(hashMap.load());
    				System.out.println();
    				break;
    			case "q":
    				scan.close();
    				read.close();
    				return;
    			default:
    				System.out.println("Invalid Input. Please try again.");
    				System.out.println();
    				break;
    			}
    		}
    		scan.close();
    		read.close();
    		return;
    	}
    	catch(FileNotFoundException f)
    	{
    		System.out.println("File not found. Please try again.");
    		return;
    	}
    	catch(IOException i)
    	{
    		
    		return;
    	}
    	/*catch(Exception e)
    	{
    		System.out.println("Error. Please try again.");
    		return;
    	}*/
    }
}

/**
+      o     +              o   
    +             o     +       +
o          +
    o  +           +        +
+        o     o       +        o
-_-_-_-_-_-_-_,------,      o 
_-_-_-_-_-_-_-|   /\_/\  
-_-_-_-_-_-_-~|__( ^ .^)  +     +  
_-_-_-_-_-_-_-""  ""      
+      o         o   +       o
    +         +
o        o         o      o     +
    o           +
+      +     o        o      +    
*/
