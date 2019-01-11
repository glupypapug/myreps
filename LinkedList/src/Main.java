
public class Main {
	
	static thelist zoznam;

	public static void main(String[] args) {
		System.out.println("Zretazeny zoznam");
		zoznam = new thelist(1);
		
		zoznam.addValue(3);
		
		zoznam.dump();

	}

}
