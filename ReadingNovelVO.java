package tukorea.web.club.controller;

public class ReadingNovelVO {
	private String num, date, title, review, manage;
	private String year, month, day;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		String[] arr = date.split("-");
		setYear(arr[0]);
		setMonth(arr[1]);
		setDay(arr[2]);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}
}
