import java.sql.*;
public class TestJDBCDriver4{
  static String classname = "com.mysql.cj.jdbc.Driver";//說明我們要連mysql DB的驅動程式(附註有新舊版本)
   //java dtabase connection
  // 設定 JDBC 的連線資訊，其中 jdbc:mysql:// 是固定不變的
  // 在 // 之後，首先加上 IP 或者主機名稱，在本例中是 localhost 或127.0.0.1
  // IP 之後，請接上斜線（/）以及資料庫的名稱，在本例中是 eric
  static String jdbcURL = "jdbc:mysql://192.168.43.14/sakila";
  static String UID = "root";
  static String PWD = "a123456B+";
  static Connection con = null;
  
  public static void main(String[] args)throws Exception{
    // 載入 JDBC 驅動程式
    //Class.forName(classname).newInstance();//java 9(含)後會提示過期,但不影響使用
    Class.forName(classname).getDeclaredConstructor().newInstance();//java 9(含)後使用
     // connect to Database
    String sqlStr= "select * from actor ";
    System.out.println(sqlStr);
    try(Connection con =DriverManager.getConnection(jdbcURL,UID,PWD);
    Statement stmt = con.createStatement();ResultSet rs=stmt.executeQuery( sqlStr )) {
      while ( rs.next() ) {//迭代 jdbc 固定第一次需rs.next()去定位到第一筆,如果有第一筆的話再由rs.next()執行到下一筆
        int numColumns = rs.getMetaData().getColumnCount();//取得所有欄位數
        for ( int i = 1 ; i <= numColumns ; i++ ) {
          System.out.print( "  " + rs.getObject(i) );
        }
    //因getObject()是取得欄位資料為Object class型態,會這樣做是Object class是所有class父類別(包含String,Integer等),它是萬用型態可容納所有資料型態
        System.out.println();
      }
    } catch (Exception sqle) {
      System.out.println(sqle);
      System.exit(1);
    }

  
  }
}