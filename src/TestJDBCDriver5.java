import java.sql.*;
import java.io.*;
public class TestJDBCDriver5{
  static String classname = "com.mysql.cj.jdbc.Driver";//說明我們要連mysql DB的驅動程式(附註有新舊版本)
   //java dtabase connection
  // 設定 JDBC 的連線資訊，其中 jdbc:mysql:// 是固定不變的
  // 在 // 之後，首先加上 IP 或者主機名稱，在本例中是 localhost 或127.0.0.1
  // IP 之後，請接上斜線（/）以及資料庫的名稱，在本例中是 eric
  static String jdbcURL = "jdbc:mysql://192.168.43.14/sakila";
  static String UID = "root";
  static String PWD = "a123456B+";
  static Connection con = null;
  static PreparedStatement stmt=null;
  static ResultSet rs=null;
  
  public static void main(String[] args){
    try {
        try{
            // 載入 JDBC 驅動程式
            //Class.forName(classname).newInstance();//java 9(含)後會提示過期,但不影響使用
            Class.forName(classname).getDeclaredConstructor().newInstance();//java 9(含)後使用
      
            // connect to Database
            con = DriverManager.getConnection(jdbcURL,UID,PWD);
            String first_name="JENNIFER";
            String last_name="DAVIS"; //
            String sqlStr= "select * from actor where first_name=? AND last_name=?";      
            System.out.println(sqlStr);
      
            stmt = con.prepareStatement(sqlStr);
            stmt.setString(1,first_name);
            stmt.setString(2,last_name);
            rs=stmt.executeQuery();
            while ( rs.next() ) {
              int numColumns = rs.getMetaData().getColumnCount();
              for ( int i = 1 ; i <= numColumns ; i++ ) {
                System.out.print( "  " + rs.getObject(i) );
              }
              System.out.println();
            }
        }finally{
            if(rs!=null)rs.close();      
            if(stmt!=null)stmt.close();
            if(con!=null) con.close();
        }     
    } catch (Exception sqle) {
      System.out.println(sqle);
      System.exit(1);
    }

  
  }
}