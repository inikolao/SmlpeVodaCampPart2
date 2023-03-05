package iniko.Voda.DAO;

import jdk.jfr.Relational;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

@Entity
@Table( name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ticket_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    private int price;
    private String seat;
    private Date dateIssued;
    private boolean isValid;
    @OneToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Ticket() {
    }

    public iniko.Voda.DAO.Flight getFlight() {
        return flight;
    }

    public void setFlight(iniko.Voda.DAO.Flight flight) {
        this.flight = flight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public void setDateIssued()
    {
        Date dateOne = new Date();
        Instant inst = Instant.now();
        this.dateIssued = dateOne.from(inst);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat() {
        this.seat = GenRandomString();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", flight=" + flight +
                ", price=" + price +
                ", seat='" + seat + '\'' +
                ", dateIssued=" + dateIssued +
                ", isValid=" + isValid +
                ", passenger=" + passenger +
                '}';
    }

    private String GenRandomString()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 2;
        Random random = new Random();

        return (random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }
}
