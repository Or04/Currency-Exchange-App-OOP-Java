package currency;

public class CoinCurrency {
    private String name;
    private String country;
    private String currencyCode;
    private int unit;
    private double rate;
    private double change;

    public CoinCurrency(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    @Override
    public String toString() {
        String str = System.lineSeparator()+name+System.lineSeparator()+country+System.lineSeparator()+currencyCode+System.lineSeparator()+unit+System.lineSeparator()+rate+System.lineSeparator()+change+System.lineSeparator();
        return str ;
    }
}
