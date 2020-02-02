package java8.functionalinterface.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.models.Apple;

class AppleFiltrationTest {

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>();

		appleList.add(new Apple(34.33, "Green"));
		appleList.add(new Apple(30.33, "Red"));
		appleList.add(new Apple(40.33, "Orange"));
		appleList.add(new Apple(45.33, "Green"));
		appleList.add(new Apple(31.33, "Orange"));
		appleList.add(new Apple(20.33, "Green"));
		appleList.add(new Apple(48.33, "Red"));
		appleList.add(new Apple(60.33, "Green"));
		appleList.add(new Apple(65.33, "Red"));

		final List<Apple> filteredAppleList1 = filterApples(appleList, (Apple a) -> "Green".equals(a.getColor()));
		System.out.println("Green Apples using Predicate: " + filteredAppleList1);
		
		final List<Apple> greenApples = appleList.stream().filter(a -> "Green".equals(a.getColor())).collect(Collectors.toList());
		System.out.println("Green Apples using stream: " + greenApples);
		
		final List<Apple> filteredAppleList2 = filterApples(appleList, (Apple a) -> "Red".equals(a.getColor()));
		System.out.println("Red Apples: " + filteredAppleList2);
		
		final List<Apple> filteredAppleList3 = filterApples(appleList, (Apple a) -> a.getWeight() > 50);
		System.out.println("Apples heavier than 50 grams: " + filteredAppleList3);
		
		final List<Apple> filteredAppleList4 = filterApples(appleList, (Apple a) -> a.getWeight() > 50 && "Green".equals(a.getColor()));
		System.out.println("Green Apples heavier than 50 grams: " + filteredAppleList4);

	}

	private static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> p) {
		List<Apple> filteredAppleList = new ArrayList<>();
		for (Apple apple : appleList) {
			if (p.test(apple)) {
				filteredAppleList.add(apple);
			}
		}
		return filteredAppleList;
	}

}
