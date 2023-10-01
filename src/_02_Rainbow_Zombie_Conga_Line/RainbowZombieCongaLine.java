package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	LinkedList<Zombie>search = congaLine;
    	Node <Zombie> found = new Node<Zombie>(dancer);
    	
    	congaLine.setHead(found);
    	    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	LinkedList<Zombie>search = congaLine;
    	Node <Zombie> found = new Node<Zombie>(dancer);
    	congaLine.setTail(found);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	
    	Node<Zombie> imort = new Node<Zombie>(dancer);
    	Node<Zombie>goTo = new Node<Zombie>(congaLine.getHead().getValue());
    	goTo= congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
		goTo=	goTo.getNext();
			if (i==position) {
			goTo = imort;
			}
		}
    	
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> goTo = new Node<Zombie>(dancer);
    	Node<Zombie> save = null;
    	goTo = congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
			if (goTo.getValue().getZombieHatColor()==dancer.getZombieHatColor()) {
				save = goTo.getPrev();
				congaLine.remove(i);
				goTo = save;
			}
			goTo = goTo.getNext();
		}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node <Zombie>goTo = congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
			if (goTo.getValue().getZombieHatColor()==dancer.getZombieHatColor()) {
				congaLine.remove(i);
				break;
			}
			goTo = goTo.getNext();
		}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Zombie first = new Zombie(dancer.getZombieHatColor());
    	Zombie middle = new Zombie(dancer.getZombieHatColor());
    	Zombie last = new Zombie(dancer.getZombieHatColor());
    	int position = congaLine.size()/2;
    	Node<Zombie> imort = new Node<Zombie>(middle);
    	Node<Zombie>goTo = new Node<Zombie>(middle);
    	goTo= congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
		goTo=	goTo.getNext();
			if (i==position) {
			goTo = imort;
			}
		}
    	Node<Zombie>newT = new Node<Zombie>(last);
    	newT = congaLine.getTail().getNext();
    	Node<Zombie>newH = new Node<Zombie>(first);
    	newT = congaLine.getHead().getPrev();
    	congaLine.setTail(newT);
    	congaLine.setHead(newH);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	Node <Zombie>front = new Node<Zombie>(dancer);
 
    	congaLine.setHead(front);
    	for (int i = 0; i < zombieHats.length; i++) {
    		Zombie color = new Zombie(zombieHats[i]);
			congaLine.add(color);
		}
    	
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
