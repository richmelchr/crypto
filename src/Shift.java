public class Shift {
    int encryptShift;
    int module;

    Shift() {
        encryptShift = 5;
        module = 26;
    }

    public String encrypt(String inputString) {
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char letter = (char) (inputString.charAt(i) + encryptShift);

            if (Character.isLetter(letter)) {
                if (letter > 'z') {
                    letter = (char) ((letter - (module - encryptShift)));
                }
            } else {
                letter = (char) ((letter + encryptShift));
            }
            encryptedString.append(letter);
        }
        return encryptedString.toString();
    }

    public String decrypt(String inputString) {
        StringBuilder decryptedString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char letter = (char) (inputString.charAt(i) - encryptShift);
            if (Character.isLetter(letter)) {
                if (letter > 'z') {
                    letter = (char) ((letter + (module - encryptShift)));
                }
            } else {
                letter = (char) ((letter - encryptShift));
            }
            decryptedString.append(letter);
        }
        return decryptedString.toString();
    }

    public int getEncryptShift() {
        return encryptShift;
    }

    public void setEncryptShift(int encryptShift) {
        if (encryptShift % 2 != 0) {
            this.encryptShift = encryptShift;
        } else {
            this.encryptShift = (encryptShift + 1);
        }
    }

}

