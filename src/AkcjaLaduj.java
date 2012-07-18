import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;


public class AkcjaLaduj implements ActionListener  {
	
	private GlowneOkno okno;
	private List<Firma> bazaFirm;
	private String nazwa,poczta,miasto,ulica,telefon;
	
	public AkcjaLaduj(GlowneOkno okno,List<Firma> bazaFirm) {
		super();
		this.okno=okno;
		this.bazaFirm=bazaFirm;
		
	
	}

	public void actionPerformed(ActionEvent e) {
		Pattern pattern = Pattern.compile(
		"(?<=\\<span class='fn'>)(.*?)(?=\\</span></h2> <div class=\"slogan\">)|(?<=\\<span class='locality'>)(.*?)(?=\\</span> <span class='street-address'>)|(?<=\\<span class='postal-code'>)(.*?)(?=\\</span> <span class='locality')|(?<=\\<span class='street-address'>)(.*?)(?=\\</span></div> <div class=\"separator_horizontal_listing\"></div>)|(?<=tely\">)(.*?)(?=\\</p>)");

		try {
			int i=0;
			String inputLine;
			URL adres = new URL(
					"http://www.pkt.pl/firmy/Zielona+G%C3%B3ra%2C+lubuskie/q_bran%C5%BCa%3A%22Taxi%22/1/?encodedRefinement=subregion..%3D..%22Zielona+G%C3%B3ra%22..%26..Zielona+G%C3%B3ra&display=&dominantCategoryIsLocal=Taxi");
			URLConnection yc = adres.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {

				//	System.out.print("Start index: " + matcher.start());
					//System.out.print(" End index: " + matcher.end() + " ");
				 if (matcher.group().length()<80) {
					
					if (i==0){nazwa=matcher.group();}
					if (i==1){poczta=matcher.group();}
					if (i==2){miasto=matcher.group();}
					if (i==3){ulica=matcher.group();}							
					if (i==4){telefon=matcher.group();}
					i++;
				 }
				 if (i==5){i=0;bazaFirm.add(new Firma(nazwa,poczta,miasto,ulica,telefon));}
				
				
					
				}
				
			}
			for (Firma f : bazaFirm) {
				System.out.println(f.getNazwa());
				System.out.println(f.getPoczta());
				System.out.println(f.getMiasto());			
				System.out.println(f.getUlica());
				System.out.println(f.getTelefon());
				System.out.println("------------------------");
			}
			
			int j=0;
			for(Firma f: bazaFirm){
				
			okno.getPanel().getTable().setValueAt(f.getNazwa(), j, 0);
			okno.getPanel().getTable().setValueAt(f.getPoczta(), j, 1);
			okno.getPanel().getTable().setValueAt(f.getMiasto(), j, 2);	
			okno.getPanel().getTable().setValueAt(f.getUlica(), j,3);
			okno.getPanel().getTable().setValueAt(f.getTelefon(),j,4);
			j++;	
			}
			
			okno.getPanel().getTable().setSize(10, bazaFirm.size());
			okno.setVisible(false);
			okno.add(okno.getPanel());
			okno.setVisible(true);
			
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		

	}

}
