package iniko.Voda.DAO;


import javax.persistence.*;

@Entity
@Table(name = "Airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Airport_id")
    private int id;
    private String AirportName;
    private String Type;

    public Airport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", AirportName='" + AirportName + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
