import java.io.*;
import java.util.*;

public class Main{
		static Object[][][] p=new Object[35][9][2];
		static ArrayList<lesson> lessons=new ArrayList<lesson>();
		static ArrayList<teacher> teachers=new ArrayList<teacher>();

		public static void main(String[] args){
			ReadTexts rt=new ReadTexts();
			lessons=rt.loadlessons("lessons.txt");

		//Eisagwgi kathe mathimatos ston pinaka oses wres
		//prepei na didaxthei.

			for(int i=0;i<lessons.size();i++){
				for(int a=0;a<=lessons.get(i).lhours-1;a++){
					//System.out.println(a);
					for (int x=0; x<p.length; x++){
						for (int y=0;y<p[x].length;y++){
							//if(lessons.get(i)==null) p[x][y][0]=null;
							p[x][y][0]=lessons.get(i);

						}
					}
				}
			}
			teachers=rt.loadteachers("teachers.txt");
			//System.out.println(teachers.get(0).tname);
			for(int i=0;i<teachers.size();i++){
				for(int a=0;a<=teachers.get(i).tweekhours-1;a++){
					for (int x=0; x<p.length; x++){
						for (int y=0;y<p[x].length;y++){
							//if(teachers.get(i)==null) p[x][y][1]=null;
							//System.out.println(i);
							//System.out.println(a);
							p[x][y][1]=teachers.get(i);

						}
					}
				}
			}

			programma prog=new programma();
			state initialState=new state(p);
			state terminalState=null;
			terminalState=prog.ImplementClosedSet(initialState);
			printer p=new printer();
			p.printer(terminalState.prog);

		}
}
