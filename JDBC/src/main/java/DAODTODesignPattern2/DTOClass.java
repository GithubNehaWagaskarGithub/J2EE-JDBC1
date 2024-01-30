package DAODTODesignPattern2;

public class DTOClass {
    private int Id;
    private String Name;
    private String Div;
    private double Fees;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDiv() {
        return Div;
    }

    public void setDiv(String div) {
        Div = div;
    }

    public double getFees() {
        return Fees;
    }

    public void setFees(double fees) {
        Fees = fees;
    }
}
