package iniko.Voda.DAO;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Flight_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "airliner_id")
    private Airliner airliner;
    private String HomeAirport;
    private String DestinationAirport;
    private boolean HasMidlleStops;
    private int NumMidleStops;
    @OneToMany
    @JoinColumn(name = "MidleStops_id")
    private List<Airport> MidleStops;
    private int PassesngerDetails;

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    public Flight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomeAirport() {
        return HomeAirport;
    }

    public void setHomeAirport(String homeAirport) {
        HomeAirport = homeAirport;
    }

    public String getDestinationAirport() {
        return DestinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        DestinationAirport = destinationAirport;
    }

    public boolean isHasMidlleStops() {
        return HasMidlleStops;
    }

    public void setHasMidlleStops(boolean hasMidlleStops) {
        HasMidlleStops = hasMidlleStops;
    }

    public int getNumMidleStops() {
        return NumMidleStops;
    }

    public void setNumMidleStops(int numMidleStops) {
        NumMidleStops = numMidleStops;
    }

    public List<Airport> getMidleStops() {
        return MidleStops;
    }

    public void setMidleStops(List<Airport> midleStops) {
        MidleStops = midleStops;
    }

    public int getPassesngerDetails() {
        return PassesngerDetails;
    }

    public void setPassesngerDetails(int passesngerDetails) {
        PassesngerDetails = passesngerDetails;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airliner=" + airliner +
                ", HomeAirport='" + HomeAirport + '\'' +
                ", DestinationAirport='" + DestinationAirport + '\'' +
                ", HasMidlleStops=" + HasMidlleStops +
                ", NumMidleStops=" + NumMidleStops +
                ", MidleStops=" + MidleStops +
                ", PassesngerDetails=" + PassesngerDetails +
                '}';
    }
}
