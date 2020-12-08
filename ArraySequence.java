import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{

  private int currentIndex;
  private int data[];

  public ArraySequence(int other[]){
    this.data = other;
    this.currentIndex = 0;
  }

  public void reset(){
    this.currentIndex = 0;
  }

  public int length(){
    return (this.data).length;
  }

  public boolean hasNext(){
    return (this.length() > this.currentIndex);
  }

  public int next(){
    if (!this.hasNext())
      throw new NoSuchElementException("Element not found");
    currentIndex++;
    return data[currentIndex - 1];
  }
/*
  public ArraySequence(IntegerSequence otherseq){

  }
*/
  public static void main(String[] args){
    int[] nums = {1,3,5,0,-1,3,9};
    IntegerSequence as = new ArraySequence(nums);

    System.out.println("ArraySequence(array):");
    while(as.hasNext()){
      System.out.print(as.next() + ", ");
    }
  } //expected 1, 3, 5, 0, -1, 3, 9,
}
