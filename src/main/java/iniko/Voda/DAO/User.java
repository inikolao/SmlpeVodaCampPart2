package iniko.Voda.DAO;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    public String Username;
    @NotNull
    public String Password;
    public Date ResistrationActive;
    public boolean IsActive;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getResistrationActive() {
        return ResistrationActive;
    }

    public void setResistrationActive(Date resistrationActive) {
        ResistrationActive = resistrationActive;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", ResistrationActive=" + ResistrationActive +
                ", IsActive=" + IsActive +
                '}';
    }
}
