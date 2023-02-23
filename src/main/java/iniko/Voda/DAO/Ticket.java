package iniko.Voda.DAO;

import jdk.jfr.Relational;

import javax.persistence.*;
import java.util.Date;

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
    private Date dateIssued;
    private boolean isValid;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private Passenger owner;

    public Ticket() {
    }

    public iniko.Voda.DAO.Flight getFlight() {
        return flight;
    }

    public void setFlight(iniko.Voda.DAO.Flight flight) {
        this.flight = flight;
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

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Passenger getOwner() {
        return owner;
    }

    public void setOwner(Passenger owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", flight=" + flight +
                ", dateIssued=" + dateIssued +
                ", isValid=" + isValid +
                ", owner=" + owner +
                '}';
    }
}
