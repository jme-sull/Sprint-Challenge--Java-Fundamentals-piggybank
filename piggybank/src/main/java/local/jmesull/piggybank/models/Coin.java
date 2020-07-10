package local.jmesull.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin
{
    //coinid, name, namepural, value, quantity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long coinid;
    String name;
    String namepural;
    double value;
    int quantity;

    //constructor
    public Coin(
        String name,
        String namepural,
        double value,
        int quantity)
    {
        this.name = name;
        this.namepural = namepural;
        this.value = value;
        this.quantity = quantity;
    }

    //default constructor
    public Coin()
    {
    }

    //getters and setters

    public long getCoinid()
    {
        return coinid;
    }

    public void setCoinid(long coinid)
    {
        this.coinid = coinid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNamepural()
    {
        return namepural;
    }

    public void setNamepural(String namepural)
    {
        this.namepural = namepural;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    //toString

    @Override
    public String toString()
    {
        return "Coin{" +
            "coinid=" + coinid +
            ", name='" + name + '\'' +
            ", namepural='" + namepural + '\'' +
            ", value=" + value +
            ", quantity=" + quantity +
            '}';
    }
}
