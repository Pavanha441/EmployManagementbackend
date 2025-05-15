package com.employee;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.persistence.criteria.Predicate;

public class Java9 {

//	public static void main(String[] args) {
//		Map<String, Integer> ma = Map.of("A", 3, "B", 1, "C", 2);
//		System.out.println(ma);
//
//		LinkedHashMap<String, Integer> sortedMap = ma.entrySet().stream().sorted(Map.Entry.comparingByValue())
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//		System.out.println(sortedMap);
//
//		List<String> words = List.of("apple", "banana", "cherry");
//
//		List<String> upperList = words.stream().map(String::toUpperCase).collect(Collectors.toList());
//
//		System.out.println(upperList);
//		List<Integer> numbers = List.of(5, 3, 7, 5, 9, 3, 1);
//		List<Integer> sortedDesc = numbers.stream().sorted(Comparator.reverseOrder()).distinct()
//				.collect(Collectors.toList());
//		System.out.println(sortedDesc);
//
//		List<String> items = List.of("pen", "pencil", "pen", "eraser", "pencil", "pen");
//
//		Map<String, Long> groupBy = items.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(groupBy);
//
//		List<String> wordsLength = List.of("spring", "boot", "hibernate", "api");
//
//		Map<String, Integer> wordsAllLength = wordsLength.stream()
//				.collect(Collectors.toMap(str -> str, str -> str.length()));
//		System.out.println(wordsAllLength);
//
//		String longest = wordsLength.stream().max(Comparator.comparingInt(String::length)).orElse(null);
//		System.out.println(" " + longest);
//
//		List<Integer> nums = List.of(2, 5, 3, 9, 5, 9, 7);
//
//		Integer secondLargest = nums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()
//				.orElse(0);
//		System.out.println(secondLargest);
//
//		String nymToString = nums.stream().map(i -> i + "").collect(Collectors.joining(", "));
//		System.out.println(nymToString);
//
//		List<String> names = List.of("Alagur", "pavan", "Ashok", "deepak", "Amit");
//
//		List<String> startWirhA = names.stream().filter(a -> a.toUpperCase().startsWith("A"))
//				.collect(Collectors.toList());
//		System.out.println(startWirhA);
//
//		List<Integer> numsSqare = List.of(1, 2, 3, 4, 5);
//		Integer sumSquare = numsSqare.stream().filter(a -> a % 2 == 0).map(a -> a * a).reduce(0, Integer::sum);
//		System.out.println(sumSquare);
//
//		List<String> wordsFre = List.of("java", "python", "java", "c", "python", "java");
//		Map<String, Long> collect = wordsFre.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(collect);
//		String repe = collect.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
//		System.out.println(repe);
//		String repea = wordsFre.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//				.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No val");
//		System.out.println(repea);
//	}
}
