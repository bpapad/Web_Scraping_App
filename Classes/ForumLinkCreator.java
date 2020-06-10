package classes;

import java.net.URL;

public class ForumLinkCreator {

    public String forumLink(String ascChoice) throws Exception{
        URL link;
        String stringLink;
        switch (ascChoice) {
            case "Slayer":
                link = new URL("https://www.pathofexile.com/forum/view-forum/40/tag/Slayer");
                break;
            case "Gladiator":
                link = new URL("https://www.pathofexile.com/forum/view-forum/40/tag/Gladiator");
                break;
            case "Champion":
                link = new URL("https://www.pathofexile.com/forum/view-forum/40/tag/Champion");
                break;
            case "Juggernaught":
                link = new URL("https://www.pathofexile.com/forum/view-forum/23/tag/Juggernaut");
                break;
            case "Berserker":
                link = new URL("https://www.pathofexile.com/forum/view-forum/23/tag/Berserker");
                break;
            case "Chieftain":
                link = new URL("https://www.pathofexile.com/forum/view-forum/23/tag/Chieftain");
                break;
            case "Deadeye":
                link = new URL("https://www.pathofexile.com/forum/view-forum/24/tag/Deadeye");
                break;
            case "Raider":
                link = new URL("https://www.pathofexile.com/forum/view-forum/24/tag/Raider");
                break;
            case "Pathfinder":
                link = new URL("https://www.pathofexile.com/forum/view-forum/24/tag/Pathfinder");
                break;
            case "Ascendant":
                link = new URL("https://www.pathofexile.com/forum/view-forum/436/tag/Ascendant");
                break;
            case "Assassin":
                link = new URL("https://www.pathofexile.com/forum/view-forum/303/tag/Assassin");
                break;
            case "Saboteur":
                link = new URL("https://www.pathofexile.com/forum/view-forum/303/tag/Saboteur");
                break;
            case "Trickster":
                link = new URL("https://www.pathofexile.com/forum/view-forum/303/tag/Trickster");
                break;
            case "Inquisitor":
                link = new URL("https://www.pathofexile.com/forum/view-forum/41/tag/Inquisitor");
                break;
            case "Hierophant":
                link = new URL("https://www.pathofexile.com/forum/view-forum/41/tag/Hierophant");
                break;
            case "Guardian":
                link = new URL("https://www.pathofexile.com/forum/view-forum/41/tag/Guardian");
                break;
            case "Necromancer":
                link = new URL("https://www.pathofexile.com/forum/view-forum/22/tag/Necromancer");
                break;
            case "Occultist":
                link = new URL("https://www.pathofexile.com/forum/view-forum/22/tag/Occultist");
                break;
            default: //(ascChoice.equals("Elementalist"))
                link = new URL("https://www.pathofexile.com/forum/view-forum/22/tag/Elementalist");
                break;
        }
        stringLink = link.toString();


        return stringLink;
    }
}
