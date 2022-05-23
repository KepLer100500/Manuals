import javax.persistence.*;

@Entity
@Table(name = "test_table")
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    public TestTable(String title) {
        this.title = title;
    }

    public TestTable() {
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
