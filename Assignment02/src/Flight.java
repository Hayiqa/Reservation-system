public class Flight{
	
	private String plane_no, origin, dest, date, time, traveleclass,travelbclass,type,flighttype;
	

	private int[] reservation = new int[80];
	
	public Flight(String plane_no,String origin,String dest,String date,String time,String Traveleclass,String TravelbClass,String type,String flighttype)
	{
		
		this.plane_no = plane_no;
		this.origin = origin;
		this.dest = dest;
		this.date = date;
		this.time = time;
		traveleclass = Traveleclass;
		travelbclass = TravelbClass;
		this.type = type;
		this.flighttype = flighttype;
		
	}

	

	public String getPlane_no() {
		return plane_no;
	}

	public void setPlane_no(String plane_no) {
		this.plane_no = plane_no;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTraveleclass() {
		return traveleclass;
	}

	public void setTraveleclass(String traveleclass) {
		this.traveleclass = traveleclass;
	}

	public String getTravelbclass() {
		return travelbclass;
	}

	public void setTravelbclass(String travelbclass) {
		this.travelbclass = travelbclass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlighttype() {
		return flighttype;
	}

	public void setFlighttype(String flighttype) {
		this.flighttype = flighttype;
	}



	public int[] getReservation() {
		return reservation;
	}



	public void setReservation(int[] reservation) {
		this.reservation = reservation;
	}
	
	public void setReservationIndex(int position,int num) {
		for(int i = 0; i < 80;i++)
		{
		     if(i == position)
		     {
		    	 reservation[i] = num;
		     }
		}
	}
	public void DeleteReservationIndex(int position,int num) {
		for(int i = 0; i < 80;i++)
		{
		     if(i == position)
		     {
		    	 reservation[i] = num;
		     }
		}
	}

	
}