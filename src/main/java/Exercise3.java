
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Exercise3 {

	public static List<Course> printCourses(String fileName) throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader(fileName));
		JSONObject jsonData = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jsonData.get("courses");
		List<Course> courses = new ArrayList<Course>();

		if (jsonArray != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				Course course = new Course();
				if (jsonObject.containsKey("courseId")) {
					course.setCourseId((String) jsonObject.get("courseId"));
				}
				if (jsonObject.containsKey("courseName")) {
					course.setCourseName((String) jsonObject.get("courseName"));
				}
				if (jsonObject.containsKey("instructor")) {
					course.setInstructor((String) jsonObject.get("instructor"));
				}
				if (jsonObject.containsKey("startDate")) {
					course.setStartDate((String) jsonObject.get("startDate"));
				}
				if (jsonObject.containsKey("lessons")) {
					course.setLessons((Long) jsonObject.get("lessons"));
				}
				if (jsonObject.containsKey("level")) {
					course.setLevel((Long) jsonObject.get("level"));
				}
				courses.add(course);
			}
		}
		return courses;
	}

	public static List<Course> filter(List<Course> courses, long level) {
		List<Course> filteredCourses = new ArrayList<Course>();
		for (Course course : courses) {
			Long courseLevel = course.getLevel();
			if (courseLevel != null && courseLevel.longValue() == level) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public static List<Course> filter(List<Course> courses, String instructor) {
		List<Course> filteredCourses = new ArrayList<Course>();
		for (Course course : courses) {
			String courseInstructor = course.getInstructor();
			if (courseInstructor != null && courseInstructor.equalsIgnoreCase(instructor)) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public static List<Course> filter(List<Course> courses, long level, long lessons) {
		List<Course> filteredCourses = new ArrayList<Course>();
		for (Course course : courses) {
			Long couseLevel = course.getLevel(), courseLessons = course.getLessons();
			if (couseLevel != null && couseLevel.longValue() == level && courseLessons != null
					&& courseLessons.longValue() == lessons) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public static List<Course> filterCourse(List<Course> courses, String keyword) {
		List<Course> filteredCourses = new ArrayList<Course>();
		for (Course course : courses) {
			String courseName = course.getCourseName();
			if (courseName != null && courseName.toLowerCase().contains(keyword.toLowerCase())) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public static void main(String[] args) {

		try {

			List<Course> courses = printCourses("data.json");
			System.out.println("Course list: ");
			courses.forEach(System.out::println);

			long level = 1;
			System.out.println("\nFilter courses by level: " + level);
			filter(courses, level).forEach(System.out::println);

			String instructor = "johny";
			System.out.println("\nFilter courses by instructor: " + instructor);
			filter(courses, instructor).forEach(System.out::println);

			long lessons = 6;
			System.out.println("\nFilter courses by level " + level + " and lessons " + lessons);
			filter(courses, level, lessons).forEach(System.out::println);

			String keyword = "API";
			System.out.println("\nFilter courses by keyword in courseName: " + keyword);
			filterCourse(courses, keyword).forEach(System.out::println);

		} catch (IOException | ParseException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
}
