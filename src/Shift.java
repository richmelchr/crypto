import java.math.BigInteger;

public class Shift 
{
	int encryptionShift;
	int decryptionShift;
	int module;
	
	Shift ()
	{
		encryptionShift = 5;
		decryptionShift = 5;
		module = 26;
	}
	
	
	
	public String encrypt(String inputString)
	{
		StringBuilder encryptedString = new StringBuilder();
	    for (int i = 0; i < inputString.length(); i++) 
	    {
	        char letter = (char)(inputString.charAt(i)+encryptionShift);
	        if (Character.isLetter(letter)) 
	        if(letter > 'z')
	        {
	            letter = (char)((letter - (module-encryptionShift)));
	        }
	        else
	        {
				letter = (char)((letter + encryptionShift));
			}
	        encryptedString.append(letter);
	    }
	    return encryptedString.toString();
    }
	
	
	public String decrypt(String inputString)
	{
	    StringBuilder decryptedString = new StringBuilder();
	    
		for (int i = 0; i < inputString.length(); i++) 
	    {
	        char letter = inputString.charAt(i);
	        if (Character.isLetter(letter)) 
	        	        if(letter > 'z')
	        {
	            letter = (char)((letter + (module-decryptionShift)));
	        }
	        else
	        {
				letter = (char)((letter - decryptionShift));
			}
	    }
	    return decryptedString.toString();
	}
	
	
	public void setEncryptionShift(int encryptionShift)
	{
		if(encryptionShift % 2 !=0)
			this.encryptionShift = encryptionShift;
		else
			this.encryptionShift = (encryptionShift+1);
	}
	
	
	public void setDecryptionShift(int decryptionShift)
	{
		if(decryptionShift % 2 !=0)
			this.decryptionShift = decryptionShift;
		else
			this.decryptionShift = (decryptionShift+1);
	}
	
	public int getEncryptionShift()
	{
		return encryptionShift;
	}
	
	
	public int getDecryptionShift()
	{
		return decryptionShift;
	}
	
}
