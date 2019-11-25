package ru.itpark;

import ru.itpark.model.House;
import ru.itpark.repository.HouseRepositoryJdbcImpl;
import ru.itpark.service.HouseService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        final HouseService service = new HouseService(new HouseRepositoryJdbcImpl("jdbc:sqlite:db.sqlite"));
        List<House> result = service.searchByDistrict("Приволжский", "Цена по возрастанию");
        System.out.println(result);
        List<House> resultOther = service.searchByDistrict("Приволжский", "Цена по убыванию");
        System.out.println(resultOther);
    }
}
