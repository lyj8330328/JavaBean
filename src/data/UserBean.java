package data;

public class UserBean {
	//��½��֤
	public boolean valid(String username,String password){
		boolean isValid=false;
		DataAccess db=new DataAccess();
		if(db.creatCon()){
			String sql="select * from p_user where us='"+username+"' and ps='"+password+"'";
			db.query(sql);
			if(db.next()){
				isValid=true;
				System.out.print("�ɹ���");
			}
			db.closeRs();
			db.closeStm();
			db.closeCon();
		}
		return isValid;
	}
	
	//ע����֤
	public boolean isExist(String username){
		boolean isValid=false;
		DataAccess db=new DataAccess();
		if(db.creatCon()){
			String sql="select * from p_user where us='"+username+"'";  
			db.query(sql);
			if(db.next()){
				isValid=true;
			}
			db.closeRs();
			db.closeStm();
			db.closeCon();
		}
		return isValid;
	}
	//ע���û�
	public boolean add(String username,String password,String email){
		boolean isValid=false;
		DataAccess db=new DataAccess();
		if(db.creatCon()){
			String sql= "insert into p_user(id,us,ps,email) values('"+GenerateUnID.next()+"','"+username+"','"+password+"','"+email+"')";  
			isValid=db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeCon();
		}
		return isValid;
	}
}
