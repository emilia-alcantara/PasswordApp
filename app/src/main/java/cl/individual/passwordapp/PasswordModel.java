package cl.individual.passwordapp;

public class PasswordModel {
    public static final int ERROR = -1;
    public static final int DEBIL = 0;
    public static final int MEDIO = 1;
    public static final int FUERTE = 2;


    public int validarClave(String password) {

        if (password.isEmpty()) {
            return ERROR;
        } else if (password.length() < 5) {
            return DEBIL;
        } else if (password.equals(password.toLowerCase())) {
            return MEDIO;
        } else {
            return FUERTE;
        }

    }
}
