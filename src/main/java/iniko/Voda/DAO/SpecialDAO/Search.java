package iniko.Voda.DAO.SpecialDAO;

import iniko.Voda.DAO.SpecialDAO.Enums.TravelClass;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Search implements Serializable {

    private String AirportFrom;
    private String AirporTo;
    private Date DepDate;
    private Date RetDate;
    private int PassengerNo;
    private int ChildNo;
    private TravelClass travelClass;

    private int SumPassengers;

    public Search() {
    }

    public Search(String airportFrom, String airporTo, Date depDate, Date retDate, int passengerNo, int childNo, TravelClass travelClass) {
        AirportFrom = airportFrom;
        AirporTo = airporTo;
        DepDate = depDate;
        RetDate = retDate;
        PassengerNo = passengerNo;
        ChildNo = childNo;
        this.travelClass = travelClass;
        SumPassengers=childNo+passengerNo;
    }

    public String getAirportFrom() {
        return AirportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        AirportFrom = airportFrom;
    }

    public String getAirporTo() {
        return AirporTo;
    }

    public void setAirporTo(String airporTo) {
        AirporTo = airporTo;
    }

    public Date getDepDate() {
        return DepDate;
    }

    public void setDepDate(Date depDate) {
        DepDate = depDate;
    }

    public Date getRetDate() {
        return RetDate;
    }

    public void setRetDate(Date retDate) {
        RetDate = retDate;
    }

    public int getPassengerNo() {
        return PassengerNo;
    }

    public void setPassengerNo(int passengerNo) {
        PassengerNo = passengerNo;
    }

    public int getChildNo() {
        return ChildNo;
    }

    public void setChildNo(int childNo) {
        ChildNo = childNo;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public int getSumPassengers() {
        return SumPassengers;
    }

    @Override
    public String toString() {
        return "Search{" +
                "AirportFrom='" + AirportFrom + '\'' +
                ", AirporTo='" + AirporTo + '\'' +
                ", DepDate=" + DepDate +
                ", RetDate=" + RetDate +
                ", PassengerNo=" + PassengerNo +
                ", ChildNo=" + ChildNo +
                ", travelClass=" + travelClass +
                ", SumPassengers=" + SumPassengers +
                '}';
    }
}
