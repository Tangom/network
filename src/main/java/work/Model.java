package work;

import javax.persistence.*;

@Entity
@Table(name = "Contacts")
public class Model {
    @Id
    @Column (nullable = false,unique = true)
    private String login;
    @Column(nullable = false)
    private String name;

    public Model() {
    }
    public Model(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (login != null ? !login.equals(model.login) : model.login != null) return false;
        return name != null ? name.equals(model.name) : model.name == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
