package ru.itpark.repository;

import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class HouseRepositoryJdbcImpl implements HouseRepository {
    private final String url;

    public HouseRepositoryJdbcImpl(String url) {
        this.url = url;
    }

    @Override
    public List<House> searchByDistrict(String district) throws SQLException {
        return JdbcTemplate.executeQuery(url, "SELECT id, price, district, underground FROM houses",
                resultSet -> new House(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getString("district"),
                        resultSet.getString("underground")
                ));
    }
}
