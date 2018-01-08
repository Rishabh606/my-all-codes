
public class generics {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Car[] car = new Car[5];
		car[0] = new Car("A", 250, 30);
		car[1] = new Car("B", 450, 40);
		car[2] = new Car("C", 700, 50);
		car[3] = new Car("D", 350, 60);
		car[4] = new Car("E", 470, 70);
		//display(car);
		//bubbleSort(car);
		//display(car);
		linklist_T ll = new linklist_T();
		ll.addFirst(car[0]);
		ll.addFirst(car[1]);
		ll.addFirst(car[2]);
		ll.addFirst(car[3]);
		ll.addFirst(car[4]);
		ll.display();
	}

	public static <T> void display(T[] iarr) {
		for (int i = 0; i < iarr.length; i++) {
			System.out.println(iarr[i]);
		}
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static class Car implements Comparable<Car> {
		String name;
		int price;
		int speed;

		Car(String name, int price, int speed) {
			this.name = name;
			this.price = price;
			this.speed = speed;
		}

		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			return this.price - o.price;
		}

		@Override
		public String toString() {
			return "{ Name- "+this.name + ", price- " + this.price + ", speed- " + this.speed+" }";
		}

	}
}
