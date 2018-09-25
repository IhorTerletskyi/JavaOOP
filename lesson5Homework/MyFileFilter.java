package lesson5Homework;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
	private String[] extentions;

	public MyFileFilter(String... extentions) {
		super();
		this.extentions = extentions;
	}

	private boolean check(String ext) {
		for (String stringExt : extentions) {
		    if (stringExt.equals(ext)) {
		        return true;
		    }
		} 
		return false;
	}

	@Override
	public boolean accept(File name) {
		int pointerIndex = name.getName().lastIndexOf(".");
		if (pointerIndex == -1) {
		    return false;
		}
		String ext = name.getName().substring(pointerIndex + 1);
		return check(ext);
	}

}
