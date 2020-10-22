package nl.sogyo.pandemic.domain;

import java.util.List;

public class Ranklist {
	String name1;
	String score1;
	String name2;
	String score2;
	String name3;
	String score3;
	String name4;
	String score4;
	String name5;
	String score5;
	String name6;
	String score6;
	String name7;
	String score7;
	String name8;
	String score8;
	String name9;
	String score9;
	String name10;
	String score10;

	public Ranklist(List<String> dataBaseList) {
		this.name1 = dataBaseList.get(0);
		this.score1 = dataBaseList.get(1);
		
		this.name2 = dataBaseList.get(2);
		this.score2 = dataBaseList.get(3);
		
		this.name3 = dataBaseList.get(4);
		this.score3 = dataBaseList.get(5);
		
		this.name4 = dataBaseList.get(6);
		this.score4 = dataBaseList.get(7);
		
		this.name5 = dataBaseList.get(8);
		this.score5 = dataBaseList.get(9);
		
		this.name6 = dataBaseList.get(10);
		this.score6 = dataBaseList.get(11);
		
		this.name7 = dataBaseList.get(12);
		this.score7 = dataBaseList.get(13);
		
		this.name8 = dataBaseList.get(14);
		this.score8 = dataBaseList.get(15);
		
		this.name9 = dataBaseList.get(16);
		this.score9 = dataBaseList.get(17);
		
		this.name10 = dataBaseList.get(18);
		this.score10 = dataBaseList.get(19);
	}
	
	public String getName1() {
		return this.name1;
	}
	public String getScore1() {
		return this.score1;
	}
	public String getName2() {
		return this.name2;
	}
	public String getScore2() {
		return this.score2;
	}
	public String getName3() {
		return this.name3;
	}
	public String getScore3() {
		return this.score3;
	}
	public String getName4() {
		return this.name4;
	}
	public String getScore4() {
		return this.score4;
	}
	public String getName5() {
		return this.name5;
	}
	public String getScore5() {
		return this.score5;
	}
	public String getName6() {
		return this.name6;
	}
	public String getScore6() {
		return this.score6;
	}
	public String getName7() {
		return this.name7;
	}
	public String getScore7() {
		return this.score7;
	}
	public String getName8() {
		return this.name8;
	}
	public String getScore8() {
		return this.score8;
	}
	public String getName9() {
		return this.name9;
	}
	public String getScore9() {
		return this.score9;
	}
	public String getName10() {
		return this.name10;
	}
	public String getScore10() {
		return this.score10;
	}
}
