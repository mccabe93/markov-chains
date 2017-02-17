import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MarkovChainGenerator {
	private HashMap<String, List<String>> ngrams = new HashMap<String, List<String>>();
	List<String> ngramsArray = new ArrayList<String>();
	List<String> beginnings = new ArrayList<String>();
	Random rng = new Random();
	private int order = 3;
	// assumes a newline file
	public MarkovChainGenerator(String sourceFile, int order) throws IOException {
		List<String> namelist = Utility.returnNewLineFromFile(sourceFile);
		this.order = order;
		for(int i = 0; i < namelist.size(); i++) {
			String name = namelist.get(i);
			for(int j = 0; j < name.length() - order; j++) {
				String gram = name.substring(j, j+order);
				if(j == 0)
					beginnings.add(gram);
				if(ngrams.get(gram) == null)
					ngrams.put(gram, new ArrayList<String>());
				ngrams.get(gram).add(name.substring(j+order,j+order+1));
			}
		}
		// store all the keys in an array so it's easier+more efficient to access them
		ngramsArray = new ArrayList<String>(ngrams.keySet());
	}
	public MarkovChainGenerator(String sourceFile, int order, int seed) throws IOException {
		this(sourceFile, order);
		rng = new Random(seed);
	}
	
	public String getMarkovString(int size) {
		int randBeginningIndex = rng.nextInt(beginnings.size());
		String currentGram = beginnings.get(randBeginningIndex);
		String markov = currentGram;
		for(int i = 0; i < size; i++) {
			List<String> possibilities = ngrams.get(currentGram);
			if(possibilities == null)
				break;
			int randChainIndex =  rng.nextInt(possibilities.size());
			markov += possibilities.get(randChainIndex);
			currentGram = markov.substring(markov.length()-order, markov.length());
		}
		return markov;
	}
}
