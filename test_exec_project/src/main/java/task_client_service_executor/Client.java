package task_client_service_executor;

public class Client {
    private String name;
    private String surName;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (getAge() != client.getAge()) return false;
        if (getName() != null ? !getName().equals(client.getName()) : client.getName() != null) return false;
        return getSurName() != null ? getSurName().equals(client.getSurName()) : client.getSurName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurName() != null ? getSurName().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    public Client(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}
