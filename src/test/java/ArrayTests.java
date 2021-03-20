import com.company.circular.NextLetter;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTests {
    @Test
    public void testNextLetter(){
        char[] arr = new char[]{'a', 'c', 'f', 'h'};
        char key = 'f';
        char nextLetter = NextLetter.getNextLetter(arr, key);
        boolean isSame = nextLetter == 'h';
        if(!isSame){
            System.out.println("Required  : 'h'");
            System.out.println("Got  : '" + nextLetter + "'");
            Assert.fail();
        }
    }

    @Test
    public void testMidLeftNotExact(){
        char[] arr = new char[]{'a', 'c', 'f', 'h'};
        char key = 'b';
        char nextLetter = NextLetter.getNextLetter(arr, key);
        boolean isSame = nextLetter == 'c';
        if(!isSame){
            System.out.println("Required  : 'c'");
            System.out.println("Got  : '" + nextLetter + "'");
            Assert.fail();
        }
    }

    @Test
    public void testNextLetter3(){
        char[] arr = new char[]{'a', 'c', 'f', 'h'};
        char key = 'g';
        char nextLetter = NextLetter.getNextLetter(arr, key);
        boolean isSame = nextLetter == 'h';
        if(!isSame){
            System.out.println("Required  : 'h'");
            System.out.println("Got  : '" + nextLetter + "'");
            Assert.fail();
        }
    }

    @Test
    public void testNextLetter4(){
        char[] arr = new char[]{'a', 'c', 'f', 'h'};
        char key = 'm';
        char nextLetter = NextLetter.getNextLetter(arr, key);
        boolean isSame = nextLetter == 'a';
        if(!isSame){
            System.out.println("Required  : 'a'");
            System.out.println("Got  : '" + nextLetter + "'");
            Assert.fail();
        }
    }
    @Test
    public void testNextLetter5(){
        char[] arr = new char[]{'a', 'c', 'f', 'h'};
        char key = 'h';
        char nextLetter = NextLetter.getNextLetter(arr, key);
        boolean isSame = nextLetter == 'a';
        if(!isSame){
            System.out.println("Required  : 'h'");
            System.out.println("Got  : '" + nextLetter + "'");
            Assert.fail();
        }
    }
}
