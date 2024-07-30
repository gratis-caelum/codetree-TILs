import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class WeatherData {
    LocalDate date;
    String dayOfWeek;
    String weather;

    WeatherData(String date, String dayOfWeek, String weather) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDate.parse(date, formatter);
        this.dayOfWeek = dayOfWeek;
        this.weather = weather;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); 

        WeatherData[] weatherData = new WeatherData[n];

        // 날씨 정보 입력
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String date = parts[0];
            String dayOfWeek = parts[1];
            String weather = parts[2];
            weatherData[i] = new WeatherData(date, dayOfWeek, weather);
        }

        // 가장 가까운 비가 오는 날 찾기
        WeatherData nearestRainyDay = null;
        for (WeatherData data : weatherData) {
            if (data.weather.equals("Rain")) {
                if (nearestRainyDay == null || data.date.isBefore(nearestRainyDay.date)) {
                    nearestRainyDay = data;
                }
            }
        }

        // 결과 출력
        if (nearestRainyDay != null) {
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println(nearestRainyDay.date.format(outputFormatter) + " " + nearestRainyDay.dayOfWeek + " " + nearestRainyDay.weather);
        }
    }
}