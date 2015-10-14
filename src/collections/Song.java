package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Override toString : to print the object in your required format.
 * Implements Comparable : to be able to call Collections.sort()
 * 		which takes objects which has implemented Comparable to be able to sort.
 */
public class Song implements Comparable<Song>{
	String title;
	String album;
	public Song(String title,String album) {
		this.title = title;
		this.album = album;
	}

	@Override
	public String toString() {
		return "The song is \"" + this.title + "\"";
	}
	@Override
	public int compareTo(Song arg0) {
		return 0;
	}
	public static void main(String [] argv)
	{
		Song s1 = new Song("Keh dum tumhe","Kishore Fabs");
		System.out.println(s1);
		List<Song> l1 = new ArrayList<Song>() ;
		Collections.sort(l1);
	}
}
