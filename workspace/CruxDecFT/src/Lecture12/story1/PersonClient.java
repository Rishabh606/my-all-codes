package Lecture12.story1;

public class PersonClient {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age = 20;
		p1.name = "A";

		Person p2 = new Person();
		p2.age = 15;
		p2.name = "B";

		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);
		Test1(p1, p2);
		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);

		int myAge = 30;
		String myName = "Sumeet";

		Test2(p1, p2.age, p2.name, myAge, myName);

		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);
		System.out.println(myAge + ", " + myName);
		
		// parameter
		Person p = new Person(3, "Guddu");
		System.out.println(p.age);
		System.out.println(p.name);
	}

	public static void Test1(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

	public static void Test2(Person p, int age, String name, int myAge, String myName) {
		p.age = 0;
		p.name = "";
		age = 0;
		name = "";
		myAge = 0;
		myName = "";
	}

}
