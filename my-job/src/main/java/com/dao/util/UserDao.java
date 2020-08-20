package com.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.dao.LoginModel;
import com.dao.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
public class UserDao {

	private Connection conn;
	public UserDao() {
		
		conn= DBUtil.getConnection();//connect to database
	}
	//Validates login with user input
	public boolean validateLogin(String em,String pw)
	{
		boolean canLogin=false;
		
		//Search database for email and password and return true if found
		try
		{
			String statement = "select * from user_details where emailID=? and password=?";
			PreparedStatement ps = conn.prepareStatement(statement.toString());
			ps.setString(1, em);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			canLogin= rs.next(); //true if found else false
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return canLogin;
	}
	
	//returns user info from specified email for session
	public UserDto userSession(String em)
	{
		UserDto user=new UserDto(); //create new user object
		try
		{
			String statement = "select * from user_details where emailID=? ";
			PreparedStatement ps = conn
					.prepareStatement(statement.toString());//search database for email
			ps.setString(1, em);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailID(rs.getString("emailID"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setDob(rs.getString("dob"));
				user.setCgpa(rs.getFloat("cgpa"));
				user.setExp(rs.getInt("exp"));
				user.setBio(rs.getString("bio"));

			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	//Creates a new user with input data
	public void createUser(UserDto user)
	{
		try
		{
			String statement = "insert into user_details(firstName,lastName,phoneNo,username, emailID,password,dob) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(statement.toString());//add user to database
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPhoneNo());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getEmailID());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getDob());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//update user with input data
	public void editAccount(UserDto user)
	{
		try
		{
			String statement = "update user_details set emailID=?, password=?,firstName=?,lastName=?,phoneNo=?, dob=?" + " where userID=?";
			PreparedStatement ps = conn.prepareStatement(statement.toString()); //find user with id and update info
			ps.setString(1, user.getEmailID());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getPhoneNo());
			ps.setString(6, user.getDob());
			ps.setInt(7, user.getUserID());


			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//Remove user from database with specified id
	public void deleteAccount(int userid)
	{
		try
		{
			String statement = "delete from user_details where userID=?";
			PreparedStatement ps = conn
					.prepareStatement(statement.toString());
			ps.setInt(1, userid);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//returns a list of all users
	public List<UserDto> listUsers()
	{
		List<UserDto> userList = new ArrayList<UserDto>();
		try
		{
			String statement = "select * from user_details";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(statement.toString());
			while (rs.next())
			{
				UserDto user = new UserDto();
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailID(rs.getString("emailID"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setDob(rs.getString("dob"));

				user.setCgpa(rs.getFloat("cgpa"));
				user.setExp(rs.getInt("exp"));
				user.setBio(rs.getString("bio"));

				userList.add(user);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}
	
	//returns user info from specified id
	public UserDto getUserByID(int userid)
	{
		UserDto user = new UserDto();
		try
		{
			String statement = "select * from user_details where userID= ?";
			PreparedStatement ps = conn
					.prepareStatement(statement.toString());
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailID(rs.getString("emailID"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setDob(rs.getString("dob"));
				user.setCgpa(rs.getFloat("cgpa"));
				user.setExp(rs.getInt("exp"));
				user.setBio(rs.getString("bio"));

			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;
	}

	public UserDto getUser(String emailID) throws SQLException {
		UserDto user = new UserDto();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from user_details where emailID='" + emailID + "'");
		if (rs.next()) {
			user.setUserID(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmailID(rs.getString(4));
			user.setPhoneNo(rs.getString(6));
			user.setDob(rs.getString(7));

			user.setCgpa(rs.getFloat(8));
			user.setExp(rs.getInt(9));
			user.setPassword(rs.getString(5));
			user.setUsername(rs.getString(10));
			user.setBio(rs.getString(11));

		}

		/*user.setUserID(1);
		user.setFirstName("test");
		user.setLastName("testlast");
		user.setEmailID("testlast@test.com");
		user.setPhoneNo("8797987979");
		user.setCgpa(56);
		user.setExp(2);
		user.setPassword("786687");*/
		return user;
	}

	//update user with input data
	public void updateUser(UserDto user)
	{
		try
		{
			String statement = "update user_details set firstname=?, lastname=?, password=?, phoneNo=?, dob=?, cgpa=?, exp=?, bio=?" + " where emailID=?";
			PreparedStatement ps = conn
					.prepareStatement(statement.toString()); //find user with id and update info
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhoneNo());
			ps.setString(5, user.getDob());
			ps.setFloat(6, user.getCgpa());
			ps.setInt(7, user.getExp());
			ps.setString(8, user.getBio());
			ps.setString(9, user.getEmailID());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
