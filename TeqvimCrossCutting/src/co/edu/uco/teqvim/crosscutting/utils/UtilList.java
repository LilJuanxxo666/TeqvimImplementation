package co.edu.uco.teqvim.crosscutting.utils;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public final class UtilList {
	
	private UtilList() {
        super();
    }
	
	public static <T> List<T> getDefaultList() {
        return new ArrayList<>();
    }
    
    public static <T> boolean isNullOrEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
    
    public static <T> List<T> getDefault(List<T> list, List<T> defaultValue) {
        return isNullOrEmpty(list) ? defaultValue : list;
    }
    
    public static <T> List<T> getDefault(List<T> list) {
        return getDefault(list, Collections.emptyList());
    }

}
