package dependency_inversion;


public class MySQL implements DataBaseInterface {
    public void save(ModelFormInterface frm) {
        System.out.println("Record inserted");
    }
}