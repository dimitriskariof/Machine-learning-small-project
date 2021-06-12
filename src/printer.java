import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class printer{
  Object[][][] pr;
  lesson l;
  teacher t;
  int length;
  int depth;
  int width;
  //ArrayList<Queue<String>> all=new ArrayList<Queue<String>>();
  //I ektupwsi tha ginetai ana tmima.
  Queue<String> A1q=new LinkedList<String>();
  Queue<String> A2q=new LinkedList<String>();
  Queue<String> A3q=new LinkedList<String>();
  Queue<String> B1q=new LinkedList<String>();
  Queue<String> B2q=new LinkedList<String>();
  Queue<String> B3q=new LinkedList<String>();
  Queue<String> C1q=new LinkedList<String>();
  Queue<String> C2q=new LinkedList<String>();
  Queue<String> C3q=new LinkedList<String>();

  printer(){
    this.pr=null;
  }
  //
  //To prwto psifio tou kwdikou enos mathimatos upodilwnei
  //tin taksi stin opoia didasketai.
  //To teleutaio psifio upodilwnei to tmima.
  public void printer(Object[][][] pr){
    this.length=pr.length;
    this.width=pr[0].length;
		this.depth=pr[0][0].length;
    for (int y=0;y<this.width;y++){
      for (int x=0; x<this.length; x++){
        for(int z=0;z<this.depth;z++){
          this.pr[x][y][z]=pr[x][y][z];
        }
      }
    }

    for (int y=0;y<this.width;y++){
			for (int x=0; x<this.length; x++){
				for(int z=0;z<this.depth;z++){
          if(pr[x][y][z] instanceof lesson){
            l=(lesson)pr[x][y][z];
            if(l.lcode/1000==1){
              if(l.lcode%10==1)A1q.add(l.lname);
              if(l.lcode%10==2)A2q.add(l.lname);
              if(l.lcode%10==3)A3q.add(l.lname);
            }
            if(l.lcode/1000==2){
              if(l.lcode%10==1)B1q.add(l.lname);
              if(l.lcode%10==2)B2q.add(l.lname);
              if(l.lcode%10==3)B3q.add(l.lname);
            }
            if(l.lcode/1000==3){
              if(l.lcode%10==1)C1q.add(l.lname);
              if(l.lcode%10==2)C2q.add(l.lname);
              if(l.lcode%10==3)C3q.add(l.lname);
            }
          }
        }
      }
    }
  /*  all.add(A1q); all.add(A2q); all.add(A3q);
    all.add(B1q); all.add(B2q); all.add(B3q);
    all.add(C1q); all.add(C2q); all.add(C3q);*/
    File file = new File("/Users/User/programma.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            for(int i=0;i<=A1q.size();i++){
              writer.write(A1q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=A2q.size();i++){
              writer.write(A2q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=A3q.size();i++){
              writer.write(A3q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=B1q.size();i++){
              writer.write(B1q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=B2q.size();i++){
              writer.write(B2q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=B3q.size();i++){
              writer.write(B3q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=C1q.size();i++){
              writer.write(C1q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for(int i=0;i<=C3q.size();i++){
              writer.write(C3q.remove(i)+" ");
              if(i%6==0)writer.write(System.lineSeparator());
            }
            writer.write("***************");
            writer.write(System.lineSeparator());
            for (int x=0; x<this.length; x++){
        			for (int y=0;y<this.width;y++){
                if(this.pr[x][y][1] instanceof teacher) t=(teacher)pr[x][y][1];
                writer.write(t.tname);
                if(x%6==0)writer.write(System.lineSeparator());
              }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


  }
}
