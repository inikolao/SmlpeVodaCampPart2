package iniko.Voda.DAO;

import jdk.jfr.Relational;

import javax.persistence.*;

@Entity
@Table( name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private flight flight;


    public iniko.Voda.DAO.flight getFlight() {
        return flight;
    }

    public void setFlight(iniko.Voda.DAO.flight flight) {
        this.flight = flight;
    }
}
