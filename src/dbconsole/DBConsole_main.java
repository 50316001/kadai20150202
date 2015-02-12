package dbconsole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConsole_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double overall,male,female;
		String country;
		ResultSet rs;
		
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		try {
			while(rs.next()){
			country =rs.getString("country");
			overall = rs.getDouble("Overall life expectancy");
			male = rs.getDouble("Male life expectancy");
			female = rs.getDouble("Female life expectancy");
				System.out.println("‘:" + country);
				System.out.println("‘S‘Ì•½‹Ï:" + overall);
				System.out.println("’j«•½‹Ï:" + male);
				System.out.println("—«•½‹Ï:" + female);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
