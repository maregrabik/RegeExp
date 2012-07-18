
public class Firma {
	private String nazwa;
	private String poczta;
	private String miasto;
	private String ulica;
	private String telefon;
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getPoczta() {
		return poczta;
	}
	public void setPoczta(String poczta) {
		this.poczta = poczta;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Firma(String nazwa, String poczta, String miasto, String ulica,
			String telefon) {
		super();
		this.nazwa = nazwa;
		this.poczta = poczta;
		this.miasto = miasto;
		this.ulica = ulica;
		this.telefon = telefon;
	}
	
	
	

}
