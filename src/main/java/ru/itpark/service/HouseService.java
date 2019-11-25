package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.repository.HouseRepository;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class HouseService {
    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public List<House> searchByDistrict(String district, String sortBy) throws SQLException {
        if (sortBy.equals("Цена по возрастанию")) {
            return repository.searchByDistrict(district).stream().sorted((o1, o2) -> o1.getPrice() - o2.getPrice()).collect(Collectors.toList());
        }
        if (sortBy.equals("Цена по убыванию")) {
            return repository.searchByDistrict(district).stream().sorted((o1, o2) -> -(o1.getPrice() - o2.getPrice())).collect(Collectors.toList());
        }
        return null;
    }
}





