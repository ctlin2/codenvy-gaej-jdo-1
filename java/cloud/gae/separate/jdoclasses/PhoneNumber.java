package cloud.gae.separate.jdoclasses;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class PhoneNumber {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private Student student;

	@Persistent
	private String type;

	@Persistent
	private String number;

	public PhoneNumber(String type, String number) {
		this.type = type;
		this.number = number;
	}

	public Key getKey() {
		return key;
	}

	public String getType() {
		return type;
	}

	public String getNumber() {
		return number;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
