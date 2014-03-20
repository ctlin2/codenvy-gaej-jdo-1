package cloud.gae.separate.jdoclasses;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Student {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;

	@Persistent
	private String name;

	@Persistent
	private String studentNo;

	@Persistent
	private Date birthday;

	@Persistent
	private String department;
	
	/**
	 * JDO_8
	 */
	@Persistent(dependent = "true")
	private AddressInfo addressInfo;

	/**
	 * JDO_9
	 */
	//@Persistent(mappedBy = "student")
	@Persistent
	@Element(dependent = "true")
	private List<PhoneNumber> phoneNumbers;
	
	public Student(String name, String studentNo, Date birthday, String department) {
		this.name = name;
		this.studentNo = studentNo;
		this.birthday = birthday;
		this.department = department;
	}

	public Key getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getDepartment() {
		return department;
	}
	
	/**
	 * JDO Example 8 才會用到
	 */
	public AddressInfo getAddressInfo() {
		return addressInfo;
	}
	
	/**
	 * JDO Example 9 才會用到
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void setKey(Key key){
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * JDO Example 8 才會用到
	 */
	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}
	
	/**
	 * JDO Example 9 才會用到
	 */
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
