package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Class provides Stack like Push and Pop and also keeps track of max value.
 */
public class PushPopMax {
	private List<Integer> stackList = new ArrayList<>();
	private List<Integer> maxList = new ArrayList<>();
	
	public void push(int value) {
		stackList.add(value);
		
		int idx = maxList.size() - 1;
		if(idx == -1) {
			maxList.add(value);
		} else if(value > maxList.get(idx)) {
			maxList.add(value);
		}
	}
	
	public Optional<Integer> pop() {
		if(stackList.size() == 0) {
			return Optional.empty();
		}
		int idx = stackList.size() - 1;
		int poppedValue = stackList.get(idx);
		stackList.remove(idx);
		
		idx = maxList.size() - 1;
		int maxValue = maxList.get(idx);
		if(maxValue == poppedValue) {
			maxList.remove(idx);
		}
		
		return Optional.of(poppedValue);
	}

	public Optional<Integer> getMax() {
		if(maxList.size() == 0) {
			return Optional.empty();
		}
		return Optional.of(maxList.get(maxList.size() - 1));
	}
}
