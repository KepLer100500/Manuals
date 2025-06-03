namespace BasicCsharp;

using BasicCsharp;
using TestLibrary;

public class Classes {
    public void Show() {
        BasicCsharp.Person person1 = new BasicCsharp.Person();
        Console.WriteLine(person1.ToString());

        Person person2 = new Person { name = "trololoshka" }; // initialisator setup value after constructor
        Console.WriteLine(person2.ToString());

        Person person3 = new Person("cheburek");
        Console.WriteLine(person3.ToString());

        (_, string title) = person3.department;
        Console.WriteLine($"Department = title: {title}");

        Employee employee1 = new Employee(345);
        employee1.department = person3.department;
        employee1.Print();

        Employee employee2 = employee1 with { name = "trololoshka" }; // little modify object
        employee2.Print();

        TestClass testClass = new TestClass();
        TestClass testClass2 = new(); // another way
        testClass.Show();

        GigaPerson gigaPerson = new GigaPerson { Id = 777 }; // initializator
        gigaPerson.Name = "trololoshka";
        gigaPerson.Lastname = "ololoshka";
        gigaPerson.Age = 10;
        // gigaPerson.DateTime = "3333"; error - Init-only property
        Console.WriteLine(gigaPerson);
        Console.WriteLine(gigaPerson.Fullname);
        Console.WriteLine($"Counter: {GigaPerson.Counter}");
    }
}

class GigaPerson {
    public GigaPerson(int id) {
        Id = id;
    }

    public GigaPerson() { // run this constructor, because object created by initializator!
        Counter++;
    }

    static GigaPerson() {
        Counter = 500;
    }
    public static int Counter { get; private set; }

    public required int Id { get; set; }

    private string DateTime { get; init; } = "01.01.2020";

    public string Name { get; set; }

    private string _nickName;

    public string NickName {
        get => _nickName;
        set => _nickName = value;
    }

    private string _lastname;

    public string Lastname {
        get { return _lastname; }
        set { _lastname = value; }
    }

    private string Patronymic { get; set; } = "Ololoevich";

    public string Fullname {
        get { return Name + " " + Lastname; }
    }

    private int _age;
    public int Age {
        get { return _age * 2; }
        set { _age = value + 500; }
    }

    public override string ToString() {
        return
            $"Id: {Id}, DateTime: {DateTime} Name: {Name}, Lastname: {Lastname}, Patronymic: {Patronymic}, Age: {Age}";
    }
}

class State {
    // все равно, что private string defaultVar;
    string defaultVar = "default";

    // поле доступно только из текущего класса
    private string privateVar = "private";

    // доступно из текущего класса и производных классов, которые определены в этом же проекте
    protected private string protectedPrivateVar = "protected private";

    // доступно из текущего класса и производных классов
    protected string protectedVar = "protected";

    // доступно в любом месте текущего проекта
    internal string internalVar = "internal";

    // доступно в любом месте текущего проекта и из классов-наследников в других проектах
    protected internal string protectedInternalVar = "protected internal";

    // доступно в любом месте программы, а также для других программ и сборок
    public string publicVar = "public";

    // по умолчанию имеет модификатор private
    void Print() => Console.WriteLine(defaultVar);

    // метод доступен только из текущего класса
    private void PrintPrivate() => Console.WriteLine(privateVar);

    // доступен из текущего класса и производных классов, которые определены в этом же проекте
    protected private void PrintProtectedPrivate() => Console.WriteLine(protectedPrivateVar);

    // доступен из текущего класса и производных классов
    protected void PrintProtected() => Console.WriteLine(protectedVar);

    // доступен в любом месте текущего проекта
    internal void PrintInternal() => Console.WriteLine(internalVar);

    // доступен в любом месте текущего проекта и из классов-наследников в других проектах
    protected internal void PrintProtectedInternal() => Console.WriteLine(protectedInternalVar);

    // доступен в любом месте программы, а также для других программ и сборок
    public void PrintPublic() => Console.WriteLine(publicVar);
}

struct Employee {
    public int id;
    public string name = "test name";
    public Department department;

    public Employee(int id) {
        this.id = id;
    }

    public void Print() {
        Console.WriteLine($"ID: {id}, Name: {name}, Department: {department}");
    }
}

class Person(int id, string name, int age, Department department) {
    private int id = id;
    public string name = name;
    protected int age = age;
    public Department department = department;

    public Person(int age, string name) : this(0, name + " 2", age, new Department()) {
        Console.WriteLine("Call 3 constructor"); // executed first!
    }

    public Person(string name) : this(500, name + " 1") {
        Console.WriteLine("Call 2 constructor");
    }

    public Person() : this("default name") {
        Console.WriteLine("Call 1 constructor");
    }

    public override string ToString() {
        return $"Person(id={id}, name={name}, age={age}, department={department})";
    }
}

class Department {
    int id;
    string title;

    public Department(int id = -123, string title = "ololo") {
        this.id = id;
        this.title = title;
    }

    public override string ToString() {
        return $"Department(id={id}, title={title})";
    }

    public void Deconstruct(out int id, out string title) {
        id = this.id;
        title = this.title;
    }
}