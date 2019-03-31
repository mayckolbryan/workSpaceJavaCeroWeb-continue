package com.hampcode.model.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import com.hampcode.model.entity.Category;
import com.hampcode.model.repository.CategoryRepository;
import com.hampcode.model.repository.ConnectionDb;

@Named
public class CategoryRepositoryImpl implements CategoryRepository {

	private Connection cn = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;

	@Override
	public Category insert(Category t) throws Exception {
		try {
			cn = ConnectionDb.getConnectionDb();
			String sql = "INSERT INTO categorys (name) VALUES (?)";
			pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, t.getName().toUpperCase());
			pr.executeUpdate();
			rs = pr.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));
		} finally {
			ConnectionDb.close(rs);
			ConnectionDb.close(pr);
			ConnectionDb.close(cn);
		}
		return t;
	}

	@Override
	public Category update(Category t) throws Exception {
		try {
			cn = ConnectionDb.getConnectionDb();
			String sql = "UPDATE categorys SET name=? WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setString(1, t.getName().toUpperCase());
			pr.setInt(2, t.getId());
			pr.executeUpdate();
		} finally {
			ConnectionDb.close(pr);
			ConnectionDb.close(cn);
		}
		return t;
	}

	@Override
	public Category delete(Category t) throws Exception {
		try {
			cn = ConnectionDb.getConnectionDb();
			String sql = "DELETE FROM categorys WHERE id=?";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, t.getId());
			pr.executeUpdate();
		} finally {
			ConnectionDb.close(pr);
			ConnectionDb.close(cn);
		}
		return t;
	}

	@Override
	public Optional<Category> find(Category t) throws Exception {
		Category category = null;
		try {
			cn = ConnectionDb.getConnectionDb();
			String sql = "SELECT id,name FROM categorys WHERE id=? ORDER BY name";
			pr = cn.prepareStatement(sql);
			pr.setInt(1, t.getId());
			rs = pr.executeQuery();
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name").toUpperCase());
			}
		} finally {
			ConnectionDb.close(rs);
			ConnectionDb.close(pr);
			ConnectionDb.close(cn);
		}
		return Optional.of(category);
	}

	@Override
	public List<Category> findAll() throws Exception {
		List<Category> categorys = new ArrayList<Category>();
		Category category;
		try {
			cn = ConnectionDb.getConnectionDb();
			String sql = "SELECT id,name FROM categorys ORDER BY name";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name").toUpperCase());
				categorys.add(category);
			}
		} finally {
			ConnectionDb.close(rs);
			ConnectionDb.close(pr);
			ConnectionDb.close(cn);
		}
		return categorys;
	}

	@Override
	public List<Category> findByName(String name) throws Exception {
		List<Category> categorys = new ArrayList<Category>();
		Category category;
		try {
			cn = ConnectionDb.getConnectionDb();
			String sql = "SELECT id,name FROM categorys ";
			sql += " WHERE UCASE(name) LIKE '%" + name + "%'";
			sql += " ORDER BY name";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name").toUpperCase());
				categorys.add(category);
			}
		} finally {
			ConnectionDb.close(rs);
			ConnectionDb.close(pr);
			ConnectionDb.close(cn);
		}
		return categorys;
	}

}
