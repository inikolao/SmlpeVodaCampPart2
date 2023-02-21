package iniko.Voda.DAO;


import javax.persistence.*;

@Entity
@Table( name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public String Username;
}
