import java.math.BigInteger;

public class RSA {
    BigInteger publicKey;
    BigInteger privateKey;
    BigInteger modulus;

    RSA () {
        publicKey = new BigInteger("5");
        privateKey = new BigInteger("11");
        modulus = new BigInteger("14");
    }

    public String encrypt(String inputString) {
        StringBuilder encryptedString = new StringBuilder();

        for (int i=0; i < inputString.length(); i++)
        {
            char letter = inputString.charAt(i);
            BigInteger some = new BigInteger("112");
            if (Character.isLetter(letter))
            {
                BigInteger newStuff = BigInteger.valueOf((int) letter);
                some = newStuff.modPow(publicKey, privateKey);
            }
            int something = some.intValue();
            char finished = ((char) something);
            encryptedString.append(finished);
        }
        return encryptedString.toString();
    }


    public String decrypt(String inputString) {
        StringBuilder decryptedString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++)
        {
            char letter = inputString.charAt(i);
            BigInteger some = BigInteger.valueOf(0);
            if (Character.isLetter(letter))
            {
                BigInteger newStuff;
                newStuff = BigInteger.valueOf((int) letter);
                some = newStuff.modPow(publicKey, modulus);
            }
            int something = some.intValue();
            char finished = ((char) something);
            decryptedString.append(finished);
        }
        return decryptedString.toString();
    }

    public void setPublicKey(int publicKey) {
        this.publicKey = BigInteger.valueOf(publicKey);
    }

    public void setPrivateKey(int privateKey) {
        this.privateKey = BigInteger.valueOf(privateKey);
    }

    public void setModulus(int modulus) {
        this.modulus = BigInteger.valueOf(modulus);
    }
/*
    public int getPublicKey() {return PublicKey;}
    public int getPrivateKey() {return PrivateKey;}
    public int getModulus() {return Modulus;}
*/
}
