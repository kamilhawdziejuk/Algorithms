package Common;

import java.util.*;

public class Students {

	public static int run(int[] student_list) {
		
		if (student_list == null) return 0;
		
		int n = student_list.length;
		int single_student_number = 0;

		for (int i = 0; i < n; i++)
		{
			single_student_number ^= student_list[i];
		}
		
		return single_student_number;
	}
	
}
