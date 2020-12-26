import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{

  private int currentIndex;
  private int[] data;

  public void reset(){
    currentIndex = 0;
  }

  public int length(){
    return data.length;
  }

  public boolean hasNext(){
    return (data.length > currentIndex);
  }

  public int next(){
    if (!this.hasNext())
      throw new NoSuchElementException("Element not found");
    else{
      currentIndex++;
      return data[currentIndex - 1];
    }
  }

  public ArraySequence(int[] other){
    data = new int[other.length];
    for (int i = 0; i < other.length; i++)
      data[i] = other[i];
    currentIndex = 0;
  }

  public ArraySequence(IntegerSequence otherseq){
    data = new int[otherseq.length()+1];
    int count = 0;
      while (otherseq.hasNext()) {
        try {
          data[count] = otherseq.next();
          count++;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No element here. Set to 0");
        }
    }
    currentIndex = 0;
    otherseq.reset();
  }

  public static void main(String[] args){
    int[] nums = {1, 3, 5, 0, -1, 3, 9};
    IntegerSequence as = new ArraySequence(nums);

    System.out.println("ArraySequence(array):");
    while(as.hasNext()){
      System.out.print(as.next() + ", ");
    } //expected 1, 3, 5, 0, -1, 3, 9,
    System.out.println();
//-------------------------------------------------
    IntegerSequence r = new Range(10,20);
    IntegerSequence to = new ArraySequence(r);

    System.out.println("ArraySequence(seq):");
    while(to.hasNext()){
      System.out.print(to.next() + ", ");
    }
    System.out.println();
    }
}
