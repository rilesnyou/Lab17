
public class Countries {
	
	private String place;

	public Countries() {
		
	}
	
	public Countries(String place) {
		super();
		this.place = place;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Countries [place=" + place + "]";
	}
	


}