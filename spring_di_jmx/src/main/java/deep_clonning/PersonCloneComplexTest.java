package deep_clonning;

public class PersonCloneComplexTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("Name", 12);
        Person clone = (Person) person.clone();
        System.out.println(clone == person);
        System.out.printf(
                "originalUser: %s, cloneUser: %s", person, clone);
        System.out.println();
        clone.getCompany().setCompanyName("yyy");

        System.out.printf(
                "originalUser: %s, cloneUser: %s", person, clone);

    }
}
