import javax.persistence.*;


@Entity
@Table(name = "person_details")
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "details", cascade = CascadeType.ALL)
    private Person person;

    public PersonDetails() {

    }

    public PersonDetails(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", email=" + email +
                '}';
    }
}
