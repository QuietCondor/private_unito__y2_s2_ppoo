// Rappresenta il nome di una persona
public class Person {
    private String firstName; // nome
    private String lastName; // cognome

    // costruttore
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // metodi get
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    // ritorna una rappresentazione testuale dell'oggetto
    public String toString() {
        return "<" + this.firstName + "," + this.lastName + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person) obj;

        return this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName);
    }
}
