package ua.kapchamiroso.project.webapp;

public class UserData {
    private String login;
    public UserData() { }

    public UserData(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "login='" + login + '\'' +
                '}';
    }
}
