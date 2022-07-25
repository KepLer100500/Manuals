package dependency_inversion;


public class Main {
    public static void main(String[] args) {
        System.out.println("Run. Dependency inversion.");

        ModelForm frm = new ModelForm(1, 30, "Ivanov");
        WebFramework framework = new WebFramework();
        framework.save(frm);
    }
}