package entidad;

public class Login {

    private final static String USERNAME = "user";
    private final static String PASSWORD = "1234";

    private Login() {
    }

    public static boolean isLogged(String user, String pass) {
        return user.equals(USERNAME) && pass.equals(PASSWORD);
    }
}
