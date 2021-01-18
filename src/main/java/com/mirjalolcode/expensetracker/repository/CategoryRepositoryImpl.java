package com.mirjalolcode.expensetracker.repository;

import com.mirjalolcode.expensetracker.EtResourceNotFoundException;
import com.mirjalolcode.expensetracker.exception.EtBadRequestException;
import com.mirjalolcode.expensetracker.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String SQL_FIND_BY_ID="SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION," +
            "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE" +
            "FROM ET_TRANSACTIONS T RIGHT OUTER JOIN" +
            "ET_CATEGORIES C ON C.CATEGORY_ID=T.CATEGORY_ID" +
            "WHERE C.USER_ID=? AND C.CATEGORY_ID=? GROUP BY C.CATEGORY_ID";

    private static final String SQL_CREATE="INSERT INTO ET_CATEGORIES (CATEGORY_ID, USER_ID, TITLE" +
            "DESCRIPTION) VALUES(NEXTVAL('ET_CATEGORIES_SEQ'), ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll(Integer userId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, categoryId}, categoryRowMapper);
        }
        catch (Exception e){
            throw new EtResourceNotFoundException("Category not found");
        }
    }

    @Override
    public Integer create(Integer userId,  String title, String description)
            throws EtBadRequestException {
        try {
            KeyHolder keyHolder=new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps=connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setString(3, title);
                ps.setString(4, description);

                return ps;
            }, keyHolder);

            return (Integer) keyHolder.getKeys().get("CATEGORY_ID");
        }
        catch (Exception e){
            throw new EtBadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {

    }

    @Override
    public void remove(Integer userId, Integer categoryId) {

    }

    private RowMapper<Category> categoryRowMapper=((rs, rowNum)->{
        return new Category(rs.getInt("CATEGORY_ID"),
                rs.getInt("USER_ID"),
                rs.getString("TITLE"),
                rs.getString("DESCRIPTION"),
                rs.getString("TOTAL_EXPENSE"));
    });
}
