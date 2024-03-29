package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumeber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumeber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumeber() {
		return roomNumber;
	}

	public void setRoomNumeber(Integer roomNumeber) {
		this.roomNumber = roomNumeber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future";
		}
		else if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date.";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	
	@Override
	public  String toString (){
		return "Room"
			+  roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", checkout: "
			+ sdf.format(checkOut)
		    + ", "
		    + duration()
		    + "nights";
	}
	
}













