package iniko.Voda.DAO;

import javax.persistence.*;

@Entity
@Table(name="Airliner")
public class Airliner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Airliner_id")
    private int id;
    private String Name;
    private int evaluation;

    public Airliner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Airliner{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", evaluation=" + evaluation +
                '}';
    }
}
