
public class Admin {

	private String ID,name,age,gender,Address;

	public Admin(String id, String name,String age,String gender,String Address ) {
		ID = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.Address = Address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


}