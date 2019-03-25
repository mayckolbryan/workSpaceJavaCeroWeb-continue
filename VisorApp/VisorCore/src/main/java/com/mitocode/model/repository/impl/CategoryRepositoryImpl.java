package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import com.mitocode.model.entity.Category;
import com.mitocode.model.repository.CategoryRepository;
import com.mitocode.model.repository.ConnectionDb;

@Named
public class CategoryRepositoryImpl implements CategoryRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	private Connection cn = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;
	
	public Category insert(Category t) throws Exception{
		try {
			cn = ConnectionDb.getConnectionDb();
			
			String query = "INSERT INTO categorys (name) VALUES(?)";
			
			pr = cn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pr.setString(1, t.getName().toUpperCase());
			
			pr.executeUpdate();
			
			rs = pr.getGeneratedKeys();
			rs.next();
			
			t.setId(rs.getInt(1));
		} finally {
			ConnectionDb.close(cn);
			ConnectionDb.close(pr);
			ConnectionDb.close(rs);
		}
		
		return t;
	}

	@Override
	public Category update(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category delete(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Category> find(Category t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
