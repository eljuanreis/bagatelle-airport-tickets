package entity;

import java.time.LocalDate;

public class Passenger {
	private String name;
	private String cpf;
	private String phone;
	private String email;
	private LocalDate birthDate;
	
	public Passenger() {
		super();
	}
	
	public Passenger(String name, String cpf, String phone, String email, LocalDate birthDate) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
