package com.lap.intercorp.challenge.intercorpchallenge.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

   @GeneratedValue(strategy = GenerationType.AUTO)
   private @Id Long id;
   private String nombre;
   private String apellido;
   private int edad;
   private Date fechaNacimiento;
   public Client(){
	   
   }
   public Client(String nombre, String apellido, int edad, Date fechaNacimiento) {
	   this.nombre = nombre;
	   this.apellido = apellido;
	   this.edad = edad;
	   this.fechaNacimiento = fechaNacimiento;
   }
   
   
   
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public Date getFechaNacimiento() {
	return fechaNacimiento;
}
public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
	result = prime * result + edad;
	result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Client other = (Client) obj;
	if (apellido == null) {
		if (other.apellido != null)
			return false;
	} else if (!apellido.equals(other.apellido))
		return false;
	if (edad != other.edad)
		return false;
	if (fechaNacimiento == null) {
		if (other.fechaNacimiento != null)
			return false;
	} else if (!fechaNacimiento.equals(other.fechaNacimiento))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}


@Override
public String toString() {
	return "Client [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
			+ ", fechaNacimiento=" + fechaNacimiento + "]";
}
   
}
