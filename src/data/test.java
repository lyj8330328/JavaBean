package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {
	/**
	 * һ���ǳ���׼������Oracle���ݿ��ʾ������
	 */
	public boolean login(String us,String ps)
	{
	    Connection con = null;// ����һ�����ݿ�����
	    PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
	    ResultSet result = null;// ����һ�����������
	    boolean k=false;
	    try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
	        System.out.println("��ʼ�����������ݿ⣡");
	        String url = "jdbc:oracle:" + "thin:@localhost:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
	        String user = "C##LYJ";// �û���,ϵͳĬ�ϵ��˻���
	        String password = "lyj123123";// �㰲װʱѡ���õ�����
	        con = DriverManager.getConnection(url, user, password);// ��ȡ����
	       
	        System.out.println("���ӳɹ���");
	        //String us="2";
	        //String ps="1";
	        //String email="1";
	        String id="12";
	        String email="1";
	        //String sql = "select * from P_USER where us="+us;// Ԥ������䣬�������������
	        String sql= "insert into p_user(id,us,ps,email) values('"+id+"','"+us+"','"+ps+"','"+email+"')";  
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������	        
	        pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
	        /*if(result.next()){
	        	k=true;
	        	
	        }
	        else{
	        	System.out.print("23");
	        	
	        }
	        */
	       // while (result.next())
	            // ���������Ϊ��ʱ
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
	            // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
	            // ע��رյ�˳�����ʹ�õ����ȹر�
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("���ݿ������ѹرգ�");
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
