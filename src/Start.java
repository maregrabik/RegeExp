import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {

	//| ( <span class='locality'>(.*)</span> <span class='street-address'> )
	public static void main(String[] args) throws IOException {
	
		//(?<=\\[)(.*?)(?=\\])
		Pattern pattern = Pattern.compile(
				"(?<=\\<span class='fn'>)(.*?)(?=\\</span></h2> <div class=\"slogan\">)|(?<=\\<span class='locality'>)(.*?)(?=\\</span> <span class='street-address'>)|(?<=\\<span class='postal-code'>)(.*?)(?=\\</span> <span class='locality')|(?<=\\<span class='street-address'>)(.*?)(?=\\</span></div> <div class=\"separator_horizontal_listing\"></div>)|(?<=tely\">)(.*?)(?=\\</p>)");

		URL adres = new URL(
				"http://www.pkt.pl/firmy/Zielona+G%C3%B3ra%2C+lubuskie/q_bran%C5%BCa%3A%22Taxi%22/1/?encodedRefinement=subregion..%3D..%22Zielona+G%C3%B3ra%22..%26..Zielona+G%C3%B3ra&display=&dominantCategoryIsLocal=Taxi");
		URLConnection yc = adres.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		
		
		String inputLine;
//		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
//		while (matcher.find()) {
//
//			System.out.print("Start index: " + matcher.start());
//			System.out.print(" End index: " + matcher.end() + " ");
//			System.out.println(matcher.group());
//		
//		}
		
		while ((inputLine = in.readLine()) != null) {
		
			Matcher matcher = pattern.matcher(inputLine);
			while (matcher.find()) {

			//	System.out.print("Start index: " + matcher.start());
				//System.out.print(" End index: " + matcher.end() + " ");
			 if (matcher.group().length()<50)System.out.println(matcher.group());
			
			}
		

		}

	}
}
