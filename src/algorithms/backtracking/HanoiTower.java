package algorithms.backtracking;

public class HanoiTower {
	public String hanoi(int nDisks, int fromPeg, int toPeg) {
		if (nDisks == 1) {
			return fromPeg + "->" + toPeg + "\n";
		} else {
			int helpPeg = 6 - fromPeg - toPeg;
			String step1 = hanoi(nDisks - 1, fromPeg, helpPeg);
			String step2 = fromPeg + "->" + toPeg + "\n";
			String step3 = hanoi(nDisks - 1, helpPeg, toPeg);

			return step1 + step2 + step3;
		}
	}
}
