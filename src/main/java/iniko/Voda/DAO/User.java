package iniko.Voda.DAO;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

@Entity
@Table( name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    private String Username;
    @NotNull
    private String Password;
    @NotNull
    private int Phone;
    private int Mobile;
    @NotNull
    private String Address;
    private Date ResistrationActive;
    private boolean IsActive;
    private boolean IsAdmin;
    private boolean IsPassenger;

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

    public void setResistrationActive() {
        Date dateOne = new Date();
        Instant inst = Instant.now();
        ResistrationActive = dateOne.from(inst);
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public boolean isAdmin() {
        return IsAdmin;
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getMobile() {
        return Mobile;
    }

    public void setMobile(int mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isPassenger() {
        return IsPassenger;
    }

    public void setPassenger(boolean passenger) {
        IsPassenger = passenger;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Phone=" + Phone +
                ", Mobile=" + Mobile +
                ", Address='" + Address + '\'' +
                ", ResistrationActive=" + ResistrationActive +
                ", IsActive=" + IsActive +
                ", IsAdmin=" + IsAdmin +
                ", IsPassenger=" + IsPassenger +
                '}';
    }
}
