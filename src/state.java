import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class state implements Comparable<state>{
	Object[][][] prog;
	lesson l,ltemp;
	teacher t,ttemp;
	int length=0;
	int width=0;
	int depth=0;
	int emptyTileRow=0;
	int emptyTileColumn=0;
	int emptyTileDepth=0;
	int score=-1;
	public state father=null;
	//state initiate
	public state(Object[][][] prog){
		this.length=prog.length;

		this.width=prog[0].length;
		this.depth=prog[0][0].length;

		this.prog=new Object[this.length][this.width][this.depth];
		for (int x=0; x<this.length; x++){
			for (int y=0;y<this.width;y++){
				for(int z=0;z<this.depth;z++){
					if (this.prog[x][y][z]==null) {
						this.emptyTileColumn=x;    //
						this.emptyTileRow=y;       // suntetagemenes kenou
						this.emptyTileDepth=z;     //
					}
					this.prog[x][y][z]=prog[x][y][z];
 				}
 			}
		}
	}

  public Object[][][] get_prog(){
		return this.prog;
	}

	public int get_length(){
		return this.length;
	}

	public int get_width(){
		return width;
	}

	public int get_depth(){
		return depth;
	}

	public int getEmptyTileRow()
	{
		return this.emptyTileRow;
	}

	public int getEmptyTileColumn()
	{
		return this.emptyTileColumn;
	}

	public int getEmptyTileDepth(){
		return this.emptyTileDepth;
	}
	//oi dunates kiniseis kounontas to keno
	public boolean moveUp(){
		if(this.emptyTileRow==0) return false;

		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = this.prog[this.emptyTileColumn][this.emptyTileRow-1][this.emptyTileDepth];
		this.emptyTileRow--;
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = null;
		return true;
	}

	public boolean moveDown()
	{
		if(this.emptyTileRow == this.width - 1)
		{
			return false;
		}
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = this.prog[this.emptyTileColumn][this.emptyTileRow+1][this.emptyTileDepth];
		this.emptyTileRow++;
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = null;
		return true;
	}

	public boolean moveLeft()
	{
		if(this.emptyTileColumn == 0)
		{
			return false;
		}
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = this.prog[this.emptyTileColumn-1][this.emptyTileRow][this.emptyTileDepth];
		this.emptyTileColumn--;
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] =null;
		return true;
	}

	public boolean moveRight()
	{
		if(this.emptyTileColumn == this.length - 1)
		{
			return false;
		}
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = this.prog[this.emptyTileColumn+1][this.emptyTileRow][this.emptyTileDepth];
		this.emptyTileColumn++;
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] =null;
		return true;
	}

	public boolean moveIn(){
		if(this.emptyTileDepth == this.depth-1)
		{
			return false;
		}

		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth+1];
		this.emptyTileDepth++;
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = null;
		return true;
	}

	public boolean moveOut(){
		if(this.emptyTileDepth ==0)
		{
			return false;
		}
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth-1];
		this.emptyTileDepth--;
		this.prog[this.emptyTileColumn][this.emptyTileRow][this.emptyTileDepth] = null;
		return true;
	}
	//Generates the children states.
	public ArrayList<state> getChildren(){

		ArrayList<state> children=new ArrayList<state>();
		state child=new state(this.prog);
		if(child.moveUp()){
			child.swap();
			child.heuristic();
			children.add(child);
			child=new state(this.prog);
		}
		if(child.moveDown()){
			child.swap();
			child.heuristic();
			children.add(child);
			child=new state(this.prog);
		}
		if(child.moveLeft()){
			child.swap();
			child.heuristic();
			children.add(child);
			child=new state(this.prog);
		}
		if(child.moveRight()){
			child.swap();
			child.heuristic();
			children.add(child);
			child=new state(this.prog);
		}
		if(child.moveIn()){
			child.swap();
			child.heuristic();
			children.add(child);
			child=new state(this.prog);
		}
		if(child.moveOut()){
			child.swap();
			child.heuristic();
			children.add(child);
			child=new state(this.prog);
		}

		return children;
	}
	//Kathe katastasi exei ena score to opoio auksanetai analoga tous
	//periorismous pou den kaluptontai.
	public void heuristic(){

		/*for (int x=0; x<this.length; x++){
			for (int y=0;y<this.width;y++){
				for(int z=0;z<this.depth;z++){

					if(prog[x][y][z] instanceof lesson){
						l=(lesson)prog[x][y][z];
						l.lcount++;
					}
					if(prog[x][y][z] instanceof teacher){
						t=(teacher)prog[x][y][z];
						t.tcount++;
					}
				}
			}
		}*/

		//Elegxei tin swsti antistoixisi twn kathigitwn me ta mathimata pou
		//mporoun na didaksoun
		for (int x=0; x<this.length; x++){
			for (int y=0;y<this.width;y++){
				//for(int z=0;z<this.depth;z++){
					if(prog[x][y][1] instanceof teacher){
						t=(teacher)prog[x][y][1];
						l=(lesson)prog[x][y][0];
						if(!t.tlessons.contains(l)) score*=2;
				  }
				//}
			}
		}
		//Elegxei an enas kathigitis emfanizetai se duo theseis stin idia wra.
		//Antistoixa kai gia ta mathimata.
		for (int y=0;y<this.width;y++){
			for (int x=0; x<this.length; x++){
				for(int z=0;z<this.depth;z++){
					if(prog[x][y][z]==null)continue;
					if(prog[x][y][z] instanceof lesson){
						l=(lesson)prog[x][y][z];
						if(y<7){
						if(prog[x][y+1][0]==null)score+=2;		//an uparxei keno meta to mathima score++
						}
						for (int k=0; k<this.length; k++){
							if(prog[k][y][0]==null)break;
							if(prog[k][y][0] instanceof lesson)ltemp=(lesson)prog[k][y][0];
							if(ltemp==null)break;
							if(l.lcode==ltemp.lcode) score+=5;
						}
					}
					if(prog[x][y][z] instanceof teacher){
						t=(teacher)prog[x][y][z];
						if(y<7){
							if(prog[x][y+1][z] instanceof teacher && prog[x][y+2][z] instanceof teacher){//
								if(prog[x][y+1][z]==null ||prog[x][y+2][z]==null )continue;//
							teacher ttemp=(teacher)prog[x][y+1][z];						//
							teacher ttemp2=(teacher)prog[x][y+2][z];					//Elegxei an enas kathigitis
							if(t.tcode==ttemp.tcode && t.tcode==ttemp2.tcode)score++;		//emfanizetai treis sunexomenes wres.
							}
						}
						for (int k=0; k<this.length; k++){
							if(prog[k][y][1]==null)break;
							if(prog[k][y][1] instanceof teacher )ttemp=(teacher)prog[k][y][1];
							if(ttemp==null)break;
							if(t.tcode==ttemp.tcode) score+=5; //an o kathigitis emfanizetai duo fores tin idia wra
						}
					}
				}
			}
		}
	}
	//epanaferei ta mathimata sto panw epipedo kai tous kathigites sto katw
	//wste na mporei na ginei pio eukola i sugkrisi kai to print;
	public void swap(){
		for (int x=0; x<this.length; x++){
			for (int y=0;y<this.width;y++){
				/*if(prog[x][y][0]==null || prog[x][y][1]==null)
				{
					if(prog[x][y][1]==null && prog[x][y][0] instanceof lesson)continue;
					if(prog[x][y][0]==null && prog[x][y][1] instanceof teacher)continue;
					if(prog[x][y][0]==null && prog[x][y][1] instanceof lesson)prog[x][y][0]=prog[x][y][1];prog[x][y][1]=null;
					if(prog[x][y][1]==null && prog[x][y][0] instanceof teacher)prog[x][y][1]=prog[x][y][0];prog[x][y][0]=null;
				}*/
					Object temp=prog[x][y][1];
					prog[x][y][1]=prog[x][y][0];
					prog[x][y][0]=temp;
				}
			}
		}



	//sugkrisi twn katastasewn me vasi to score tous
	@Override
	public int compareTo(state s)
	{
		return Integer.compare(this.score, s.score);
	}

	public int get_sums(){
		int sum1=0;
		int sum2=0;
		for (int x=0; x<this.length; x++){
			for (int y=0;y<this.width;y++){
				for(int z=0;z<this.depth;z++){
					if(prog[x][y][z] instanceof teacher){
						t=(teacher)prog[x][y][z];
						sum1+=((x^y)^z)*t.tcode;
					}
					if(prog[x][y][z] instanceof lesson){
						l=(lesson)prog[x][y][z];
						sum2+=((x^y)^z)*l.lcode;
					}
				}
			}
		}
		return sum1+sum2;
	}

	@Override
	public int hashCode(){
		return this.get_sums();
	}

}
