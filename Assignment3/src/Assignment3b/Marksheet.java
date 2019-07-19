package Assignment3b;

import java.util.List;

public class Marksheet {
	Double grades;

		public Marksheet(Double grades) {
			super();
			this.grades = grades;
		}


		public Marksheet() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * Calculate Average of grades
		 * @param gradeList list of grades
		 * @return average of grade that is sum of grade/total no. student
		 */
		public double AverageGrade(List<Marksheet> gradeList){
			Integer totalGrades=gradeList.size();
			double gradeSum=0;
			try{
				for(Marksheet grade:gradeList){
					gradeSum+=grade.grades;
				}

			}catch(ArithmeticException ex){
				System.out.println("Arithmetic Exception Occurs");
			}
			return gradeSum/totalGrades;
		}

		/**
		 * Find maximum grade.
		 * @param gradeList list of grades.
		 * @return maximum value present in gradeList.
		 */
		public double MaxGrade(List<Marksheet> gradeList){
			Marksheet mark=gradeList.get(0);
			double maxGrade=mark.grades;
			try{
				for(Marksheet grade:gradeList){
					if(maxGrade<grade.grades)
						maxGrade=grade.grades;
				}
			}catch(ArithmeticException ex){
				System.out.println("Arithmetic Exception Occurs");
			}
			return maxGrade;
		}

		/**
		 * Find minimum grade.
		 * @param gradeList list of grades.
		 * @return minimum value present in gradeList.
		 */
		public double MinGrade(List<Marksheet> gradeList){
			Marksheet mark=gradeList.get(0);
			double minGrade=mark.grades;
			try{
				for(Marksheet grade:gradeList){
					if(minGrade>grade.grades)
						minGrade=grade.grades;
				}
			}catch(ArithmeticException ex){
				System.out.println("Arithmetic Exception Occurs");
			}
			return minGrade;
		}

		/**
		 * Find percentage of student passed that is grade>=40.
		 * @param gradeList List of Grades.
		 * @return percentage of student passed.
		 */
		public double StudentPassed(List<Marksheet> gradeList){
			double studentPassed=0;
			Integer totalStudents=gradeList.size();
			try{
				for(Marksheet grade:gradeList){
					if(grade.grades>=40)
						studentPassed++;
				}
			}catch(ArithmeticException ex){
				System.out.println("Arithmetic Exception Occurs");
			}
			return (studentPassed/totalStudents)*100;
		}


}
