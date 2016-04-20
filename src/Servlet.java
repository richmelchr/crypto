import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.String;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "";

        String radioSelect = request.getParameter("radioSelect").trim();    //get selected radio button from DOM
        String encrypt = request.getParameter("encryptText").trim();        //gets encrypt text from DOM
        String decrypt = request.getParameter("decryptText").trim();        //gets decrypt text from DOM


        if (Objects.equals(decrypt, "")) {                                  //Encryption
            if (Objects.equals(radioSelect, "shift")) {                         //encrypt Shift
                //Shift shift = new Shift();                                        //create Shift.java object link
                //performs encryption on text

            } else if (Objects.equals(radioSelect, "affine")) {                 //encrypt Affine
                Affine affine = new Affine();                                       //create Affine.java object link
                String mult = request.getParameter("optionA").trim();               //get multiplication option from DOM
                String add = request.getParameter("optionB").trim();                //get addition option from DOM
                int optionA = Integer.parseInt(mult);
                int optionB = Integer.parseInt(add);
                affine.setEncryptKeyOne(optionA);                                   //set multiplication key
                affine.setSecondKey(optionB);                                       //set addition key
                result = affine.encrypt(encrypt);                                   //performs encryption on text

            } else if (Objects.equals(radioSelect, "rsa")) {                    //encrypt RSA
                //Rsa rsa = new Rsa();                                              //create Rsa.java object link
                //performs encryption on text

            } else {
                result = "error: no radio button selected";
            }
        }

        if (Objects.equals(encrypt, "")) {                                  //Decryption
            Affine affine = new Affine();
            result = affine.decrypt(decrypt);
        }


        //reply back to server
        response.setContentType("text/plain");
        response.getWriter().write(result);                             //sends encrypted text back to DOM

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
