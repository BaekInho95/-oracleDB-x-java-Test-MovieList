package dbTest;

import java.io.*;
import java.sql.*;
import java.sql.CallableStatement;

public class MovieList {
	Connection con;

	public void movielist() {
		String Driver = "";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "c##ino";
		String pwd = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("데이터베이스 연결 준비...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlRun() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String query;
		while (true) {
			System.out.println("sql 명령어 입력하기");
			query = br.readLine();
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				System.out.println("NO. \t\tNAME \t\t\tGenre \tPRICE");
				while (rs.next()) {
					System.out.print(rs.getInt(1));
					System.out.print("\t\t" + rs.getString(2));
					System.out.print("\t\t\t" + rs.getString(3));
					System.out.println("\t" + rs.getInt(4));
				}

				// con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		MovieList so = new MovieList();
		so.movielist();
		so.sqlRun();
	}

}
