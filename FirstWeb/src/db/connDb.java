package db;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
  
public class connDb {  
    private static Connection con = null;  
    private static Statement stmt = null;  
    private static ResultSet rs = null;  
  
    public connDb() {   
        //连接数据库方法  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }  
  
    public static void endconn() {   
        //关闭连接  
        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rs = null;
        stmt = null;
        con = null;
    }  
  
    public static void add(String sql){   
  
        //数据库更新  
        try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			endconn();
			e.printStackTrace();
		}    
    }  
    
	public static ResultSet executeSQL(String sql) {
		try {
			stmt = con.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			endconn();			
			e.printStackTrace();
		}
		return null;
	}
  
    public static ArrayList getList(String sql)  {  
  
        //数据库查询  
        ArrayList list = new ArrayList();  
        try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
	        while (rs.next()) {  
	            Stu st = new Stu();  
	            st.setName(rs.getString("name"));  
	            st.setPassword(rs.getString("password"));  
	            list.add(st);  
	        }  
		} catch (SQLException e) {
			endconn();			
			e.printStackTrace();
		}           
        return list;  
    }  
  
  
}  