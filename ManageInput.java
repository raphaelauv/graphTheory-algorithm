import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class ManageInput{
	
	private static void printMemory(String msg) {
		System.out.println(msg+" | Mémoire allouée : " +
		(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) + "octets");
	}
	
	public static void printMemoryStart() {
		printMemory("FIN LECTURE FICHIER + CREATION GRAPH");
	}
	
	public static void printMemoryEND() {
		printMemory("FIN PARCOUR");
	}
	
	public static boolean parseAndFillGraph2(Graph graph, BufferedReader file,boolean oriented) throws IOException {
		String line = "";
		Long nbLine = 0l;
		String[] arrayOfLine;
		int actualId;
		int actualIdNeighbour;
		
		while ((line =file.readLine()) != null) {
			nbLine++;
			if (line.length()==0 || line.charAt(0) == '#') {
				continue;
			}
			
			arrayOfLine = line.split("\\s");
			if(arrayOfLine.length!=2) {
				System.out.println("ERREUR ligne "+nbLine+" format Invalide");
				return false;
			}

			//System.out.println(arrayOfLine[0] +" "+ arrayOfLine[1]);
			try {
				actualId = Integer.parseInt(arrayOfLine[0]);
				actualIdNeighbour = Integer.parseInt(arrayOfLine[1]);
				
				graph.addEdgeModeArray(actualId, actualIdNeighbour);
				//graph.addEdge(actualId, actualIdNeighbour,oriented);
			}catch(NumberFormatException e) {
				System.out.println("ERREUR ligne "+nbLine+" format Invalide");
				return false;
			}
			
		}	
		return true;

	}
	
	public static void missingArgs() {
		System.out.println("il manque arguments");
        System.out.println("Pour exécuter : java Exo2 [nom_du_fichier]");
	}

}
