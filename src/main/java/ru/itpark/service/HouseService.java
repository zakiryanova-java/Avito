package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.sql.SQLException;
import java.util.*;

public class HouseService {
    private List<House> houses = JdbcTemplate.executeQuery("jdbc:sqlite:db.sqlite", "SELECT id, price, district, underground FROM houses",
            resultSet -> new House(
                    resultSet.getInt("id"),
                    resultSet.getInt("price"),
                    resultSet.getString("district"),
                    resultSet.getString("underground")
            ));

    public HouseService() throws SQLException {
    }

    public List<House> searchByDistrict(String district, String sortBy) {
        List<House> list = new ArrayList<>();
        for (House house : houses) {
            if (house.getDistrict().equals(district)) {
                list.add(house);
            }
        }
        if (sortBy.equals("Цена по возрастанию")) {
            Comparator<House> houseAscComparator = Comparator.comparing(h -> h.getPrice());
            list.sort(houseAscComparator);
        }
        if (sortBy.equals("Цена по убыванию")) {
            Comparator<House> houseDescComparator = Comparator.comparing(House::getPrice).reversed();
            list.sort(houseDescComparator);
        }
        return list;
    }
}





