package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
	  private String driver="oracle.jdbc.driver.OracleDriver";
	  private String url="jdbc:oracle:" + "thin:@localhost:1521:orcl";
	  private String username="C##LYJ";
	  private String password="lyj123123";
	  private Connection con;
	  private Statement stm=null;
	  private ResultSet rs;
	  
	  public String getDriver(){
		  return driver;
	  }
	  public void setDriver(String driver){
		  this.driver=driver;
	  }
	  
	  public String getUrl(){
		  return url;
	  }
	  public void setUrl(String url){
		  this.url=url;
	  }
	  
	  public String getUsername(){
		  return username;
	  }
	  public void steUsername(String username){
		  this.username=username;
	  }
	  
	  public String getPassword(){
		  return password;
	  }
	  public void setPassword(String password){
		  this.password=password;
	  }
	  
	  public Connection getCon(){
		  return con;
	  }
	  public void steCon(Connection con){
		  this.con=con;
	  }
	  
	  public Statement getStm(){
		  return stm;
	  }
	  public void setStm(Statement stm){
		  this.stm=stm;
	  }
	  
	  public ResultSet getRs(){
		  return rs;
	  }
	  public void setRs(ResultSet rs){
		  this.rs=rs;
	  }
	  //��������
	  public boolean creatCon(){
		  boolean b=false;
		  try{
			  Class.forName(driver);//����oracle��������
			  con=DriverManager.getConnection(url, username, password);
			  b=true;
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  catch(ClassNotFoundException e){
			  e.printStackTrace();
		  }
		  return b;
	  }
	  //�޸�
	  public boolean update(String sql){
		  boolean b=false;
		  try{
			  stm=this.con.createStatement();
			  stm.execute(sql);
			  b=true;
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  	return b;						
	  }
	  //��ѯ
	  public void query(String sql){
		  try{
			  stm=con.createStatement();
			  rs=stm.executeQuery(sql);
		  }
		  catch(SQLException e){
			  e.getSQLState();
		  }
	  }
	  
	  //�ж���������
	  public boolean next(){
		  boolean b=false;
		  try{
			  if(rs.next()){
				  b=true;
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  return b;
	  }
	  //��ȡ���ֶ�ֵ
	  public String getValue(String field){
		  String value=null;
		  try{
			  if(rs!=null){
				  value=rs.getString(field);
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  return value;
	  }
	  
	  //�ر�����
	  public void closeCon(){
		  try{
			  if(con!=null){
				  con.close();
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
	  
	  //�ر�Statement
	  public void closeStm(){
		  try{
			  if(stm!=null){
				  stm.close();
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
	  
	  //�ر�ResultSet
	  public void closeRs(){
		  try{
			  if(rs!=null){
				  rs.close();
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
	  
}
