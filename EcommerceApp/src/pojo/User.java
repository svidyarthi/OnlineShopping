package pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class User {
	 	private String email;	
	 	private String fname;
		private String lname;
	    private String password;
	    private String address1;
	    private String address2;
	    private String city;
	    private String state;
	    private String zip;
	    private String contact_num;
	    private String country;
	    
	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	 
	    public String getPassword() {
	    	return password;
	    }
	 
	    public void setPassword(String password) {
	    	this.password = password;
	    }

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getContact_num() {
			return contact_num;
		}

		public void setContact_num(String contact_num) {
			this.contact_num = contact_num;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
}