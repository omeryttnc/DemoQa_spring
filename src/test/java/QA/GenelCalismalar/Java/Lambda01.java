package QA.GenelCalismalar.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambda01 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(9);
		list.add(13);
		list.add(4);
		list.add(6);
		list.add(2);
		list.add(4);
		list.add(12);
		list.add(15);
		
		
		//Console de her bir elementi tek tek yazdir "Stuructured Programing"
		//1.Yol
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();
		
		//2.Yol 
		for (int w : list) {
			System.out.print(w+" ");	
				
		}
		
		System.out.println();
		
		//Lamda
		//1.Yol
		
		list
			.forEach(t->System.out.print(t+" ")); // t -> Action with "t" ==> Lambda Expression
		
		System.out.println();
		
		//2.Yol
		list.stream()
			.forEach(System.out :: print); 
		
		System.out.println();
		
		//3.Yol
		Predicate <Integer> ispEven = (t)->t%2==0;
		Consumer <Integer> Cwrite = t->System.out.print(t+" ");
		list.stream()
			.filter(ispEven)
			.forEach(Cwrite);
			
		 System.out.println(ispEven.test(8));
		
		//Listedeki tum cift sayilari tek tek yazdir "Functional Prg."
		
		list.stream()
			//.filter(t->t%2==0 & t>7)
			.filter(Lambda01::isEven)
			//.forEach(System.out::print);
			.forEach(t->System.out.print(t+" "));
		
		System.out.println();
		
		//Listedeki 3 e bolunebilen elementleri yazdir
		
		list.stream()
			.filter(t->t%3==0)
			.forEach(t->System.out.print(t+" "));
		
		System.out.println();
		
		//Listedeki butun tek sayilari m2 yazdir
		list.stream()
			.filter(t->t%2!=0)
			.map(t->t*t)
			.forEach(t->System.out.print(t+" "));

	}
	
	private static boolean isEven(int num) {
		return num%2==0;
	}

}
