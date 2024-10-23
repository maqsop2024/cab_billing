package com.cab_billing.entity;


public class Booking {
		private int bookingId;
		private String fromLocation;
		private String toLocation;
		private String cabType;
		public int getBookingId() {
			return bookingId;
		}
		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}
		public String getFromLocation() {
			return fromLocation;
		}
		public void setFromLocation(String fromLocation) {
			this.fromLocation = fromLocation;
		}
		public String getToLocation() {
			return toLocation;
		}
		public void setToLocation(String toLocation) {
			this.toLocation = toLocation;
		}
		public String getCabType() {
			return cabType;
		}
		public void setCabType(String cabType) {
			this.cabType = cabType;
		}
		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation
					+ ", cabType=" + cabType + "]";
		}
		
}
