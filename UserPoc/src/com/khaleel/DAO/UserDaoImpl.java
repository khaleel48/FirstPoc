package com.khaleel.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.khaleel.model.User;

@PropertySource("classpath:app.properties")
public class UserDaoImpl implements UserDao {

	private static Connection con;
	private PreparedStatement ps;
	
	@Value("{dbName}")
	private String dbName;
	
	@Value("{dbPwd}")
	private static String dbPwd;
	
	@Value("{dburl}")
	private String url;
	
	
	public static Connection getConnection() {
		try {
			//System.out.println(dbPwd);
			/*Class.forName("com.mysql.jdbc.Driver");*/
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("************** Driver Loaded ************");
			con=DriverManager.getConnection("jdbc:mysql://192.168.10.231:3306/murali", "root", "root");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;		
	}
	

	@Override
	public int updateUser(User user) {
		int status=0;
		con=UserDaoImpl.getConnection();
		try {
			ps=con.prepareStatement("update userdata set name=?,email=? where id=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getId());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteUser(int id) {
		int status=0;
		con=UserDaoImpl.getConnection();
		try {
			ps=con.prepareStatement("delete from userdate where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public User getUserDataByID(int id) {
		User user=new User();
		con=UserDaoImpl.getConnection();
		try {
			ps=con.prepareStatement("Select * from userdata where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				user.setName(rs.getString(1));
				user.setId(rs.getInt(2));
				user.setEmail(rs.getString(3));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> allUsers() {
		List<User> allUsers=new ArrayList<User>();
		con=UserDaoImpl.getConnection();
		try {
			ps=con.prepareStatement("select * from userdata");
			ResultSet rs=ps.executeQuery();
			User user=new User();
			while (rs.next()) {
				user.setName(rs.getString(1));
				user.setId(rs.getInt(2));
				user.setEmail(rs.getString(3));
				
				allUsers.add(user);
			}
			
		} catch (SQLException e) {
					e.printStackTrace();
		}
		return allUsers;
	}


	@Override
	public int saveUser(User user) {
		int status=0;
		try {
			con=UserDaoImpl.getConnection();
			ps=con.prepareStatement("insert into emp(cus_id ,cus_firstname,cus_email) values(?,?,?)");
			ps.setString(2, user.getName());
			ps.setInt(1, user.getId());
			ps.setString(3, user.getName());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
