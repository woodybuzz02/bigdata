package come.todo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
	
	private static final String RESOURCES = "src/main/resources/";
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	public static void main(String[] args) throws Exception{
		// App.java에서 todo-data-simple.txt파일을 읽기 위해서
		// 해당 파일이 위치한 경로를 알아야함.
		
		// package import 단축키 : ctrl + shift + o
		
//		System.out.println(filePath);
		
		// 읽어들인 파일 todo-data-simple.txt의 데이터 수 조회
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfLines = Files.lines(filePath).count();
		System.out.println(numberOfLines);
		
		// Long 타입을 int타입으로 변환
		int rows = numberOfLines.intValue();
		
		// 할 일 번호들을 저장할 Long 타입의 배열, todoNumbers
		Long[] todoNumbers = new Long[rows];
		// 할 일 번호들을 저장할 String 타입의 배열, todoTitles
		String[] todoTitles = new String[rows];
		// 할 일 번호들을 저장할 String 타입의 배열, todoDescriptions
		String[] todoDescriptions = new String[rows];
		// 할 일 날짜들을 저장할 LocalDate 타입의 배열, todoDueDate
		LocalDate[] todoDueDate = new LocalDate[rows];
		
		// 파일 읽기 (java.util.List import)
		List<String> lines = Files.readAllLines(filePath);
		System.out.println(lines); //tab으로 구분되어 있는 것을 TSV라고 한다.
//		System.out.println(lines);
//		System.out.println(lines.size()); // 배열의 길이
		
		int index = 0;
		
		for (String line : lines) {
//			System.out.println(line); // "1	숙제하기	2022-03-05	수학, 영어 숙제" 문자열
//			break; // 반복 종료
			
			final String[] columns = line.split("\t"); // tab으로 구분
//			System.out.println(columns[0] + " " + columns[1] + " " + columns[2] + " " + columns[3]); 
			// 위에서 생성한 배열에 각각 읽어들인 데이터들을 저장
//			
//			// 할 일 번호를 저장할 변수 id 
			final Long id = Long.parseLong(columns[0]);		
//			// 할 일 번호 배열의 인덱스에 순서대로 저장
			todoNumbers[index] = id;
//			
//			// 할 일 제목을 저장할 변수 title
			final String title = columns[1];		
//			// 할 일 제목 배열의 인덱스에 순서대로 저장
			todoTitles[index] = title;
//			
//			// 할 일 날짜를 저장할 변수 dueDate
			final LocalDate dueDate = LocalDate.parse(columns[2], DATE_PATTERN);			
//			// 할 일 날짜 배열의 인덱스에 순서대로 저장
			todoDueDate[index] = dueDate;
//
//			// 할 일 내용을 저장할 변수 description
			final String description = columns[3];			
//			// 할 일 내용의 배열의 인덱스에 순서대로 저장
			todoDescriptions[index] = description;
//			
//			// 인덱스값 1씩 증가
			index++;
		} // forEach() 끝
		
		// 전체 Todos 조회 (일반적인 반복문 활용)
		// 00 번 째로 해야 할 일은 : 00이고, 할 일 내용은  00 입니다. 기한은 00 까지입니다.
		for (int i = 0; i < todoNumbers.length; i++) 
		System.out.println(todoNumbers[i]+"번 째로 해야 할 일은 : "+todoTitles[i]+"이고, 할 일 내용은  "+todoDescriptions[i]+" 입니다. 기한은 "+todoDueDate[i]+" 까지입니다." );
	} // main() 끝
/**
 * for (int i = 0; i < todoNumbers.length; i++) {
			System.out.print(todoNumbers[i] + " 번째로 해야할 일은 : ");
			System.out.print(todoTitles[i] + "이고, 할 일 내용은 ");
			System.out.print(todoDescriptions[i] + " 입니다. 기한은 ");
			System.out.print(todoDueDate[i] + " 까지 입니다.\n");
		}
    
System.out.println(todoNumbers[i] + "번째로 해야할 일은 : " + todoTitles[i]+"이고, 할 일 내용은 "
			+ todoDescriptions[i] + "입니다. 기한은 " + todoDueDate[i].toString() + "까지 입니다.");
 */
} // App.java 끝

