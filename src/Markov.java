import java.io.IOException;

public class Markov {
	public static void main(String[] args) {
		int numOutputs = args.length < 4 ? 10 : Integer.parseInt(args[3]);
		try {
			MarkovChainGenerator mcg = new MarkovChainGenerator(args[0], Integer.parseInt(args[1]));
			for(int i = 0; i < numOutputs; i++) 
				System.out.println(mcg.getMarkovString(Integer.parseInt(args[2])));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
