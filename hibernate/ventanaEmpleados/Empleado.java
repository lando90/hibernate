package ventanaEmpleados;

import java.io.Serializable;
import java.sql.*;

public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String departamento;
	private float salario;
	private Timestamp fechaIni;
	private Timestamp fechaFin;
	
	public Empleado(){
		
	}
	public Empleado(int id, String fname, String appe, String email,String departamento,float salario,Timestamp fechaIni){
		this.id = id;
		this.nombre=fname;
		this.apellido=appe;
		this.email=email;
		this.departamento=departamento;
		this.salario=salario;
		this.fechaIni=fechaIni;
	}
	
	public void setId(int id){
		this.id=id;
	}

	public int getID(){
		return id;
	}
	public void setSalario(float salario){
		this.salario=salario;
	}

	public float getSalario(){
		return salario;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getNombre(){
		return nombre;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}

	public String getApellido(){
		return apellido;
	}
		public void setEmail(String email){
		this.email=email;
	}

	public String getEmail(){
		return email;
	}
		public void setDepartamento(String departamento){
		this.departamento=departamento;
	}

	public String getDepartamento(){
		return departamento;
	}

	public void setFechaIni(Timestamp fechaIni){
		this.fechaIni=fechaIni;
	}

	public Timestamp getFechaIni(){
		return fechaIni;
	}
	public void setFechaFin(Timestamp fechaFin){
		this.fechaFin=fechaFin;
	}

	public Timestamp getFechaFin(){
		return fechaFin;
	}
}