package main.java.nl.sogyo.pandemic.domain;

import java.util.List;

public class TextArray {
	String id;
	String day;
	String paperTitle;
	String paperContent;
	String buttonsPaper;
	String goToWork;
	String buttonsWork1;
	String buttonsWork2;
	String ifOv;
	String ifBike;
	String afterWork;
	String buttonAw1;
	String buttonAw2;
	
	
	public TextArray(List<String> dataBaseList) {
		this.id = dataBaseList.get(0);
		this.day = dataBaseList.get(1);
		this.paperTitle = dataBaseList.get(2);
		this.paperContent = dataBaseList.get(3);
		this.buttonsPaper = dataBaseList.get(4);
		this.goToWork = dataBaseList.get(5);
		this.buttonsWork1 = dataBaseList.get(6);
		this.buttonsWork2 = dataBaseList.get(7);
		this.ifOv = dataBaseList.get(8);
		this.ifBike = dataBaseList.get(9);
		this.afterWork = dataBaseList.get(10);
		this.buttonAw1 = dataBaseList.get(11);
		this.buttonAw2 = dataBaseList.get(12);
	}
	
	public String getId() {
		return this.id;
	}
	public String getDay() {
		return this.day;
	}
	public String getPaperTitle() {
		return this.paperTitle;
	}
	public String getPaperContent() {
		return this.paperContent;
	}
	public String getButtonsPaper() {
		return this.buttonsPaper;
	}
	public String getGoToWork() {
		return this.goToWork;
	}
	public String getButtonsWork1() {
		return this.buttonsWork1;
	}
	public String getButtonsWork2() {
		return this.buttonsWork2;
	}
	public String getIfOv() {
		return this.ifOv;
	}
	public String getIfBike() {
		return this.ifBike;
	}
	public String getAfterWork() {
		return this.afterWork;
	}
	public String getButtonAw1() {
		return this.buttonAw1;
	}
	public String getButtonAw2() {
		return this.buttonAw2;
	}


}
