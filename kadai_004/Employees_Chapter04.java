package kadai_004;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {
	
	public static void main(String[] args) {
		
		  Connection con = null;
	        Statement statement = null;

		
		try {
			 con=DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					"root",
					"Na7KamitO127otakU"
					);
			System.out.println("データベース接続成功");
			System.out.println(con);
			

         // SQLクエリを準備
            statement = con.createStatement();
            String sql = """
                         CREATE TABLE employees (
                           id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(60) NOT NULL,
                           email VARCHAR(255) NOT NULL, 
					       age INT(11),
					      adress VARCHAR(255)
                         );
                         """;

            //　SQLクエリを実行（DBMSに送信）
            int rowCnt = statement.executeUpdate(sql);
            System.out.println("テーブルを作成:rowCnt=" + rowCnt );
        } catch(SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
            // 使用したオブジェクトを解放
            if( statement != null ) {
                try { statement.close(); } catch(SQLException ignore) {}
            }
            if( con != null ) {
                try { con.close(); } catch(SQLException ignore) {}
            }
        }
    }
}
		