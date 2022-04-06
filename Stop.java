import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stop {
	Map<Integer, StopDetals> stopLists;


	public Stop(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		stopLists = new HashMap<Integer, StopDetals>();
		br.readLine();
		String curLine = br.readLine();

		while(curLine != null)
		{
			curLine = curLine.replace(", ", ",");
			String arrayForLine[] = curLine.split(",");
			int stop_id = Integer.valueOf(arrayForLine[0]);
			String stop_code = arrayForLine[1];
			String stop_name = arrayForLine[2];
			String stop_desc = arrayForLine[3];
			double stop_lat = Double.valueOf(arrayForLine[4]);
			double stop_lon = Double.valueOf(arrayForLine[5]);
			String zone_id = arrayForLine[6];
			String stop_url = arrayForLine[7];
			int location_type = Integer.valueOf(arrayForLine[8]);
			String parent_station;
			if(arrayForLine.length == 10)
			{
				parent_station = arrayForLine[9];
			}
			else
			{
				parent_station = "";
			}

			StopDetals det = new StopDetals(stop_id, stop_code, stop_name, stop_desc, stop_lat
					, stop_lon, zone_id, stop_url, location_type, parent_station);

			stopLists.put(stop_id, det);
			curLine = br.readLine();
		}
		br.close();
	}

}
