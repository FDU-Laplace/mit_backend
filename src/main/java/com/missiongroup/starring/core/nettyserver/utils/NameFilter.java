package com.missiongroup.starring.core.nettyserver.utils;

import java.io.File;
import java.io.FilenameFilter;

public class NameFilter implements FilenameFilter {
	private String prefix;
	private String type;

	public NameFilter(String prefix, String type) {
		this.prefix = prefix;
		this.type = type;
	}

	@Override
	public boolean accept(File dir, String name) {
		File file = new File(name);
		String fileName = file.getName();
		if (prefix == null || prefix.equals("")) {
			return fileName.toLowerCase().endsWith(type.toLowerCase());
		}
		if (type == null || type.equals("")) {
			return fileName.startsWith(prefix);
		}
		return (fileName.startsWith(prefix) && fileName.toLowerCase().endsWith(type.toLowerCase()));
	}
}