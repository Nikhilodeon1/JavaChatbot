import java.util.Scanner;
public class musicBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out output = new out();
        util utilities = new util();
        output.intro();
        int a = 0;
        while (a == 0) {
            System.out.println("");
            System.out.print("You: ");
            String input = utilities.cleanString(scanner.nextLine());
            if (input != null) {
                boolean bool1 = (input.contains("by "));
                boolean bool2 = false;
                String obsGenre = "";
                for (String genre : util.genres) {
                    if (input.toLowerCase().contains(genre.toLowerCase())) {
                        bool2 = true;
                        obsGenre = genre;
                        break;
                    }
                }
                if (input.length() == 0) {
                    System.out.println(output.rand("empty") + " Please type atleast 1 letter.");
                } else if (input.equals("q")) {
                    System.out.println(output.rand("bye"));
                    break;
                } else if (input.contains("who") || input.contains("how")  || input.contains("what")) {
                    System.out.println(output.rand("about"));
                    System.out.println("===================================================");
                System.out.println(output.rand("next"));
                } else if (input.equals("wsg") || input.equals("yo")  || input.equals("sup") || input.equals("hello")|| input.equals("hi") || input.equals("hey"))  {
                    System.out.println(output.rand("hi") + " " + output.rand("greeting"));
                    System.out.println("===================================================");
                System.out.println(output.rand("next"));
                } else if (bool1 && bool2)  {
                    output.pos3(input, obsGenre);//user gives artist and genre
                    System.out.println("===================================================");
                System.out.println(output.rand("next"));
                } else if (bool1) {
                    output.pos1(input); //user gives just artist 
                    System.out.println("===================================================");
                System.out.println(output.rand("next"));
                } else if (bool2) {
                    output.pos2(obsGenre); //user gives just genre 
                    System.out.println("===================================================");
                System.out.println(output.rand("next"));
                } else {
                    System.out.println(output.rand("idk"));
                }
            } else {
                System.out.println(output.rand("empty") + " Please type atleast 1 letter.");
            }
        }
        scanner.close();
    }
}
