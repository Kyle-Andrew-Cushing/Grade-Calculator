import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class grade{

	public static ArrayList<File> getFiles(){//retrieves grade.report files
			File reports = new File(".");
			ArrayList<File> grades = new ArrayList<File>();
			File[] temp = reports.listFiles();

			for(int i=0;i<temp.length;i++){
				grades.add(temp[i]);
			}//end for loop

			ArrayList<File> output = new ArrayList<File>();

			for(int i=0;i<grades.size();i++){
				if(grades.get(i).isDirectory()){
					File direct = grades.get(i);

					temp = direct.listFiles();
					if (temp.length>0){
						for(int j=0;j<temp.length;j++){
							grades.add(temp[j]);
						}//end for loop
					}//end if

				}//end if

				if (grades.get(i).getName().contains("grade.report")){
					output.add(grades.get(i));
				}//end if
			}//end for loop
			
			return output;
	}//end getFiles

	public static void points(ArrayList<File> grades){
		Scanner sc;
		int j;
		String temp;
		int total=0;
		int fullTotal=0;
		for(int i=0;i<grades.size();i++){
			try{
				sc = new Scanner(grades.get(i));
				j=0;
	      		while (sc.hasNextLine()) {
	        		temp=sc.nextLine();
	        		if(temp.contains("Total")){
	        			total+=Integer.parseInt(temp.substring(0,2));
	        		}//end if
	        		else if(temp.contains("points)")){
	        			temp=temp.split("\\(")[1];
	        			temp=temp.split(" ")[0];
	        			fullTotal+=Integer.parseInt(temp);
	        		}//end else if
					j++;
				}//end while loop
			}//end try
			catch(FileNotFoundException e) {
				System.out.print("Error");
			}//end catch

		}//endfor loop
		System.out.println("\nTotal points: "+total+"/"+fullTotal);
	}//end points

	public static void pointsCategories(ArrayList<File> grades){
		Scanner sc;
		int j;
		String temp;

		int assignmentTotal=0;
		int fullTotalA=0;

		int quizTotal=0;
		int fullTotalQ=0;

		int examTotal=0;
		int fullTotalE=0;

		String parentName;

		for(int i=0;i<grades.size();i++){
			try{
				sc = new Scanner(grades.get(i));
				j=0;
	      		while (sc.hasNextLine()) {
	        		temp=sc.nextLine();
        			parentName=grades.get(i).getParent();
        			if (parentName.contains("quiz")){
        				if(temp.contains("Total")){
        					quizTotal+=Integer.parseInt(temp.substring(0,2));
        				}//end if
        				else if(temp.contains("points)")){
	        				temp=temp.split("\\(")[1];
	        				temp=temp.split(" ")[0];
	        				fullTotalQ+=Integer.parseInt(temp);
	        			}//end else if
        			}//end if
        			else if (parentName.contains("exam")){
        				if(temp.contains("Total")){
        					examTotal+=Integer.parseInt(temp.substring(0,2));
        				}//end if
        				else if(temp.contains("points)")){
	        				temp=temp.split("\\(")[1];
	        				temp=temp.split(" ")[0];
	        				fullTotalE+=Integer.parseInt(temp);
	        			}//end else if
        			}//end else if
        			else{
        				if(temp.contains("Total")){
        					assignmentTotal+=Integer.parseInt(temp.substring(0,2));
        				}//end if
        				else if(temp.contains("points)")){
	        				temp=temp.split("\\(")[1];
	        				temp=temp.split(" ")[0];
	        				fullTotalA+=Integer.parseInt(temp);
	        			}//end else if
        			}//end else
					j++;
				}//end while loop
			}//end try
			catch(FileNotFoundException e) {
				System.out.print("Error");
			}//end catch

		}//for loop

		double percentA=0;
		double percentQ=0;
		double percentE=0;

		if(fullTotalA!=0){
			percentA = (double)assignmentTotal/fullTotalA*100;
		}//end if
		if(fullTotalQ!=0){
			percentQ = (double)quizTotal/fullTotalQ*100;
		}//end if
		if(fullTotalE!=0){
			percentE = (double)examTotal/fullTotalE*100;
		}//end if
		System.out.println("\nTotal points: "+(assignmentTotal+quizTotal+examTotal)+"/"+(fullTotalA+fullTotalQ+fullTotalE));
		System.out.println("Assignment points: "+assignmentTotal+"/"+fullTotalA+" | "+percentA+"%");
		System.out.println("Quiz points: "+quizTotal+"/"+fullTotalQ+" | "+percentQ+"%");
		System.out.println("Exam points: "+examTotal+"/"+fullTotalE+" | "+percentE+"%");
	}//end pointsCategories

	public static void percentage(ArrayList<File> grades){
		Scanner sc;
		int j;
		String temp;

		int assignmentTotal=0;
		int fullTotalA=0;

		int quizTotal=0;
		int fullTotalQ=0;

		int examTotal=0;
		int fullTotalE=0;

		String parentName;

		for(int i=0;i<grades.size();i++){
			try{
				sc = new Scanner(grades.get(i));
				j=0;
	      		while (sc.hasNextLine()) {
	        		temp=sc.nextLine();
        			parentName=grades.get(i).getParent();
        			if (parentName.contains("quiz")){
        				if(temp.contains("Total")){
        					quizTotal+=Integer.parseInt(temp.substring(0,2));
        				}//end if
        				else if(temp.contains("points)")){
	        				temp=temp.split("\\(")[1];
	        				temp=temp.split(" ")[0];
	        				fullTotalQ+=Integer.parseInt(temp);
	        			}//end else if
        			}//end if
        			else if (parentName.contains("exam")){
        				if(temp.contains("Total")){
        					examTotal+=Integer.parseInt(temp.substring(0,2));
        				}//end if
        				else if(temp.contains("points)")){
	        				temp=temp.split("\\(")[1];
	        				temp=temp.split(" ")[0];
	        				fullTotalE+=Integer.parseInt(temp);
	        			}//end else if
        			}//end else if
        			else{
        				if(temp.contains("Total")){
        					assignmentTotal+=Integer.parseInt(temp.substring(0,2));
        				}//end if
        				else if(temp.contains("points)")){
	        				temp=temp.split("\\(")[1];
	        				temp=temp.split(" ")[0];
	        				fullTotalA+=Integer.parseInt(temp);
	        			}//end else if
        			}//end else
					j++;
				}//end while loop
			}//end try
			catch(FileNotFoundException e) {
				System.out.print("Error");
			}//end catch

		}//end for loop

		double percentA=1;
		double percentQ=1;
		double percentE=1;

		if(fullTotalA!=0){
			percentA = (double)assignmentTotal/fullTotalA;
		}//end if
		if(fullTotalQ!=0){
			percentQ = (double)quizTotal/fullTotalQ;
		}//end if
		if(fullTotalE!=0){
			percentE = (double)examTotal/fullTotalE;
		}//end if

		double overallPercent=15*1+40*percentA+15*percentQ+30*percentE;

		percentA=0;
		percentQ=0;
		percentE=0;

		if(fullTotalA!=0){
			percentA = (double)assignmentTotal/fullTotalA;
		}//end if
		if(fullTotalQ!=0){
			percentQ = (double)quizTotal/fullTotalQ;
		}//end if
		if(fullTotalE!=0){
			percentE = (double)examTotal/fullTotalE;
		}//end if
		double truePercent=40*percentA+15*percentQ+30*percentE;
		System.out.println("\nOverall Grade: "+overallPercent);
		System.out.println("Current Grade: "+truePercent);
		System.out.println("\nOverall Grade assumes 100% on ungraded categories\nCurrent Grade assumes 0% on ungraded categories");
	}//end percentage

	public static void totalPoints(){
		points(getFiles());
	}//end totalPoints
	public static void catPoints(){
		pointsCategories(getFiles());
	}//end catPoints

	public static void finalGrade(){
		percentage(getFiles());
	}//end finalGrade

	public static void help(){
		System.out.println("total    returns total points irrespective of category");
		System.out.println("points   returns points for each category");
		System.out.println("percent  returns percent grade in class");
	}//end help

	public static void main(String args[]){
		if (args.length>0){
			if(args[0].equals("help")){
				help();
			}//end if
			else if(args[0].equals("total")){
				totalPoints();
			}//end else
			else if(args[0].equals("points")){
				catPoints();
			}//end else if
			else if(args[0].equals("percent")){
				finalGrade();
			}//end else if
			else{
				System.out.println("Error: Invalid argument. Try 'help'.");
			}//end else
		}//end if
		else{
			catPoints();
			finalGrade();
		}//else
	}
}