package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {
		ArrayList<String> clues1 = new ArrayList<String>();
		ArrayList<String> clues2 = new ArrayList<String>();
		ArrayList<String> clues3 = new ArrayList<String>();
		String suspect = "";
		String clue1 = clues[0];
		String clue2 = clues[1];
		String clue3 = clues[2];
		ArrayList<String> clueComb12 = new ArrayList<String>();
		for (int i = 0; i < 14; i++) {

			if (train.getHead().getValue().questionPassenger().contains(clue1)) {

				StringBuilder sb = new StringBuilder(train.getHead().getValue().questionPassenger());
				int cut = sb.lastIndexOf("saw");
				String keys = sb.substring(cut, sb.length());

				int namecut = keys.length() - clue1.length();

				String name = keys.substring(4, namecut - 2).toString();
				clues1.add(name);

			}
			if (train.getHead().getValue().questionPassenger().contains(clue2)) {
				StringBuilder sb = new StringBuilder(train.getHead().getValue().questionPassenger());
				int cut = sb.lastIndexOf("saw");
				String keys = sb.substring(cut, sb.length());
				int namecut = keys.length() - clue2.length();
				String name = keys.substring(4, namecut - 2).toString();
				clues2.add(name);

			}
			if (train.getHead().getValue().questionPassenger().contains(clue3)) {
				StringBuilder sb = new StringBuilder(train.getHead().getValue().questionPassenger());
				int cut = sb.lastIndexOf("saw");
				String keys = sb.substring(cut, sb.length());
				int namecut = keys.length() - clue3.length();
				String name = keys.substring(4, namecut - 2).toString();
				clues3.add(name);

			}
			train.setHead(train.getHead().getNext());

		}

		for (int i = 0; i < clues1.size(); i++) {

			if (clues2.contains(clues1.get(i))) {

				clueComb12.add(clues1.get(i));

			}
		}
		for (int i = 0; i < clueComb12.size(); i++) {

			if (clues3.contains(clueComb12.get(i))) {
				suspect = clueComb12.get(i);
			}

		}

		return suspect;

	}

}
