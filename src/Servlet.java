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
import java.io.PrintWriter;

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
                Shift shift = new Shift();                                          //create Shift.java object link
                String add = request.getParameter("optionA");                       //get addition option from DOM
                int optionA = Integer.parseInt(add);
                shift.setEncryptShift(optionA);                                     //set addition key
                result = shift.encrypt(encrypt);                                    //performs encryption on text

            } else if (Objects.equals(radioSelect, "affine")) {                 //encrypt Affine
                Affine affine = new Affine();                                       //create Affine.java object link
                String mult = request.getParameter("optionA");                      //get multiplication option from DOM
                String add = request.getParameter("optionB");                       //get addition option from DOM
                int optionA = Integer.parseInt(mult);
                int optionB = Integer.parseInt(add);
                affine.setEncryptKeyOne(optionA);                                   //set multiplication key
                affine.setSecondKey(optionB);                                       //set addition key
                result = affine.encrypt(encrypt);                                   //performs encryption on text

            } else if (Objects.equals(radioSelect, "rsa")) {                    //encrypt RSA
                RSA rsa = new RSA();                                              //create Rsa.java object link
                result = rsa.encrypt(encrypt);

            } else {
                result = "error: no radio button selected";
            }
        }

        if (Objects.equals(encrypt, "")) {                                  //Decryption
            if (Objects.equals(radioSelect, "shift")) {                         //decrypt Shift
                Shift shift = new Shift();                                          //create Shift.java object link
                String add = request.getParameter("optionA");                       //get addition option from DOM
                int optionA = Integer.parseInt(add);
                shift.setEncryptShift(optionA);                                     //set addition key
                result = shift.decrypt(decrypt);                                    //performs encryption on text

            } else if (Objects.equals(radioSelect, "affine")) {                 //decrypt Affine
                Affine affine = new Affine();
                String mult = request.getParameter("optionA");                      //get multiplication option from DOM
                String add = request.getParameter("optionB");                       //get addition option from DOM
                int optionA = Integer.parseInt(mult);
                int optionB = Integer.parseInt(add);
                affine.setEncryptKeyOne(optionA);                                   //set multiplication key
                affine.setSecondKey(optionB);                                       //set addition key
                result = affine.decrypt(decrypt);                                   //perform encryption on text

            } else if (Objects.equals(radioSelect, "rsa")) {                    //decrypt RSA
                RSA rsa = new RSA();                                              //create Rsa.java object link
                result = rsa.decrypt(decrypt);                                    //create Rsa.java object link

            } else {
                result = "error: no radio button selected";
            }

        }


        //reply back to server
//        response.setContentType("text/plain");
        response.getWriter().write(result);                             //sends encrypted text back to DOM

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
