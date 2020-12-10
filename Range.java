import java.util.NoSuchElementException;
public class Range implements IntegerSequence{

  private int start, end, current;

  public Range(int start, int end){
    this.start = start;
    this.end = end;
    current = start;
  }

  public void reset(){
    current = start;
  }

  public int length(){
    return end - start;
  }

  public boolean hasNext(){
    if (end >= current)
      return true;
    return false;
  }

  public int next(){
    if (this.hasNext()){
      current++;
      return current-1;
    }
    else
      throw new NoSuchElementException();
  }

  public static void main (String[] args){
    IntegerSequence r = new Range(10,15);
    while(r.hasNext()){
      System.out.print(r.next());
      if(r.hasNext())
         System.out.print(", ");
    }
  } //expected: 10, 11, 12, 13, 14, 15
}
