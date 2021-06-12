import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class programma{


  ArrayList<state> states;
  HashSet<state> closedSet;

  programma(){
    this.states=null;
    this.closedSet=null;
  }

  public state ImplementClosedSet(state initialState){
    this.states = new ArrayList<state>();
    this.closedSet=new HashSet<state>();   //set me tis states pou exoun paraxthei.
    this.states.add(initialState);
    while(this.states.size()>0){
      state currentState=this.states.remove(0); 
      if(currentState.score==0) return currentState;
      if(!closedSet.contains(currentState))
			{
				this.closedSet.add(currentState);
				this.states.addAll(currentState.getChildren());
				Collections.sort(this.states); //Sorting analoga to score.
			}
    }
    return null;
  }
}
