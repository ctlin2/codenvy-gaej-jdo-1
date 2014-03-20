package cloud.gae.separate.jdoclasses;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class AddressInfo {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
    private Student student;
	
	@Persistent
	private String zipCode;

	@Persistent
	private String address;

	public AddressInfo(String zipCode, String address) {
		this.zipCode = zipCode;
		this.address = address;
	}

	public Key getKey() {
		return key;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
