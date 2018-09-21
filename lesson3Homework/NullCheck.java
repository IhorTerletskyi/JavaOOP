package lesson3Homework;

public interface NullCheck {
	public final static int NOT_NULL = 10;
	
	public static int check (Object first, Object second) {
		if ((first == null) && (second != null)) {
			return 1;
		}
		if ((first != null) && (second == null)) {
			return -1;
		}
		if ((first != null) && (second != null)) {
			return NOT_NULL;
		}
		return 0;
	}

}
