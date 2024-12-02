import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class util {

    public static String[] genres = {
        "Pop", "Rock", "Hip Hop", "Jazz", "Classical", "Electronic", "Reggae", "Blues",
        "Country", "R&B", "Folk", "Punk", "Metal", "Soul", "Disco", "Gospel", "K-Pop", 
        "Latin", "House", "Techno", "Dubstep", "Trap", "Trance", "Indie", "Grunge", 
        "Ska", "Ambient", "Soundtrack", "Afrobeats", "Dancehall", "Salsa", "Bollywood", 
        "Opera", "Chillwave", "EDM", "Rap", "hiphop", "J-pop", ""
    };

    public String fetcher(String input) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "fetcher.py");
            Process process = processBuilder.start();
            try (OutputStream stdin = process.getOutputStream()) {
                stdin.write(input.getBytes());
                stdin.flush();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            String pythonOutput = output.toString();
            return pythonOutput;
        } catch (Exception e) {
            return "ERROR!";
        }
    }

    public String cleanString(String input) {
        if (input == null || input.isEmpty()) {
            return ""; 
        }
        String cleaned = input.trim();
        cleaned = cleaned.replaceAll("\\s+", " ");
        cleaned = cleaned.toLowerCase();
        cleaned = cleaned.replaceAll("[^a-zA-Z0-9\\s]+$", "");
        return cleaned;
    }
}
