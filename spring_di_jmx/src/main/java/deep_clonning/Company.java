package deep_clonning;

public class Company implements Cloneable {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public Company clone() throws CloneNotSupportedException {
        return (Company) super.clone();
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
