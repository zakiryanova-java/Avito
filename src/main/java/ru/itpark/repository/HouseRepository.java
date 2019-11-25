package ru.itpark.repository;

import ru.itpark.model.House;

import java.sql.SQLException;
import java.util.List;

public interface HouseRepository {

    List<House> searchByDistrict(String district) throws SQLException;
}
