/* 
This program assumes the user knows the public key/modulus when encrypting or private key/modulus when decrypting (which means this needs to be an input that they give us Im not sure how you want to implement that)
It takes the message one character at a time converts it to ascii value apples the public/private key and modulus then converts the character back and replaces the character within the message
The final message would be stored in message
*/
import java.math.BigInteger;
import java.io.*;
import java.lang.StringBuilder;

/*
public class RSA
{
	BigInteger key = 0;	//Initializes Inputs
	BigInteger modulus = 0;
	BigInteger ascii = 0;
	char chara = 'a';
	int i;
	int len;
	
	InputStreamReader isr = new InputStreamReader (System.in);
       	BufferedReader br = new BufferedReader (isr);

	String message = br.readLine ();	//Gets values from user
	key = br.readline ();
	modulus = br.readline ();
	
	for(i = 0, len = message.length(); i < len; i++)
	{
		chara = message.charAt(i);	//Does conversion
		ascii = (int) chara;
		ascii.modPow(key, modulus);
		chara = (char)ascii;
		setCharAt(i, chara);
	}	
	
}
*/