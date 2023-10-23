package PRG.kakao.blind;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 추석트래픽 {
	public int solution(String[] lines) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		int answer = 0;
		for(String str : lines){
			String[] info = str.split(" ");
			String time = info[1];

			Date dt = format.parse(time);
			long startLimitTime = dt.getTime() ;
			long endLimitTime = dt.getTime() + 999;
			int cnt = 0;

			for(int i = 0 ; i<lines.length ; i++){
				String[] logInfo = lines[i].split(" ");
				String logDate = logInfo[0];
				String logTime = logInfo[1];
				String processTime =  logInfo[2].substring(0,logInfo[2].length()-1); // 0.8
				Date date = format.parse(logTime);

				long start_time = date.getTime() - (long)(Double.parseDouble(processTime)*1000) + 1 ;
				long end_time = date.getTime();

				if(end_time <= endLimitTime && end_time >= startLimitTime){
					cnt++;
				}else if(start_time <= endLimitTime && start_time >= startLimitTime){
					cnt++;
				}else if(start_time <= startLimitTime && end_time >= endLimitTime){
					cnt++;
				}

				if(cnt > answer){
					answer = cnt;
				}
			}
		}


		return answer;
	}

	public static void main(String[] args) throws ParseException {
		추석트래픽 sol = new 추석트래픽();
		String[] str = {"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"};

		System.out.println(sol.solution(str));
	}
}
