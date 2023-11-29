package View;

import java.awt.Font;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;

public class AllScheduleFrame extends JFrame{
	private JTextArea ta;
	
	public AllScheduleFrame() {
		setTitle("All Schedule");
		setSize(500,600);
		ta = new JTextArea(20,20);
		ta.setFont(new Font("맑은 고딕",Font.BOLD,14));
		JScrollPane sp = new JScrollPane(ta);
		add(sp);
		printSchedule();
		
		setVisible(true);
	}
	
	private void printSchedule() {
		File directory = new File("src/Data/Database");
        List<File> files = Arrays.asList(directory.listFiles());
        
        // 월 순으로 정렬하기 위해 스트림의 내림차순 정렬을 적용함
        List<File> sortedFiles = files.stream()
                .sorted(Comparator.comparingInt(file -> {
                    String[] parts = file.getName().split("_");
                    return Integer.parseInt(parts[1]);
                }))
                .collect(Collectors.toList());
        
        sortedFiles.forEach(Files -> {
        	ta.append(Files.getName().toString().replaceAll(".txt", "\n"));
			try (BufferedReader br = new BufferedReader(new FileReader("src/Data/Database/"+Files.getName()))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                ta.append(line + "\n");
	            }
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
        });
	}
}
