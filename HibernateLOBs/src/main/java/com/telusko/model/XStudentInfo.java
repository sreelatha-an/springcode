package com.telusko.model;


import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="XStudentInfo")
public class XStudentInfo 
{
	@Id	
	@Column(name="XSID")
	@GeneratedValue(generator = "xseq_gen" ,strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="xseq_gen", sequenceName = "my_xseq", initialValue = 1,allocationSize =1 )	
     private Integer xsid;
     
     private String sName;
     
     private String scity;
     
     @Lob
     @Column(length=100000)
     private byte[] image;
     
     @Lob
     @Column(length=100000)
     private char[] textFile;

	public XStudentInfo()
	{
		System.out.println("Zero Param Constructor for Hibernate");
	}
    
	

	@Override
	public String toString() {
		return "StudentInfo [sid=" + xsid + ", sName=" + sName + ", scity=" + scity + ", image=" + Arrays.toString(image)
				+ ", textFile=" + Arrays.toString(textFile) + "]";
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public char[] getTextFile() {
		return textFile;
	}



	public void setTextFile(char[] textFile) {
		this.textFile = textFile;
	}



	public Integer getSid() {
		return xsid;
	}

	public void setSid(Integer sid) {
		this.xsid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	
}
