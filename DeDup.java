

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeDup {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34,
			86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15,
			6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17,
			16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17,
			10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {
		System.out.println("Usage: java DeDup <int_argument> \n "
				+ "1:No Duplicates maintaining order \n "
				+ "2:No Duplicates maintaining order and allows non-negative values \n "
				+ ">=3:No Duplicates, order not maintained \n"
				+ "Default:1");
		DeDup deDup = new DeDup();
		int option = 1;
		
		if (args.length == 0) {
			option = 1;
		} else {
			try {
				option = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				option = 1;
			}
		}
		
		Integer[] resultIntObject = null;
		
		if (option == 1) {
			resultIntObject = deDup.getArrayWithNoDuplicatesMaintaningOrder();
			System.out.println("Choosen(1): No Duplicates maintaining order");
		} else if (option == 2) {
			resultIntObject = deDup.getArrayWithNoDuplicatesAndNonNegative();
			System.out.println("Choosen(2): No Duplicates maintaining order and non-negative");
		} else {
			resultIntObject = deDup.getArrayWithNoDuplicatesOrderNotMaintained();
			System.out.println("Choosen(>=3): No Duplicates not  maintaining order");
		}
		
		int[] resultArray = new int[resultIntObject.length];
		int index = 0;
		
		for (int value : resultIntObject) {
			resultArray[index] = value;
			index++;
		}	
		Arrays.stream(resultArray).forEach(System.out::println);
	}
	
	public Integer[] getArrayWithNoDuplicatesMaintaningOrder() {
		List<Integer> arrayWithNoDups=Arrays.stream(randomIntegers).boxed().distinct().collect(Collectors.toList());
		return arrayWithNoDups.toArray(new Integer[0]);
	}
	
	public Integer[] getArrayWithNoDuplicatesAndNonNegative() {
		List<Integer> arrayWithNoDupsNoNeg = Arrays.stream(randomIntegers).boxed()
				.filter(x -> x >= 0).distinct().collect(Collectors.toList());
		return arrayWithNoDupsNoNeg.toArray(new Integer[0]);
	}

	public Integer[] getArrayWithNoDuplicatesOrderNotMaintained() {
		Set<Integer> arrayWithNoDupsNoOrder=Arrays.stream(randomIntegers).boxed().collect(Collectors.toSet());
		return arrayWithNoDupsNoOrder.toArray(new Integer[0]);
	}
	
}