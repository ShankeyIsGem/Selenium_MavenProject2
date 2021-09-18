package testnglearning;

import java.sql.SQLException;

import utilities.DbManager;

public class TestDB
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select * from tutorials_tbl where tutorial_id=2;"));

	}

}
