

public class Course {

	private String courseId;
	private String courseName;
	private String instructor;
	private String startDate;
	private Long lessons;
	private Long level;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Long getLessons() {
		return lessons;
	}

	public void setLessons(Long lessons) {
		this.lessons = lessons;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "{" + "courseId=" + courseId + ", courseName=" + courseName + ", instructor=" + instructor
				+ ", startDate=" + startDate + ", lessons=" + lessons + ", level=" + level + "}";
	}
}
