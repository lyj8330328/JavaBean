package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
	/**
	 * 一个非常标准的连接Oracle数据库的示例代码
	 */
	public boolean login(String us,String ps)
	{
	    Connection con = null;// 创建一个数据库连接
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象
	    boolean k=false;
	    try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@localhost:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "C##LYJ";// 用户名,系统默认的账户名
	        String password = "lyj123123";// 你安装时选设置的密码
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	       
	        System.out.println("连接成功！");
	        //String us="2";
	        //String ps="1";
	        //String email="1";
	        String id="12";
	        String email="1";
	        //String sql = "select * from P_USER where us="+us;// 预编译语句，“？”代表参数
	        String sql= "insert into p_user(id,us,ps,email) values('"+id+"','"+us+"','"+ps+"','"+email+"')";  
	        pre = con.prepareStatement(sql);// 实例化预编译语句	        
	        pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        /*if(result.next()){
	        	k=true;
	        	
	        }
	        else{
	        	System.out.print("23");
	        	
	        }
	        */
	       // while (result.next())
	            // 当结果集不为空时
	           // System.out.println(result.getString("email"));
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    return k;
	}
//  public static void main(String[] args){
//	  login("12","12");
//  } 
}
