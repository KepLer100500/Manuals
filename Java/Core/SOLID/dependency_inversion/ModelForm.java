package dependency_inversion;


public class ModelForm implements ModelFormInterface {
    int id;
    int age;
    String fio;

    ModelForm(int id, int age, String fio) {
        this.id = id;
        this.age = age;
        this.fio = fio;
    }
}