import java.io.*;
import java.util.*;

public class teacher{
	String tname;
	int tcode;
	ArrayList<lesson> tlessons=new ArrayList<lesson>();
	int tweekhours;
	int tdayhours;
	int tcount;


	public teacher(String tname,int tcode,ArrayList<lesson> tlessons,int tdayhours, int tweekhours){
		this.tname=tname;
		this.tcode=tcode;
		this.tlessons=tlessons;
		this.tdayhours=tdayhours;
		this.tweekhours=tweekhours;
	}


	public void add_hcount(){
		tcount++;
	}

	public int get_hcount(){
		return tcount;
	}
}
