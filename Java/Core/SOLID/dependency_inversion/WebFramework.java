package dependency_inversion;


public class WebFramework {
    public void save(ModelFormInterface frm) {
        DataBaseInterface db = new MySQL();
        db.save(frm);
    }
}