package com.tew.model;

public class Usuario {
	private long email;
	private long passwd;
	private String rol;
	private String nombre;
	public long getEmail() {
		return email;
	}
	public void setEmail(long email) {
		this.email = email;
	}
	public long getPasswd() {
		return passwd;
	}
	public void setPasswd(long passwd) {
		this.passwd = passwd;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
