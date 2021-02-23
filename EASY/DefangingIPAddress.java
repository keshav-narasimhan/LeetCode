/*
 * EASY 2/23/2021
 */
public class DefangingIPAddress 
{
	public String defangIPaddr(String address) {
        
        /*
        ONE WAY TO DO:
        
        String defang = "[.]";
        String output = "";
        
        for (int a = 0; a < address.length(); a++)
        {
            if (address.charAt(a) == '.')
            {
                output += defang;
            }
            else
            {
                output += address.charAt(a);
            }
        }
        
        return output;
        */
        
        // FASTER WAY:
        return address.replace(".", "[.]");
    }
}
