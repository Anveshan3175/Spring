package com.anvesh.spring.wssecurity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anvesh.spring.wssecurity.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public boolean savePersonDetails(Person person) {

		String connectionURL = "jdbc:mysql://localhost:3306/userDB";
		boolean success = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("insert into Person values ('" + getPersonId() + "','" + person.getName() + "','"
					+ person.getCountry() + "','" + person.getAge() + "','" + person.getOccupation() + "')");
			System.out.println("Succeded !");
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	
	}

	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		String connectionURL = "jdbc:mysql://localhost:3306/userDB";
		Connection con = null;
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			Statement stmt = con.createStatement();
			String sql = "update Person set name = '" + person.getName() + "',age='" + person.getAge()
					+ "',occupation='" + person.getOccupation() + "',country='" + person.getCountry() + "' where id = "
					+ person.getId();
			System.out.println("updatePerson " + sql);
			i = stmt.executeUpdate(sql);

			System.out.println("Succeded. Number of rows modified is " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (i == 1);

	}

	public void removePerson(int id) {
		String connectionURL = "jdbc:mysql://localhost:3306/userDB";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			Statement stmt = con.createStatement();
			String sql = "delete from Person where id = " + id;
			System.out.println("----sql-----" + sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isValidLogin(String name, String password) {
		String connectionURL = "jdbc:mysql://localhost:3306/userDB";
		boolean isValid = false;

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			String query = "select * from Login where name = ? and password = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);

			System.out.println("----sql-----" + query);
			ResultSet rs = preparedStatement.executeQuery();
			isValid = rs.next();
			System.out.println("---isValid----" + isValid);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isValid;
	}

	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}

	public List<Person> listPersons() {
		List<Person> list = new ArrayList<Person>();
		String connectionURL = "jdbc:mysql://localhost:3306/userDB";

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			Statement stmt = con.createStatement();
			String sql = "select * from Person";
			System.out.println("----sql-----" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			Person person = null;
			while (rs.next()) {
				person = new Person();
				person.setId(rs.getInt("id"));
				person.setCountry(rs.getString("country"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setOccupation(rs.getString("occupation"));
				System.out.println("-----person is " + person);
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Person getPersonDetails(int userId) {
		Person person = null;
		String connectionURL = "jdbc:mysql://localhost:3306/userDB";

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			Statement stmt = con.createStatement();
			String sql = "select * from Person where id = " + userId;
			System.out.println("----sql-----" + sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				person = new Person();
				person.setId(rs.getInt("id"));
				person.setCountry(rs.getString("country"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setOccupation(rs.getString("occupation"));
				System.out.println("-----person is " + person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return person;
	}

	private int getPersonId() {
		String connectionURL = "jdbc:mysql://localhost:3306/userDB";
		int id = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionURL, "root", "anvesh");
			Statement stmt = con.createStatement();
			String sql = "select max(id) id from Person";
			System.out.println("----sql-----" + sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id + 1;
	}
}