package com.stream;

import com.model.CarModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.stream.Stream;

public class StreamTesting {
    public static void main(String[] args) {
//        var carMap = new HashMap<String, ArrayList<CarModel>>();
//        carMap.put("vw", carList);
        var cars = List.of(CarModel.builder().name("Beatle").year(1976).model(1977).type("bug").brand("volkswagen").build(),
                CarModel.builder().name("Passat").year(1976).model(1977).type("sedan").brand("volkswagen").build(),
                CarModel.builder().name("Santana").year(1986).model(1987).type("sedan").brand("volkswagen").build(),
                CarModel.builder().name("Parati").year(1990).model(1991).type("wagen").brand("volkswagen").build(),
                CarModel.builder().name("Monza").year(1990).model(1991).type("sedan").brand("chevrolet").build());
        //Filter
        var sedanCars = cars.stream().filter(c -> c.getType().equalsIgnoreCase("sedan")).toList();
        sedanCars.forEach(c -> System.out.println(c.toString()));
        //Map
        var manufactures = cars.stream().map(CarModel::getBrand).toList();
        manufactures.forEach(System.out::println);
        //FlatMap
        List<String> nameAndBrand = cars.stream().flatMap(car -> Stream.of(car.getName(), car.getBrand())).toList();
        nameAndBrand.forEach(System.out::println);
        //Count
        long count = cars.stream().filter(c -> c.getYear() > 1980).count();
        System.out.printf("Qt: %d%n", count);
        //Stream Of
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 55, 66, 77, 2, 5, 0);
        List<Integer> evenNumbers = integerStream.filter(n -> n % 2 == 0).toList();
        evenNumbers.forEach(System.out::println);
        //Collect partitionBy
        Map<Boolean, List<CarModel>> partitionByType = cars.stream().collect(Collectors.partitioningBy(c -> c.getType().equalsIgnoreCase("sedan")));
        partitionByType.get(true).forEach(System.out::println);
        //Collect by (type, (name, brand))
        Map<String, Map<String, String>> collectByType = cars.stream().collect(Collectors.groupingBy(
                CarModel::getType, Collectors.toMap(CarModel::getName, CarModel::getBrand)));
        collectByType.get("bug").forEach((key, value) -> System.out.printf("Name: %s, brand: %s%n", key.toUpperCase(), value.toUpperCase()));
        //Parallel Stream
        cars.parallelStream().parallel().forEach(System.out::println);

    }
}
