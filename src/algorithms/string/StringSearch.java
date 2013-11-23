package algorithms.string;

public class StringSearch {
	public boolean KMP(String source, String pattern) {
		boolean result = false;
		int indexSource = -1;
		int indexPattern = 0;
		int sourceLength = source.length();
		int patternLength = pattern.length();
		
		do {
			indexSource++;
			indexPattern = 0;
			
			while (indexPattern < patternLength &&
					source.charAt(indexSource+indexPattern) == pattern.charAt(indexPattern)) {
				indexPattern++;
			}
		} while (indexPattern != patternLength && indexSource != sourceLength-patternLength);

		if (indexPattern == patternLength) {
			result = true;
		}
		
		return result;
	}
}
