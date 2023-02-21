package iniko.Voda.DAO;


import javax.persistence.*;

@Entity
@Table( name = "Flights")
public class flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
