import java.util.*;
import java.io.*;

import java.util.Comparator;

public class ReadTexts{

	int NumOfLines=0;
	int length;
	String a;
	String line;
	ArrayList<lesson> lessons=new ArrayList<lesson>();
	ArrayList<teacher> teachers=new ArrayList<teacher>();

	ReadTexts(){

	}
		//Diavasma twn mathimatwn apo to arxeio
		ArrayList<lesson> loadlessons(String data){

		a = data;
		File f = null;
		BufferedReader in = null;
		String c;

		try {f = new File(a);}
		catch (NullPointerException e) { System.err.println("File not found.");}

		try { in = new BufferedReader(new FileReader(f));}
		catch (FileNotFoundException e) { System.err.println("Error opening file!");}

		try {
			while ((line = in.readLine()) != null){
				String[] splited = line.split(",");

				lesson l=new lesson(splited[0],Integer.parseInt(splited[1]),splited[2],Integer.parseInt(splited[3]));
				//gia kathe mathima mia taksis dimiourgeitai ena stigmiotupo tou
				//gia kathe tmima autis tis taksis.
				for(int a=0;a<=2;a++){
					c=String.valueOf(l.lcode)+String.valueOf(a);
					lesson lk=new lesson(l.lname,Integer.parseInt(c),l.lclass,l.lhours);
					//System.out.println(l.lhours);
					lessons.add(lk);
				}
			}
		}
		catch (IOException e) { System.out.println("Error reading line");}

		try {in.close();}
		catch (IOException e) { System.err.println("Error closing file.");}
		return lessons;
	}
		//diavasma twn kathigitwn apo to arxeio.
		ArrayList<teacher> loadteachers(String data){
		ArrayList<lesson> les=new ArrayList<lesson>();

		a = data;
		File f = null;
		BufferedReader in = null;

		try {f = new File(a);}
		catch (NullPointerException e) { System.err.println("File not found.");}

		try { in = new BufferedReader(new FileReader(f));}
		catch (FileNotFoundException e) { System.err.println("Error opening file!");}

		try {
			while ((line = in.readLine()) != null){
			String[] splited = line.split(",");
			String[] codes=splited[3].split("-");
			for(int i=0;i<lessons.size();i++){
				for(int j=0;j<codes.length;j++){
						//kathe mathima apo tin lista lessons pou didaskei o kathigitis
						//prosthese to stin lista tou.
						if(Integer.parseInt(codes[j])==lessons.get(i).lcode/10) les.add(lessons.get(i));
				}
			 }
			 teacher t=new teacher(splited[0],Integer.parseInt(splited[1]),les,Integer.parseInt(splited[3]),Integer.parseInt(splited[4]));
			 //for(int a=0;a<=t.tweekhours-1;a++){
				// 	System.out.println(t.tname);
				 teachers.add(t);
			 //}
		 }
	 }
		catch (IOException e) { System.out.println("Error reading line");}

		try {in.close();}
		catch (IOException e) { System.err.println("Error closing file.");}
		return teachers;
	}



}
