import java.sql.*;


//Java Jdbc driver path: "C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.30.jar"

public class TestJDBCDriver1 {
  static String classname = "com.mysql.cj.jdbc.Driver";// 說明我們要連mysql DB的驅動程式(附註有新舊版本) //"com.mysql.cj.jdbc.Driver"
  // java dtabase connection
  // 設定 JDBC 的連線資訊，其中 jdbc:mysql:// 是固定不變的
  // 在 // 之後，首先加上 IP 或者主機名稱，在本例中是 localhost 或127.0.0.1
  // IP 之後，請接上斜線（/）以及資料庫的名稱，在本例中是 eric
  static String jdbcURL = "jdbc:mysql://192.168.43.14/sakila";
  static String UID = "root";
  static String PWD = "a123456B+";
  static Connection con = null;

  public static void main(String[] args) {

    try {
      System.out.println("DB連線 ...");
      // 載入 JDBC 驅動程式
      Class.forName(classname);//.newInstance();
      System.out.println("DB連線 ... 1");
      // connect to Database
      con = DriverManager.getConnection(jdbcURL, UID, PWD);
      System.out.println("DB連線 ... 2");
      if (con != null) {
        System.out.println("DB連線成功");
        con.close();
      } else {
        System.out.println("DB連線失敗");
      }
    } catch (Exception sqle) {
      System.out.println(sqle);
      System.exit(1);
    } finally {
      System.out.println("DB連線 finally");
    }
    /*
     * linux 虛擬機的帳號為=root ,密碼為=123456
     * mysql 帳號=root 密碼為=a123456B+
     */

  }
}
/*
 * 
 * 一般使用jdbc就四個步驟:
 * 1.註冊jdbc驅動程式
 * 1型jdbc驅動程式: jdbc to odbc bridge driver
 * 2.NATIVE型jdbc驅動程式 (C撰寫)
 * 3.JAVA介面去呼叫第2行驅動程式
 * 4.純JAVA程式碼驅動程式
 * 2.建立db連線
 * 3.執行sql命令
 * 4.取回"執行sql命令"結果
 * DBM 單檔案 沒DBM目前偏向 SQLITE3
 * INFORMIX
 * JNDI JAVA NAMING AND DIRECTORY INTERFACE
 */

// set classpath="C:\JdbcDriver\mysql-connector-java-8.0.30.jar"
// set path=c:\jdk1.8\bin:%path%

// C:\Program Files\Java\jdk1.8.0_341\bin
// C:\Program Files\Java\jdk1.8.0_341\jre\bin
// set path="C:\Program Files\Java\jre1.8.0_341\bin:%path%"
// set classpath="C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.30.jar"
// java -Dfile.encoding=utf-8 TestJDBCDriver1.java

// SET CLASSPATH=".;C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.30.jar;%CLASSPATH%"
// java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver