public class lesson extends Object{
	String lname;
	int lcode;
	String lclass;
	int lhours;
	int lcount;

	public lesson(String lname,int lcode, String s_class,int lhours){
		this.lname=lname;
		this.lcode=lcode;
		this.lclass=lclass;
		this.lhours=lhours;
	}

	public String getlname(){
		return lname;
	}
	public int getlcode(){
		 return lcode;
	}
	public String getlclass(){
		return lclass;
	}
	public int getlhours(){
		return lhours;
	}
	public void add_lcount(){
		lcount++;
	}

	public int getcount(){
		return lcount;
	}
}
