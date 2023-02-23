package iniko.Voda.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PassengerDetails")
public class PassengerDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PassengerDetail_id")
    private int id;
    @OneToOne
    @JoinColumn(name ="flight_id")
    private Flight flight;
    @OneToMany
    @JoinColumn(name = "passenger_id")
    private List<Passenger> passengers;
    private int PassegerOnBoard;
    private int PassengerMax;
    private int RemainigSeats;

    public PassengerDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getPassegerOnBoard() {
        return PassegerOnBoard;
    }

    public void setPassegerOnBoard(int passegerOnBoard) {
        PassegerOnBoard = passegerOnBoard;
    }

    public int getPassengerMax() {
        return PassengerMax;
    }

    public void setPassengerMax(int passengerMax) {
        PassengerMax = passengerMax;
    }

    public int getRemainigSeats() {
        return RemainigSeats;
    }

    public void setRemainigSeats(int remainigSeats) {
        RemainigSeats = remainigSeats;
    }

    @Override
    public String toString() {
        return "PassengerDetail{" +
                "id=" + id +
                ", flight=" + flight +
                ", passengers=" + passengers +
                ", PassegerOnBoard=" + PassegerOnBoard +
                ", PassengerMax=" + PassengerMax +
                ", RemainigSeats=" + RemainigSeats +
                '}';
    }
}
