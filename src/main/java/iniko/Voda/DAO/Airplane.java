package iniko.Voda.DAO;

import javax.persistence.*;

@Entity
@Table(name="Airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Airplane_id")
    private int id;
    @OneToOne
    @JoinColumn(name = "homeAirport_id")
    private Airport homeAirport;
    private String Type;
    private int Seats;
    private boolean OnService;
    private boolean Operational;

    public Airplane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Airport getHomeAirport() {
        return homeAirport;
    }

    public void setHomeAirport(Airport homeAirport) {
        this.homeAirport = homeAirport;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int seats) {
        Seats = seats;
    }

    public boolean isOnService() {
        return OnService;
    }

    public void setOnService(boolean onService) {
        OnService = onService;
    }

    public boolean isOperational() {
        return Operational;
    }

    public void setOperational(boolean operational) {
        Operational = operational;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", homeAirport=" + homeAirport +
                ", Type='" + Type + '\'' +
                ", Seats=" + Seats +
                ", OnService=" + OnService +
                ", Operational=" + Operational +
                '}';
    }
}
