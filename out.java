public class out {
    public util utilities = new util();
    public static String[] hi = {
        "Hey there. How are ya?", 
        "Hey! I hope you are having a good day!", 
        "Ready to listen to some bangers?", 
        "Ready for some good Music?"
    };
    public static String[] bye = {
        "Bye! Thank you for chatting.", 
        "See you later alligator!", 
        "Bye. I hope to chat with you again!", 
        "Farewell! Come back whenever you need more songs"
    };
    public static String[] empty = {
        "You might have forgotten to type something.", 
        "You didn't type anything.", 
        "I don't see your request", 
        "You didn't type anything."
    };
    String[] next = {
        "What type of music would you like to listen to now?",
        "What kind of music are you in the mood for right now?",
        "Which genre or style of music would you like to explore?",
        "What music would you like to hear at the moment?"
    };
    public static String[] idk = {
        "I don't understand your request. There might be a typo in your request. ", 
        "There might be a typo in your request. Please Double Check your request.", 
        "I couldn't understand your request. Could you make your intents more clear?", 
        "There seems to be somethign wrong with your request. Could you double check your request?"
    };
    public static String[] artist = {
        "Here are some popular songs by",
        "Check out these popular songs from",
        "Here’s a selection of popular tracks by",
        "Take a listen to some popular music from"
    };
    public static String[] genres = {
        "Here are some",
        "Check out these",
        "Here’s a collection of",
        "Take a listen to some"
    };
    public static String[] unknown = {
        "I have never heard of that artist. Please enter a valid artist name.",
        "I'm not familiar with that artist. Could you provide a valid artist name?",
        "That artist doesn’t seem to be in my database. Please try entering another name.",
        "I couldn’t find that artist. Please enter a name I can recognize."
    };
    public static String greeting[] = {
        "Hello, I am MusicMind, your song recommendation bot.",
        "Hi, I'm MusicMind, your personalized song recommender!",
        "Greetings, I'm MusicMind, your go-to bot for music recommendations.",
        "Hello there, I'm MusicMind, and I'm here to suggest songs tailored to your preferences!"
    };
    public static String[] about = {
        "I can suggest songs based on the genres and/or artists you want to listen to. To get a recommendation, simply tell me which genres and/or artists you'd like to explore. I hope you find the perfect music to match your mood!",
        "I'm here to help you discover new music based on the genres and artists you love. Just let me know what you're in the mood for, and I'll find the perfect tracks to match your vibe.",
        "Whether you're into specific genres or artists, I can help you find songs that suit your taste. Simply tell me what you'd like to listen to, and I'll do the rest.",
        "Whether you want recommendations based on genres or artists, just share your choices with me, and I'll make sure you find the perfect tunes for your mood."
    };
    public static int random = 0;
    public String rand(String type) {
        random = (int) (Math.random() * 4);
        if (type.equals("bye")) {
            return bye[random];
        } else if (type.equals("hi")) {
            return hi[random];
        } else if (type.equals("empty")) {
            return empty[random];
        } else if (type.equals("idk")) {
            return idk[random];// + "\nRemember: Spelling is important. If you want an artist, explicitly state them using 'by' (Please things like don't say 'give me some Beethoven').";
        } else if (type.equals("about")) {
            return about[random];
        } else if (type.equals("artist")) {
            return artist[random];
        } else if (type.equals("genres")) {
            return genres[random];
        } else if (type.equals("greeting")) {
            return greeting[random];
        } else if (type.equals("next")) {
            return next[random];
        } else if (type.equals("unknown")) {
            return unknown[random];
        } else {
            return "none";
        }
    }
    public void intro() {
        System.out.println("=================================================================================================================================================");
        System.out.println(rand("hi") + " I am your personal music recommender chatbot, MusicMind. Tell me an artist, genre, or both that you are interested in.");
        System.out.println("Here are some example requests:");
        System.out.println(" - I want to listen to songs by The Weeknd.");
        System.out.println(" - Give me some hiphop music.");
        System.out.println(" - Can you pull up some hiphop music by The Weeknd?");
        System.out.println("To stop chatting with me, you could type 'q'.");
        System.out.println("Spelling is important. If you want an artist, explicitly state them using 'by' (Please things like don't say 'give me some Beethoven').");
        System.out.println("Type below to get started! I look forward to chatting with you!");
        System.out.println("=================================================================================================================================================");
    }
    
    public void pos1(String input) {
        System.out.println("Bot: ");
        int ind = input.indexOf("by");
        String split = input.substring(ind+3);
        String[] result = utilities.fetcher(split).split("; ");
        String[] final1 = new String[10];
        int index = 0;
        for (String elm : result) {
            if ((elm.toLowerCase()).contains(" - " + split) && index < 10) {
                final1[index] = elm;
                index ++;
            }
        }
        if (final1[0] != null) {
            System.out.println(rand("artist") + " " + split + ":");
            for (int i = 0; i < 10 ; i++) {
                if (final1[i] != null) {
                    System.out.println(String.valueOf(i+1) + ". " + final1[i]);
                }
            }
        } else {
            System.out.println(rand("unknown"));
        }
    }

    public void pos2(String obsGenre) {
        System.out.println("Bot: ");
        String[] result = utilities.fetcher(obsGenre).split(";");
        System.out.println(rand("genres") + " " + obsGenre + " songs: ");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(String.valueOf(i+1) + ". " + result[i]);
        }
    }

    public void pos3(String input, String obsGenre) {
        int ind = input.indexOf("by");
        String split = input.substring(ind+3);
        String[] result = utilities.fetcher(obsGenre).split(";");
        String[] final1 = new String[10];
        int index = 0;
        for (String elm : result) {
            if ((elm.toLowerCase()).contains(" - " + split) && index < 10) {
                final1[index] = elm;
                index ++;
            }
        }
        if (final1[0] != null) {
            System.out.println("Bot: ");
            System.out.println(rand("artist") + " " + split + " (" + obsGenre + " songs):");
            for (int i = 0; i < 10 ; i++) {
                if (final1[i] != null) {
                    System.out.println(String.valueOf(i+1) + ". " + final1[i]);
                } else {
                    System.out.println("These are all the songs I found.");
                    break;
                }
            }
        } else {
            System.out.println("Bot: ");
            System.out.println("There were no songs that matched your desired description.");
        }
    }
}
