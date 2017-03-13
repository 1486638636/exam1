package com.hand.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hand.entity.Customer;
import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.util.DBUtil;







public class CustomerDAO{
	
	public boolean findUser(String name) {
		PreparedStatement pre = null;
		ResultSet rs = null;
		Connection conn = null;
		conn = DBUtil.getConnection();
		String sql = "select first_name from customer where first_name=?";
		boolean result = false;
	
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			
			rs = pre.executeQuery();			
		
			if (rs.next()) {
				System.out.println(1);
				result=true;
			}
			rs.close();
			pre.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close();
		return result;
	}
	
	public List<Film> findAll() throws Exception{
		List<Film> filmList=new ArrayList<Film>();
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select f.film_id,f.title,f.description,l.name from film f,language l "
				+ "where f.language_id=l.language_id";
		try{
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			int id=rs.getInt(1);
			String title=rs.getString(2);
			String description=rs.getString(3);
			Film f=new Film();		
			f.setFilm_id(id);
			f.setTitle(title);
			f.setDescription(description);
			
			filmList.add(f);
			
		}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close();
		}
		return filmList;
	}
	public List<Language> findLName() throws Exception{
		List<Language> lList=new ArrayList<Language>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select name from film f,language l "
				+ "where f.language_id=l.language_id";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Language l=new Language();
			while(rs.next()){	
				l.setName(rs.getString(1));	
				lList.add(l);
			}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}finally{
				DBUtil.close();
			}
		return lList;
	}
}

