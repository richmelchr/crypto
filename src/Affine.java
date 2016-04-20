import java.math.BigInteger;
/**
 * This is the main encrypt/decrypt class. You should be able to just interface it into your code
 * however you need to. I put setters in case you wanted to make a drop box and connect it to your UI
 * to allow the user to be able to set the encrypt/decrypt keys. If not, then its default is simply a 5/25
 * key code.
 *
 * If you need to change the output or make any tweaks, either let me know, or feel free to go ahead.
 */
public class Affine {
    int encryptKeyOne;
    int encryptKeyTwo;
    int module;
    /**
     * default values for constructor
     */
    Affine()
    {
        encryptKeyOne = 5;
        encryptKeyTwo = 25;
        module = 26;
    }
    /**
     * This is the main encrypt class, simply feed it a string and it will do the rest.
     * @param inputString
     * @return the encrypted string
     */
    public String encrypt(String inputString)
    {
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++)
        {
            char letter = inputString.charAt(i);
            if (Character.isLetter(letter))
            {
                letter = (char) ((encryptKeyOne * (letter - 'a') + encryptKeyTwo) % module + 'a');
            }
            encryptedString.append(letter);
        }
        return encryptedString.toString();
    }
    /**
     * this is the main decryption class, again just send it the input and its output will be done.
     * @param inputString
     * @return
     */
    public String decrypt(String inputString)
    {
        StringBuilder decryptedString = new StringBuilder();
        BigInteger inverse = BigInteger.valueOf(encryptKeyOne).modInverse(BigInteger.valueOf(module));
        for (int i = 0; i < inputString.length(); i++)
        {
            char letter = inputString.charAt(i);
            if (Character.isLetter(letter))
            {
                int decoded = inverse.intValue() * (letter - 'a' - encryptKeyTwo + module);
                letter = (char) (decoded % module + 'a');
            }
            decryptedString.append(letter);
        }
        return decryptedString.toString();
    }
    /**
     * This is where you are going to have to hook up a drop down box or however
     * you want the user to set the input. Right now, it makes sure that the first key
     * will never be even, so you can leave it like this or just make your user input connect
     * to this and not even give them the option. (i.e. 1,3,5...)
     *
     * @param encryptKeyOne
     */
    public void setEncryptKeyOne(int encryptKeyOne)
    {
        if(encryptKeyOne % 2 !=0)
            this.encryptKeyOne = encryptKeyOne;
        else
            this.encryptKeyOne = (encryptKeyOne+1);
    }
    /**
     * This is the second key, you can connect interface the setter however you want.
     * @param secondKey
     */
    public void setSecondKey(int secondKey)
    {
        this.encryptKeyTwo = secondKey;
    }


    //-------------------------------------------------------------------------------------------------------


    /**
     * This is the module setter, i'm not sure why you would want to change this, but if needed
     * you can use it to set a different value other that 26.
     * @param module
     */
    public void setModule(int module)
    {
        this.module = module;
    }
    /**
     * getter section in case your UI will need this for interfacing. If not, feel free to delete.
     */
    public int getEncryptKeyOne()
    {
        return encryptKeyOne;
    }

    public int getModule()
    {
        return module;
    }

    public int getSecondKey()
    {
        return encryptKeyTwo;
    }



}
