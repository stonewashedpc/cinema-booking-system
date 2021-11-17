package utilities;

import java.util.List;

import idManagement.Identifiable;
/**
 * Well, this is something, we can throw away someday
 */
public class ListUtilities {
/**
 * @returns true if and only if list1/2 contain the SAME elements w.r.t. to their id's in the SAME order
 */
	public static <T> boolean sameElements(List<? extends Identifiable> list1, List<? extends Identifiable> list2) {
		if(list1.size()!=list2.size()) return false;
		for (int i = 0; i < list1.size(); i++) if(list1.get(i).getId()!=list2.get(i).getId()) return false;
		return true;
	}
}
